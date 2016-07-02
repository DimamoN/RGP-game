/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Frames.BattleFrame;
import Game.Units.AUnit;
import Game.Units.SimpleMan;
import java.awt.EventQueue;
import javax.swing.JFrame;
import Game.*;
import Game.Items.Armor.Armor;
import Game.Items.Weapons.Weapon;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import sun.java2d.pipe.SpanShapeRenderer;

public class Main {
   
    public static void main(String[] args) throws InterruptedException {
        
    //ФРЕЙМ
            EventQueue.invokeLater(new Runnable()
        {        
        public void run(){
            //Код            
            
            //ОРУЖИЕ  NAME/DMG/WEIGHT
            Weapon dagger = new Weapon("Кинжал", 2, 1, "src\\Images\\Weapons\\dagger.png");
            Weapon sword = new Weapon("Меч", 3, 2, "src\\Images\\Weapons\\sword.png");
            Weapon pike = new Weapon("Копье", 4, 5, "src\\Images\\Weapons\\pike.png");
            Weapon longSword = new Weapon("Длинный меч", 5, 3, "src\\Images\\Weapons\\longSword.png");
            Weapon axe = new Weapon("Секира", 5, 5, "src\\Images\\Weapons\\axe.png");
            Weapon axeBig = new Weapon("Орочья секира", 6, 10, "src\\Images\\Weapons\\axeBig.png");
            Weapon axeBigDouble = new Weapon("Орочья двойная секира", 7, 14, "src\\Images\\Weapons\\axeBig.png" );
           
            //БРОНЯ  NAME/DEF/WEIGHT
            Armor leather = new Armor("Кожаная броня", 1, 2, "src\\Images\\Armor\\leather.png");
            Armor steel = new Armor("Тяжелая броня", 3, 10, "src\\Images\\Armor\\steel.png");
            Armor steelBig = new Armor("Стальная крепкая", 4, 15, "src\\Images\\Armor\\steelBig.png");
            
            //ПЕРСОНАЖИ   HP/STR/AGL
            AUnit soldier = new SimpleMan("Пехотинец", 50, 3, 4,  "src\\Images\\Units\\soldierMid.png", sword, leather);             
            AUnit soldierHeavy = new SimpleMan("Тяжелый пехотинец", 65, 4, 2, "src\\Images\\Units\\soldierHeavy.png", longSword, steel);
            AUnit ork = new SimpleMan("Орк", 60, 5, 1, "src\\Images\\Units\\orkLight.png", axeBig, leather);
            AUnit ogr = new SimpleMan("Огр", 120, 7, 0, "src\\Images\\Units\\ogr.png", axeBig, steelBig);
            AUnit dwarf = new SimpleMan("Дворф", 30, 1, 7, "src\\Images\\Units\\dwarf.png", pike, steel);
                  
            //Новый стиль
            BattleFrame battleFrame = new BattleFrame(soldierHeavy, ork);
            
        }
        
    });
    
    
    
    
    
    
    }
    
}
