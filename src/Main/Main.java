/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Game.Units.AUnit;
import Game.Units.SimpleMan;
import java.awt.EventQueue;
import javax.swing.JFrame;
import Game.*;
import Game.Items.Weapons.Weapon;

public class Main {
    
    //Битва с выводом победителей
    public static void fightWithLog(AUnit one, AUnit two) throws InterruptedException{
    
    //Начало битвы
    System.out.println("******\nБитва между "+one.getName()+" и "+two.getName()+"\n******\n");
       
    Game game = new Game();   
    
    if (game.fight(one, two))
            System.out.println("\n*** Конец Боя ***\n Победитель "+one.getName());
    else
        System.out.println("\n*** Конец Боя ***\n Победитель "+two.getName());
    
    System.out.println("\n*** Статистика Боя ***");
    one.BattleFinalInfo();
    two.BattleFinalInfo();  
   
    }
    
    public static void main(String[] args) throws InterruptedException {
        
//        EventQueue.invokeLater(new Runnable()
//        {        
//        public void run(){
//            
//            MyJFrame mainFrame = new MyJFrame();
//            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            mainFrame.setVisible(true);
//            mainFrame.setLocation(300, 300);  
//            mainFrame.setTitle("Симулятор Х");
//        }
//        
//    });


    //ОРУЖИЕ  NAME//DMG//WEIGHT
    Weapon dagger = new Weapon("Кинжал", 2, 1);
    Weapon sword = new Weapon("Меч", 3, 2);
    Weapon longSword = new Weapon("Длинный меч", 5, 3);
    Weapon axe = new Weapon("Секира", 6, 5);
    
    
    //ПЕРСОНАЖИ    //HP/STR/AGL/
    AUnit One = new SimpleMan("Rustie", 48, 3, 6);    
    AUnit Two = new SimpleMan("Ulman", 56, 5, 3);
    
//    System.out.println(dagger);
//    System.out.println(sword);
//    System.out.println(longSword);
//    System.out.println(axe);
    
    
    One.addWeapon(longSword);
    Two.addWeapon(axe);
    
    fightWithLog(One, Two);
      
    }
    
}
