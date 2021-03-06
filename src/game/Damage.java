/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 * @author DimamoN
 */
public class Damage {

    //Величина урона
    private int weaponDmg;
    //Бонус от силы
    private int strBonus;
    //Защита цели
    private int defence;
    //Является ли промахом
    private boolean miss;
    //Является ли критическим
    private boolean critical;

    
    public Damage() {
    }

    public Damage(int weaponDmg, int strBonus, boolean isCritical) {
        this.weaponDmg = weaponDmg;
        this.strBonus = strBonus;
        this.critical = isCritical;
    }

    public int getWeaponDmg() {
        return weaponDmg;
    }

    public void setWeaponDmg(int dmg) {
        this.weaponDmg = dmg;
    }

    public void setDefence(int Def) {
        this.defence = Def;
    }

    public int getDefence() {
        return defence;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean isCritical) {
        this.critical = isCritical;
    }

    public void setStrBonus(int strBonus) {
        this.strBonus = strBonus;
    }

    public void setIsMiss(boolean isMiss) {
        this.miss = isMiss;
    }

    //Общий урон, с учетом наличия крита и промаха
    public int getAllDmg() {
        //Если не промах
        if (!miss) {
            if (critical)
                return (weaponDmg + strBonus) * 2 - this.defence;
            else
                return weaponDmg + strBonus - this.defence;
        }
        //Если промах
        else return 0;
    }

    public boolean isMiss() {
        return miss;
    }


}
