/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.factories;

import game.items.weapons.Weapon;
import game.units.AbstractUnit;
import game.units.status.BleedingEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DimamoN
 */
public class WeaponFactory {

    private List<Weapon> weapons = new ArrayList<>();

    {
        Weapon dagger = new Weapon("Кинжал", 2, 1, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/dagger.png");
        Weapon hammer = new Weapon("Молоток", 2, 1, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/hammer.png");
        Weapon sword = new Weapon("Меч", 3, 2, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/sword.png");
        Weapon pike = new Weapon("Копье", 4, 5, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/pike.png");
        Weapon longSword = new Weapon("Длинный меч", 5, 3, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/longSword.png");
        Weapon axe = new Weapon("Секира", 5, 5, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/axe.png");
        Weapon orkAxe = new Weapon("Орочья секира", 6, 10, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/axeBig.png");
        Weapon orkAxeBig = new Weapon("Орочья двойная секира", 7, 14, new BleedingEffect("Кровотечение", 2, 5), "/img/weapons/axeBigDouble.png");

        weapons.add(dagger);
        weapons.add(hammer);
        weapons.add(sword);

        weapons.add(pike);
        weapons.add(longSword);

        weapons.add(axe);
        weapons.add(orkAxe);
        weapons.add(orkAxeBig);
    }

    public WeaponFactory() {
    }

    public Weapon getDagger() {
        return weapons.get(0);
    }

    public Weapon getHammer() {
        return weapons.get(1);
    }

    public Weapon getSword() {
        return weapons.get(2);
    }

    public Weapon getPike() {
        return weapons.get(3);
    }

    public Weapon getLongSword() {
        return weapons.get(4);
    }

    public Weapon getAxe() {
        return weapons.get(5);
    }

    public Weapon getOrkAxe() {
        return weapons.get(6);
    }

    public Weapon getOrkAxeBig() {
        return weapons.get(7);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public String[] getNames() {
        return weapons.stream()
                .map(Weapon::getName)
                .collect(Collectors.toList())
                .toArray(new String[weapons.size()]);
    }


}
