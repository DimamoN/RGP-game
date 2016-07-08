/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Units.AUnit;
import Game.Units.SimpleMan;
import Game.Units.Status.RegenerationEffect;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author DimamoN
 */
public class UnitFactory {
    
    WeaponFactory weapon = new WeaponFactory();
    ArmorFactory armor = new ArmorFactory();
    
    ArrayList<AUnit> units = new ArrayList();
    
    //TEST
    HashMap<String, AUnit> unitMap = new HashMap<>();
    
    
    {
         AUnit soldier = new SimpleMan("Пехотинец", 50, 3, 3,  "/img/units/soldierMid.png", weapon.getSword(), armor.getSteelLight());             
         AUnit soldierHeavy = new SimpleMan("Тяж. пехотинец", 65, 4, 2, "/img/units/soldierHeavy.png", weapon.getLongSword(), armor.getSteel());
        
         AUnit ork = new SimpleMan("Орк", 60, 5, 1, "/img/units/orkLight.png", weapon.getAxe(), armor.getLeather());
         
         //TEST
         ork.getStatus().addEffect(new RegenerationEffect("М. Регенерация", 10, 2));
         
         
         AUnit ogr = new SimpleMan("Огр", 120, 7, 0, "/img/units/ogr.png", weapon.getOrkAxeBig(), armor.getSteel());
         
         AUnit dwarf = new SimpleMan("Дворф", 30, 1, 7, "/img/units/dwarf.png", weapon.getHammer(), armor.getNoArmor()); 
       
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
    
    public AUnit getSoldier() {
        return units.get(0).clone();
    }

    public AUnit getSoldierHeavy() {
        return units.get(1).clone();
    }
    
    public AUnit getOrk() {
        return units.get(2).clone();
    }
    
    public AUnit getOgr() {
        return units.get(3).clone();
    }
    
    public AUnit getDwarf() {
        return units.get(4).clone();
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

    public HashMap<String, AUnit> getUnitMap() {
        return unitMap;
    }
    
}
