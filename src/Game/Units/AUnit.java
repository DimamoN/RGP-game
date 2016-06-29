/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Units;

import Game.Items.Weapons.Weapon;
import java.io.Console;
import java.util.Random;

/**
 *
 * @author DimamoN
 */
abstract public class AUnit {
    
    String name; //имя 
    
    int sHp; //стартовые хитпоинты
    int hp; //текущие хитпоинты
    int str; //сила
    int def; //защита
    int agl; //ловкость (Максимум 10)
    int init; //инициатива
    
    //Оружие
    Weapon weapon;
    
    //Статистика битвы для юнита
    BattleStat unitStat;

    //Имя, ХП, Сила, Ловкость
    public AUnit(String name, int hp, int str, int agl) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;        
        unitStat = new BattleStat();
    }  

    //Имя, ХП, Сила, Ловкость, Оружие
    public AUnit(String name, int hp, int str, int agl, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;
        this.weapon = weapon;
        unitStat = new BattleStat();
    }  
    
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }    
    
    public int getDef() {
        return def;
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

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    //Атака другого юнита, возвращает нанесенный урон
    public int Attack(AUnit another){        
        
       //Нанесенный урон
       int dmg;
       
       //Если есть оружие
       if(this.weapon != null)
           dmg = this.weapon.getDmg() + this.str - another.getDef();
       //Если нет оружия
       else
           dmg = this.str-another.getDef();
       
       //Проверка на уклонение
       if (another.EvadeDice()){
           System.out.println(this.getName()+" промахивается");
           
           //Добавить промах в статистику
           this.unitStat.addMiss();           
           return 0;
       }
       
       else{           
       another.setHp(another.getHp()-dmg);
       
       //Добавить попадание в статистику
       this.unitStat.addHit();
       
       return dmg;
       }
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
    public void BattleFinalInfo(){        
        System.out.println(this.getName() + " | " + this.unitStat.getHitStat());        
    }
    
    public void addWeapon(Weapon weapon){
            this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
     
}