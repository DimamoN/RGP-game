/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.units;

import game.items.armor.Armor;
import game.items.weapons.Weapon;

/**
 * Обычный человек
 */
public class SimpleMan extends AbstractUnit {


    //Пустой
    public SimpleMan() {

    }

    public SimpleMan(String name, int hp, int str, int agl, String pathToImage, Weapon weapon, Armor armor) {
        super(name, hp, str, agl, pathToImage, weapon, armor);
    }

}
