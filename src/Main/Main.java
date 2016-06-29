/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import Game.*;

public class Main {

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


    //HP/STR/DEF (1) /AGL/INIT
    
    AUnit One = new SimpleMan("Demon",1000, 5, 1);
    
    AUnit Two = new SimpleMan("Human",1000, 5, 10);
    
    
    Game game = new Game();
    
    game.fight(One, Two);
        

        
    }
    
}
