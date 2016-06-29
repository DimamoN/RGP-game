/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Weapons;

import Game.Items.AItem;

/**
 *
 * @author DimamoN
 */
public class Weapon extends AItem{
    
    //Урон оружия
    int dmg;

    public Weapon(){
        
    }
    
    public Weapon(String name, int dmg, int weight) {
        super(name, weight);
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }
    
    @Override
    public String toString() {
        return this.getName()+", Урон: "+this.dmg + ", Вес: " + this.weight;
    }
    
    
}
