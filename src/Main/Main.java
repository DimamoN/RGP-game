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
    public static AUnit fightWithLog(AUnit one, AUnit two) throws InterruptedException{
    
    //Начало битвы
    System.out.println("\n******\nБитва между "+one.getName()+" и "+two.getName()+"\n******\n");
       
    Game game = new Game();   
    
    if (game.fight(one, two)){
            System.out.println("\n*** Конец Боя ***\n Победитель "+one.getName());
            System.out.println("\n*** Статистика Боя ***");
            one.BattleFinalInfo();
            two.BattleFinalInfo(); 
            return one;
            
            
    }
    else{
        System.out.println("\n*** Конец Боя ***\n Победитель "+two.getName());
        System.out.println("\n*** Статистика Боя ***");
        one.BattleFinalInfo();
        two.BattleFinalInfo(); 
        return two;
        
    }
        
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
    AUnit One = new SimpleMan("Чарли тупой силач", 200, 7, 0);    
    AUnit Two = new SimpleMan("Джон воин", 50, 4, 5);
    AUnit SmallMan = new SimpleMan("Карлик Барка", 30, 1, 10);
    
//    System.out.println(dagger);
//    System.out.println(sword);
//    System.out.println(longSword);
//    System.out.println(axe);
    
//    One.addWeapon(longSword);
    Two.addWeapon(longSword);
    SmallMan.addWeapon(dagger);
    
    AUnit winner = fightWithLog(One, Two);
      
    fightWithLog(SmallMan, winner);
    
    }
    
}
