/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author DimamoN
 */
public class Damage {
    
    //Величина урона
    int weaponDmg;    
    int strBonus;
    
    //Защита цели
    int Def;
    
    //Является ли промахом
    boolean isMiss;
    
    //Является ли критическим
    boolean isCritical;

    public Damage() {
    }
    
    public Damage(int weaponDmg, int strBonus, boolean isCritical) {
        this.weaponDmg = weaponDmg;
        this.strBonus = strBonus;
        this.isCritical = isCritical;
    }

    public int getWeaponDmg() {
        return weaponDmg;
    }

    public void setWeaponDmg(int dmg) {
        this.weaponDmg = dmg;
    }

    public void setDef(int Def) {
        this.Def = Def;
    }

    public int getDef() {
        return Def;
    }
    
    public boolean isCritical() {
        return isCritical;
    }
     
    public void setCritical(boolean isCritical){
        this.isCritical = isCritical;
    }

    public void setStrBonus(int strBonus) {
        this.strBonus = strBonus;
    }

    public void setIsMiss(boolean isMiss) {
        this.isMiss = isMiss;
    }
    
    //Общий урон, с учетом наличия крита и промаха
    public int getAllDmg(){
        //Если не промах
        if(!isMiss){
        if(isCritical)
            return (weaponDmg+strBonus)*2;
        else
            return weaponDmg+strBonus; 
        }
        //Если промах
        else return 0;
    }
    
}
