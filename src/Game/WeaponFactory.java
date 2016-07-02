/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Items.Weapons.Weapon;

/**
 *
 * @author DimamoN
 */
public class WeaponFactory {
    
    private Weapon dagger = new Weapon("Кинжал", 2, 1, "src\\Images\\Weapons\\dagger.png");
    private Weapon sword = new Weapon("Меч", 3, 2, "src\\Images\\Weapons\\sword.png");
    private Weapon pike = new Weapon("Копье", 4, 5, "src\\Images\\Weapons\\pike.png");
    private Weapon longSword = new Weapon("Длинный меч", 5, 3, "src\\Images\\Weapons\\longSword.png");
    private Weapon axe = new Weapon("Секира", 5, 5, "src\\Images\\Weapons\\axe.png");
    private Weapon orkAxe = new Weapon("Орочья секира", 6, 10, "src\\Images\\Weapons\\axeBig.png");
    private Weapon orkAxeBig = new Weapon("Орочья двойная секира", 7, 14, "src\\Images\\Weapons\\axeBig.png" );

    public WeaponFactory() {
    }

    public Weapon getAxe() {
        return axe;
    }

    public Weapon getDagger() {
        return dagger;
    }

    public Weapon getLongSword() {
        return longSword;
    }

    public Weapon getOrkAxeBig() {
        return orkAxeBig;
    }

    public Weapon getOrkAxe() {
        return orkAxe;
    }

    public Weapon getPike() {
        return pike;
    }

    public Weapon getSword() {
        return sword;
    }

}
