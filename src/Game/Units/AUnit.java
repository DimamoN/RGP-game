/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Units;

import Game.Damage;
import Game.Items.Armor.Armor;
import Game.Items.Weapons.Weapon;
import Game.Units.Status.BleedingEffect;
import Game.Units.Status.UnitStatus;
import java.awt.Image;
import java.io.Console;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DimamoN
 */
abstract public class AUnit {
    
    ImageIcon image; //Картинка юнита
    
    String name; //имя 
    
    int sHp; //стартовые хитпоинты
    
    int hp; //текущие хитпоинты
    int str; //сила    
    int agl; //ловкость (Максимум 10)
    int init; //инициатива
    
    int critChance = 3; //Базовый шанс крита
    
    //Оружие
    Weapon weapon;
    
    //Защита
    Armor armor;
    
    //Статус юнита
    UnitStatus status;
    
    //Статистика битвы для юнита
    BattleStat unitStat;

    //Расположение в битве
    boolean attacking;

    //Пустой конструктор
    public AUnit(){
        
    }
    
    //Имя, ХП, Сила, Ловкость
    public AUnit(String name, int hp, int str, int agl) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;
        this.weapon = new Weapon();
        this.armor = new Armor("Без защиты", 0, 0);
        
        this.image = new ImageIcon(this.getClass().getResource("/img/units/null.png"));
    
        status = new UnitStatus();
        unitStat = new BattleStat();
    }
    
    //С картинкой
    public AUnit(String name, int hp, int str, int agl, String pathToImage) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;
        this.weapon = new Weapon();
        this.armor = new Armor("Без защиты", 0, 0);
        
        this.image = new ImageIcon(this.getClass().getResource(pathToImage));
        
        status = new UnitStatus();
        unitStat = new BattleStat();
    }  

    //Имя, ХП, Сила, Ловкость, Оружие, Доспехи
    public AUnit(String name, int hp, int str, int agl, String pathToImage, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;
        this.weapon = weapon;
        this.armor = armor;
        
        //Не работает в методе clone()
        this.image = new ImageIcon(this.getClass().getResource(pathToImage));

        status = new UnitStatus();
        unitStat = new BattleStat();
    }  
    
    //Конструктор для Clone();
    public AUnit(String name, int hp, int str, int agl, ImageIcon img, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;
        this.weapon = weapon;
        this.armor = armor;
        
        this.image = img;

        status = new UnitStatus();
        unitStat = new BattleStat();
    }  
    
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }    
    
    public int getDef() {
        return this.armor.getDef();
    }

    public int getAgl() {
        return agl;
    }

    public int getInit() {
        return init;
    }

    public int getStr() {
        return str;
    }

    //Установить текущее хп
    public void setHp(int hp) {
        this.hp = hp;
    }

    //Установить стартовое хп
    public void setsHp(int sHp) {
        this.hp = sHp;
        this.sHp = sHp;
    }
    
    //Установка урона, который нанесет данный юнит (Weapon,Crit,Str)
    public Damage getDmg(){
        Random rnd = new Random();
        
        Damage damage = new Damage();
        
        //Установить dmg, равный атаке оружия
        damage.setWeaponDmg(weapon.getDmg());
        
        //Добавить бонус силы
        damage.setStrBonus(this.str);
        
        //Рассчет шанса крита ( 3 процента + ловкость * 2 )
        if((rnd.nextInt(100)+1) < this.critChance + this.agl*2){
            damage.setCritical(true);            
        }
        
        return damage;
    }
    
    //Атака другого юнита, возвращает нанесенный урон
    public Damage Attack(AUnit another){        
        
       //Нанесенный урон
       Damage Dmg = this.getDmg();
       
       //Добавляем броню противника
       Dmg.setDef(another.getDef());
 
       //Если противник успешно уклонился
       if (another.EvadeDice()){           
          
           //Добавить промах в статистику
           this.unitStat.addMiss(); 
           
           //Устанавливаем промах
           Dmg.setIsMiss(true);
       }
       
       //Если противник не уклонился
       else{
           //Отнять хп противнику
           another.setHp(another.getHp()-Dmg.getAllDmg());
           //Добавить попадание в статистику
           this.unitStat.addHit();
       }
       
       //если крит -> добавить эффект оружия
       if(Dmg.isCritical())
           another.getStatus().addEffect(this.getWeapon().getResetEffect());
       
       
       return Dmg;
    }

    public boolean isAlive(){
        return hp>0;
    }   
    
    //Шанс уклониься, в завимимости от ловкости
    private boolean EvadeDice(){
        switch(this.agl){
            case 0: return false;
            case 1: return getChance(5);
            case 2: return getChance(10);
            case 3: return getChance(15);
            case 4: return getChance(20);
            case 5: return getChance(30);
            case 6: return getChance(40);
            case 7: return getChance(50);
            case 8: return getChance(60);
            case 9: return getChance(70);
            case 10: return getChance(80);            
            default: return true;
        }
    }
    
    //Указываем шанс на true
    private boolean getChance(int percent){
         Random rnd = new Random();
         
         int hundred = rnd.nextInt(100)+1;
         
         if(hundred < percent) return true;
         else return false;        
    }
    
    //Рандом от 1 до number, Успех если rnd == number    DONT USE!!!
    private boolean Dice(int number){
        Random rnd = new Random();
        
        if (number == 1){
           if ((rnd.nextInt(10) + 1) < 10) return true;
           else return false;
        }
        
        if ((rnd.nextInt(number) + 1) == number) return true;        
        else return false;         
    }
    
    //Инфомация для боя
    public String BattleInfo(){
        return this.getName()+" HP: "+this.hp+" ("+this.sHp+")";
    }
    
    //Информация по концу боя про попадания и уклонения
    public String BattleFinalInfo(){        
        return this.getName() + " | " + this.unitStat.getHitStat();        
    }
    
    //Восстановить хп
    public void resetHealth(){  
        this.hp = this.sHp;   
    }
    
    public void addWeapon(Weapon weapon){
            this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
     
    public void addArmor(Armor armor){
        this.armor = armor;
    }
    
    public Armor getArmor(){
        return this.armor;
    }    

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setAgl(int agl) {
        this.agl = agl;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ImageIcon getImage() {
        return image;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public BattleStat getUnitStat() {
        return unitStat;
    }

    public int getsHp() {
        return sHp;
    }

    public UnitStatus getStatus() {
        return status;
    }
    
    public AUnit clone(){
        AUnit clone = new AUnit(this.getName(),this.getsHp(), this.getStr(), this.getAgl(),
                this.getImage(), this.getWeapon().clone(), this.getArmor().clone()){};
        
        clone.setStatus(this.getStatus());
        
        return clone;
    }

    public void setStatus(UnitStatus status) {
        this.status = status;
    }
    
    //Вся информация о юните
    public String getAllStat(){        
        return getName()+" | Урон "+(this.str+this.getWeapon().getDmg())+" | Защита: "
                +this.getDef() + " | "+(this.getWeapon().getName())+" | "+this.getArmor().getName();
    }
    
}
