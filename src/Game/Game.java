/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.io.Console;
import java.util.Random;

/**
 *
 * @author DimamoN
 */
public class Game {
   
   //ход в бою
   int turn = 1;

    public boolean fight(AUnit one, AUnit two) throws InterruptedException{
              
        while(one.getHp()>0 && two.getHp()>0){ 
            
            round(one,two);
            
//            Thread.sleep(500);
        }          
        
        one.BattleFinalInfo();
        two.BattleFinalInfo();        
       
        //обнуляем ход
        turn = 0;

        //Если у первого есть хп - он победил
        return one.getHp()>0;        
    }
    
    //Первый опонент атакует
    void round(AUnit one, AUnit two){ 
        
        System.out.println("*** "+ turn + " ход ***");
        System.out.println(one.BattleInfo());
        System.out.println(two.BattleInfo());
        
        //Сверяем инициативу для первого удара
        if(one.getInit()>two.getInit()){ 
            
            AttackAfterInit(one, two);               
        }        
        
        else if (two.getInit()>one.getInit()){
            
            AttackAfterInit(two, one);
        }
        
        else if (one.getInit()==two.getInit()){
            
            Random rnd = new Random();
            if(rnd.nextBoolean()) AttackAfterInit(one, two);
            else AttackAfterInit(two, one);            
        }
        
        //Увеличиваем ход, и добавляем пустую строку
        turn++;
         System.out.println();
    }
    
    //Если урон есть - он отображается
    private void AttackLog(AUnit one, AUnit two){  
        
        int dmg = one.Attack(two);
        
        if(dmg > 0)
            System.out.println(one.getName()+" нанес "+ dmg +" урона");        
    }
 
    //Порядок атак, после сверения инициативы
    private void AttackAfterInit(AUnit one, AUnit two){ 
        
        //1 потом 2
            AttackLog(one, two);
            
            //Если второй после удара жив, то он атакует в ответ
            if(two.isAlive()){
            
                //Атакует второй
                AttackLog(two, one);
                
                if(!one.isAlive()) System.out.println(one.getName()+" умер"); 
            }
            
            else System.out.println(two.getName()+" умер");
    }   
}
