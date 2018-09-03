/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.factories;

import game.items.armor.Armor;
import game.units.AbstractUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DimamoN
 */
public class ArmorFactory {

    private List<Armor> armors = new ArrayList<>();

    {
        Armor noArmor = new Armor("Без брони", 0, 0, "/img/armor/noArmor.png");
        Armor leather = new Armor("Кожаная броня", 1, 2, "/img/armor/leather.png");
        Armor steelLight = new Armor("Стальная легкая", 2, 6, "/img/armor/steelLight.png");
        Armor steel = new Armor("Стальная броня", 3, 10, "/img/armor/steel.png");
        Armor steelStrong = new Armor("Стальная крепкая", 4, 15, "/img/armor/steelStrong.png");

        armors.add(noArmor);
        armors.add(leather);
        armors.add(steelLight);
        armors.add(steel);
        armors.add(steelStrong);
    }

    public ArmorFactory() {
    }

    public Armor getNoArmor() {
        return armors.get(0);
    }

    public Armor getLeather() {
        return armors.get(1);
    }

    public Armor getSteelLight() {
        return armors.get(2);
    }

    public Armor getSteel() {
        return armors.get(3);
    }

    public Armor getSteelStrong() {
        return armors.get(4);
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public String[] getNames() {
        return armors.stream()
                .map(Armor::getName)
                .collect(Collectors.toList())
                .toArray(new String[armors.size()]);
    }

}
