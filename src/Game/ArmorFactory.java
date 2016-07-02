/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Items.Armor.Armor;

/**
 *
 * @author DimamoN
 */
public class ArmorFactory {
    
    
    private Armor noArmor = new Armor("Без брони", 0, 0, "src\\Images\\Armor\\noArmor.png");
    private Armor leather = new Armor("Кожаная броня", 1, 2, "src\\Images\\Armor\\leather.png");
    private Armor steel = new Armor("Тяжелая броня", 3, 10, "src\\Images\\Armor\\steel.png");
    private Armor steelStrong = new Armor("Стальная крепкая", 4, 15, "src\\Images\\Armor\\steelStrong.png");

    public ArmorFactory() {
    }

    public Armor getNoArmor() {
        return noArmor;
    }

    public Armor getLeather() {
        return leather;
    }

    public Armor getSteel() {
        return steel;
    }

    public Armor getSteelStrong() {
        return steelStrong;
    }
}
