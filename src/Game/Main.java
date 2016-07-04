/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Frames.BattleFrame;
import Frames.GameMap;
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
        
            EventQueue.invokeLater(new Runnable()
        {        
        public void run(){

            UnitFactory unit = new UnitFactory();
            
            
            GameMap map = new GameMap();
            
  
//            BattleFrame battleFrame = new BattleFrame(unit.getSoldierHeavy(), unit.getOrk());
        }
        
    });
    
    }
    
}
