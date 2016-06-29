/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Units.AUnit;
import java.io.Console;
import java.util.Random;
import Game.Units.*;

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
            
//            Thread.sleep(1500);
        }          
        
        //обнуляем ход
        turn = 0;
        
        
        //Если у первого есть хп - он победил
        return one.isAlive();        
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
    
    //Если урон есть - он отображается (Индикация урона)
    private void AttackLog(AUnit one, AUnit two){  
        
        //Сама атака и возвращение урона 
        Damage Dmg = one.Attack(two);
        
        //Если попал
        if(!Dmg.isMiss){
            
            //Если критический
            if(Dmg.isCritical){
                
                //Если есть оружие
                if(Dmg.weaponDmg > 0)                               
                    System.out.println(one.getName()+" нанес "+Dmg.getAllDmg()+" урона критическим "
                            + "ударом используя "+one.getWeapon().getName());
                //Если нет оружия
                else
                    System.out.println(one.getName()+" нанес "+Dmg.getAllDmg()+" урона критическим "
                            + "ударом");
            }    
            //Если не критический
            else{
                //Если есть оружие
                if(Dmg.weaponDmg > 0)
                    System.out.println(one.getName()+" нанес "+Dmg.getAllDmg()+" урона "
                            + "используя "+one.getWeapon().getName());
                //Если нет оружия
                else
                    System.out.println(one.getName()+" нанес "+Dmg.getAllDmg()+" урона");                    
                }
        }
            
        //Если промахнулся
        else
            System.out.println(one.getName()+" промахнулся");
        
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

