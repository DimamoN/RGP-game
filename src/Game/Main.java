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

public class Main {
   
    public static void main(String[] args) throws InterruptedException {
        
    //ФРЕЙМ
            EventQueue.invokeLater(new Runnable()
        {        
        public void run(){
            //Код            
            //ОРУЖИЕ  NAME/DMG/WEIGHT
            Weapon dagger = new Weapon("Кинжал", 2, 1);
            Weapon sword = new Weapon("Меч", 3, 2);
            Weapon longSword = new Weapon("Длинный меч", 5, 3);
            Weapon axe = new Weapon("Секира", 6, 5);

            //БРОНЯ  NAME/DEF/WEIGHT
            Armor lightArmor = new Armor("Легкая броня", 1, 2);
            Armor heavyArmor = new Armor("Тяжелая броня", 3, 10);

            //ПЕРСОНАЖИ   HP/STR/AGL
//            AUnit Light = new SimpleMan("Легкий пехотинец", 40, 2, 6);
            AUnit Standart = new SimpleMan("Пехотинец", 50, 3, 4);  
            
            Standart.setImage(new ImageIcon("src\\Images\\soldierMid.png"));
            
            AUnit Heavy = new SimpleMan("Тяжелый пехотинец", 80, 4, 1);
//            Standart.setImage(new ImageIcon("Images\\soldierHeavy.png"));
                      
            Standart.addArmor(lightArmor);
            Heavy.addArmor(heavyArmor);

//            Light.addWeapon(dagger);

            Standart.addWeapon(sword);
            Heavy.addWeapon(longSword);
            
            Game game = new Game();            
            
            game.fightWithLog(Standart, Heavy);
                 
        }
        
    });
    
    
    
    
    
    
    }
    
}
