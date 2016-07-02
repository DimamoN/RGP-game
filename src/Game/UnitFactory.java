/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Units.AUnit;
import Game.Units.SimpleMan;

/**
 *
 * @author DimamoN
 */
public class UnitFactory {
    
    WeaponFactory weapon = new WeaponFactory();
    
    ArmorFactory armor = new ArmorFactory();
    
    //Фабрика юнитов
    AUnit soldier = new SimpleMan("Пехотинец", 50, 3, 4,  "src\\Images\\Units\\soldierMid.png", weapon.getSword(), armor.getLeather());             
    AUnit soldierHeavy = new SimpleMan("Тяжелый пехотинец", 65, 4, 2, "src\\Images\\Units\\soldierHeavy.png", weapon.getLongSword(), armor.getLeather());
    AUnit ork = new SimpleMan("Орк", 60, 5, 1, "src\\Images\\Units\\orkLight.png", weapon.getAxe(), armor.getLeather());
    AUnit ogr = new SimpleMan("Огр", 120, 7, 0, "src\\Images\\Units\\ogr.png", weapon.getAxe(), armor.getSteel());
    AUnit dwarf = new SimpleMan("Дворф", 30, 1, 7, "src\\Images\\Units\\dwarf.png", weapon.getPike(), armor.getNoArmor());  
    
    public UnitFactory() {
        
    }

    public AUnit getOgr() {
        return ogr;
    }

    public AUnit getOrk() {
        return ork;
    }

    public AUnit getSoldier() {
        return soldier;
    }

    public AUnit getSoldierHeavy() {
        return soldierHeavy;
    }

    public AUnit getDwarf() {
        return dwarf;
    }
      
}
