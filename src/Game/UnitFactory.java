/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Units.AUnit;
import Game.Units.SimpleMan;
import java.util.ArrayList;

/**
 *
 * @author DimamoN
 */
public class UnitFactory {
    
    WeaponFactory weapon = new WeaponFactory();
    ArmorFactory armor = new ArmorFactory();
    
    ArrayList<AUnit> units = new ArrayList();
   
    {
         AUnit soldier = new SimpleMan("Пехотинец", 50, 3, 3,  "src\\Images\\Units\\soldierMid.png", weapon.getSword(), armor.getSteelLight());             
         AUnit soldierHeavy = new SimpleMan("Тяжелый пехотинец", 65, 4, 2, "src\\Images\\Units\\soldierHeavy.png", weapon.getLongSword(), armor.getSteel());
        
         AUnit ork = new SimpleMan("Орк", 60, 5, 1, "src\\Images\\Units\\orkLight.png", weapon.getAxe(), armor.getLeather());
         AUnit ogr = new SimpleMan("Огр", 120, 7, 0, "src\\Images\\Units\\ogr.png", weapon.getOrkAxeBig(), armor.getSteel());
         
         AUnit dwarf = new SimpleMan("Дворф", 30, 1, 7, "src\\Images\\Units\\dwarf.png", weapon.getHammer(), armor.getNoArmor()); 
       
         units.add(soldier);
         units.add(soldierHeavy);
         units.add(ork);
         units.add(ogr);
         units.add(dwarf);
    }
    
    //Фабрика юнитов
    public UnitFactory() {
        
    }
    
    public AUnit getSoldier() {
        return units.get(0);
    }

    public AUnit getSoldierHeavy() {
        return units.get(1);
    }
    
    public AUnit getOrk() {
        return units.get(2);
    }
    
    public AUnit getOgr() {
        return units.get(3);
    }
    
    public AUnit getDwarf() {
        return units.get(4);
    }
      
    public String[] getNames(){
        
        //Массив имен
        String[] names = new String[units.size()];
        
        for(int i=0; i < units.size(); i++)
            names[i] = units.get(i).getName();
        
        return names;
    }

    public ArrayList<AUnit> getUnits() {
        return units;
    }
 
}
