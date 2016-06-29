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
import Game.Items.Armor.Armor;
import Game.Items.Weapons.Weapon;

public class Main {
    
    //Битва с выводом победителей
    public static AUnit fightWithLog(AUnit one, AUnit two) throws InterruptedException{
    
    //Начало битвы
    System.out.println("\n******\nБитва между "+one.getName()+" и "+two.getName());     
    System.out.println(one.getAllStat());
    System.out.println(two.getAllStat());
    System.out.println("******\n");
    
    
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

    //ОРУЖИЕ  NAME/DMG/WEIGHT
    Weapon dagger = new Weapon("Кинжал", 2, 1);
    Weapon sword = new Weapon("Меч", 3, 2);
    Weapon longSword = new Weapon("Длинный меч", 5, 3);
    Weapon axe = new Weapon("Секира", 6, 5);
    
//    System.out.println(dagger);
//    System.out.println(sword);
//    System.out.println(longSword);
//    System.out.println(axe);
    
    //Броня  NAME/DEF/WEIGHT
    Armor lightArmor = new Armor("Легкая броня", 1, 2);
    Armor heavyArmor = new Armor("Тяжелая броня", 3, 10);
    
    //ПЕРСОНАЖИ   HP/STR/AGL
    
    AUnit Light = new SimpleMan("Легкий пехотинец", 40, 2, 6);
    AUnit Standart = new SimpleMan("Пехотинец", 50, 3, 4);    
    AUnit Heavy = new SimpleMan("Тяжелый пехотинец", 80, 4, 1);
    
    Standart.addArmor(lightArmor);
    Heavy.addArmor(heavyArmor);
    
    Light.addWeapon(dagger);
    Standart.addWeapon(sword);
    Heavy.addWeapon(longSword);
    
    fightWithLog(Standart, Heavy);
    
    }
    
}
