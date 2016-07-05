/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Weapons;

import Game.Items.AItem;
import Game.Units.Status.AUnitEffect;

/**
 *
 * @author DimamoN
 */
public class Weapon extends AItem{
    
    //Урон оружия
    int dmg;
    
    //Эффект который наносит оружие при крите
    AUnitEffect effect;
    
    public Weapon(){
        
    }
    
    public Weapon(String name, int dmg, int weight, AUnitEffect effect, String pathToImage) {
        super(name, weight, pathToImage);
        this.dmg = dmg;
        this.effect = effect;
    }

    public int getDmg() {
        return dmg;
    }
    
    @Override
    public String toString() {
        return this.getName()+", Урон: "+this.dmg + ", Вес: " + this.weight;
    }

    public AUnitEffect getEffect() {
        return effect;
    }
    
    //Вернуть обновленный эффент - вызывается в Атаке Юнита
    public AUnitEffect getResetEffect(){
        effect.resetEffect();
        return effect;      
    }
    
    
       
    
}
