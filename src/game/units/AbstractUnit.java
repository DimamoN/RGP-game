/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.units;

import game.Damage;
import game.items.armor.Armor;
import game.items.weapons.Weapon;
import game.units.status.UnitStatus;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 * @author DimamoN
 */
abstract public class AbstractUnit {

    private ImageIcon image; //Картинка юнита
    private String name; //имя

    private int sHp; //стартовые хитпоинты
    private int hp; //текущие хитпоинты
    private int str; //сила
    private int agl; //ловкость (Максимум 10)
    private int init; //инициатива
    private int critChance = 3; //Базовый шанс крита

    private Weapon weapon;
    private Armor armor;

    //Статус юнита
    private UnitStatus status;
    //Статистика битвы для юнита
    private BattleStat unitStat;
    //Расположение в битве
    private boolean attacking;

    //Пустой конструктор
    public AbstractUnit() {

    }

    //Имя, ХП, Сила, Ловкость
    public AbstractUnit(String name, int hp, int str, int agl) {
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
    public AbstractUnit(String name, int hp, int str, int agl, String pathToImage) {
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
    public AbstractUnit(String name, int hp, int str, int agl, String pathToImage, Weapon weapon, Armor armor) {
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
    public AbstractUnit(String name, int hp, int str, int agl, ImageIcon img, Weapon weapon, Armor armor) {
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
        return this.armor.getDefence();
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
    public Damage getDmg() {

        Damage damage = new Damage();

        //Установить dmg, равный атаке оружия
        damage.setWeaponDmg(weapon.getDamage());

        //Добавить бонус силы
        damage.setStrBonus(this.str);

        //Рассчет шанса крита ( 3 процента + ловкость * 2 )
        if ((new Random().nextInt(100) + 1) < this.critChance + this.agl * 2) {
            damage.setCritical(true);
        }

        return damage;
    }

    //Атака другого юнита, возвращает нанесенный урон
    public Damage Attack(AbstractUnit another) {

        //Нанесенный урон
        Damage dmg = this.getDmg();

        //Добавляем броню противника
        dmg.setDefence(another.getDef());

        //Если противник успешно уклонился
        if (another.EvadeDice()) {

            //Добавить промах в статистику
            this.unitStat.addMiss();

            //Устанавливаем промах
            dmg.setIsMiss(true);
        }

        //Если противник не уклонился
        else {
            //Отнять хп противнику
            another.setHp(another.getHp() - dmg.getAllDmg());
            //Добавить попадание в статистику
            this.unitStat.addHit();
        }

        //если крит -> добавить эффект оружия
        if (dmg.isCritical())
            another.getStatus().addEffect(this.getWeapon().getResetEffect());

        return dmg;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    //Шанс уклониься, в завимимости от ловкости
    private boolean EvadeDice() {
        switch (this.agl) {
            case 0:
                return false;
            case 1:
                return getChance(5);
            case 2:
                return getChance(10);
            case 3:
                return getChance(15);
            case 4:
                return getChance(20);
            case 5:
                return getChance(30);
            case 6:
                return getChance(40);
            case 7:
                return getChance(50);
            case 8:
                return getChance(60);
            case 9:
                return getChance(70);
            case 10:
                return getChance(80);
            default:
                return true;
        }
    }

    //Указываем шанс на true
    private boolean getChance(int percent) {
        int hundred = new Random().nextInt(100) + 1;
        return hundred < percent;
    }

    //Рандом от 1 до number, Успех если rnd == number    DONT USE!!!
    private boolean Dice(int number) {
        Random rnd = new Random();
        if (number == 1) {
            return (rnd.nextInt(10) + 1) < 10;
        }
        return (rnd.nextInt(number) + 1) == number;
    }

    //Инфомация для боя
    public String BattleInfo() {
        return this.getName() + " HP: " + this.hp + " (" + this.sHp + ")";
    }

    //Информация по концу боя про попадания и уклонения
    public String BattleFinalInfo() {
        return this.getName() + " | " + this.unitStat.getHitStat();
    }

    //Восстановить хп
    public void resetHealth() {
        this.hp = this.sHp;
    }

    public void addWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void addArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
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

    public AbstractUnit clone() {
        AbstractUnit clone = new AbstractUnit(this.getName(), this.getsHp(), this.getStr(), this.getAgl(),
                this.getImage(), this.getWeapon().clone(), this.getArmor().clone()) {
        };

        clone.setStatus(this.getStatus());

        return clone;
    }

    public void setStatus(UnitStatus status) {
        this.status = status;
    }

    //Вся информация о юните
    public String getAllStat() {
        return getName() + " | Урон " + (this.str + this.getWeapon().getDamage()) + " | Защита: "
                + this.getDef() + " | " + (this.getWeapon().getName()) + " | " + this.getArmor().getName();
    }

}
