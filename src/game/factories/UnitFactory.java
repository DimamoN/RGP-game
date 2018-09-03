/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.factories;

import game.units.AbstractUnit;
import game.units.SimpleMan;
import game.units.status.RegenerationEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DimamoN
 */
public class UnitFactory {

    private WeaponFactory weapon = new WeaponFactory();
    private ArmorFactory armor = new ArmorFactory();

    private List<AbstractUnit> units = new ArrayList<>();

    //TEST
    private HashMap<String, AbstractUnit> unitMap = new HashMap<>();


    {
        AbstractUnit soldier = new SimpleMan("Пехотинец", 50, 3, 3, "/img/units/soldierMid.png", weapon.getSword(), armor.getSteelLight());
        AbstractUnit soldierHeavy = new SimpleMan("Тяж. пехотинец", 65, 4, 2, "/img/units/soldierHeavy.png", weapon.getLongSword(), armor.getSteel());

        AbstractUnit ork = new SimpleMan("Орк", 60, 5, 1, "/img/units/orkLight.png", weapon.getAxe(), armor.getLeather());

        //TEST
        ork.getStatus().addEffect(new RegenerationEffect("М. Регенерация", 10, 2));


        AbstractUnit ogr = new SimpleMan("Огр", 120, 7, 0, "/img/units/ogr.png", weapon.getOrkAxeBig(), armor.getSteel());

        AbstractUnit dwarf = new SimpleMan("Дворф", 30, 1, 7, "/img/units/dwarf.png", weapon.getHammer(), armor.getNoArmor());

        units.add(soldier);
        units.add(soldierHeavy);
        units.add(ork);
        units.add(ogr);
        units.add(dwarf);


        //TEST
        unitMap.put(soldier.getName(), soldier);
        unitMap.put(soldierHeavy.getName(), soldierHeavy);
        unitMap.put(ork.getName(), ork);
        unitMap.put(ogr.getName(), ogr);
        unitMap.put(dwarf.getName(), dwarf);

    }

    //Фабрика юнитов
    public UnitFactory() {

    }

    public AbstractUnit getSoldier() {
        return units.get(0).clone();
    }

    public AbstractUnit getSoldierHeavy() {
        return units.get(1).clone();
    }

    public AbstractUnit getOrk() {
        return units.get(2).clone();
    }

    public AbstractUnit getOgr() {
        return units.get(3).clone();
    }

    public AbstractUnit getDwarf() {
        return units.get(4).clone();
    }

    public String[] getNames() {
        return units.stream()
                .map(AbstractUnit::getName)
                .collect(Collectors.toList())
                .toArray(new String[units.size()]);
    }

    public List<AbstractUnit> getUnits() {
        return units;
    }

    public HashMap<String, AbstractUnit> getUnitMap() {
        return unitMap;
    }

}
