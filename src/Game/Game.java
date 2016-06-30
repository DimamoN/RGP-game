/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Frames.BattleFrame;
import Game.Units.AUnit;
import java.io.Console;
import java.util.Random;
import Game.Units.*;
import javax.swing.JFrame;

/**
 *
 * @author DimamoN
 */
public class Game {
   
    private BattleFrame battleFrame;
    
   //ход в бою
   int turn = 1;

   //На этом фрейме будет отображаться битва
    public Game() {        
        battleFrame = new BattleFrame();
        battleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleFrame.setVisible(true);
        battleFrame.setLocation(300, 300);  
        battleFrame.setTitle("RPG GAME");        
    }
   
    //Битва с выводом победителей
    public AUnit fightWithLog(AUnit one, AUnit two){
    
    //Начало битвы вывод в фрейм
    
    battleFrame.addBattleLog("******\nБитва между "+one.getName()+" и "+two.getName());
    battleFrame.addBattleLog(one.getAllStat());
    battleFrame.addBattleLog(two.getAllStat());
    battleFrame.addBattleLog("******\n");
    
    
    if (this.fight(one, two)){
        battleFrame.addBattleLog("*** Конец Боя ***\n Победитель "+one.getName());
        battleFrame.addBattleLog("\n*** Статистика Боя ***");
        battleFrame.addBattleLog(one.BattleFinalInfo());
        battleFrame.addBattleLog(two.BattleFinalInfo());
        return one;  
    }
    else{        
        battleFrame.addBattleLog("\n*** Конец Боя ***\n Победитель "+two.getName());
        battleFrame.addBattleLog("\n*** Статистика Боя ***");
        battleFrame.addBattleLog(one.BattleFinalInfo());
        battleFrame.addBattleLog(two.BattleFinalInfo());        
        return two;        
    }       
    }
    
    //Битва, победитель 1 - true, 2 - false
    public boolean fight(AUnit one, AUnit two){
 
        while(one.getHp()>0 && two.getHp()>0){ 
            
            round(one,two);
            
//            Thread.sleep(1500);
        }          
        
        //обнуляем ход
        turn = 1;
        
        
        //Если у первого есть хп - он победил
        return one.isAlive();        
    }
    
    //Первый опонент атакует
    void round(AUnit one, AUnit two){ 
        
        battleFrame.addBattleLog("*** "+ turn + " ход ***");
        battleFrame.addBattleLog(one.BattleInfo());
        battleFrame.addBattleLog(two.BattleInfo());
        
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
        
       //Переход на след. строку
       battleFrame.addBattleLog("");
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
                   battleFrame.addBattleLog(one.getName()+" нанес "+Dmg.getAllDmg()+" урона критическим "
                            + "ударом используя "+one.getWeapon().getName()); 
                //Если нет оружия
                else
                    battleFrame.addBattleLog(one.getName()+" нанес "+Dmg.getAllDmg()+" урона критическим "
                            + "ударом");
            }    
            //Если не критический
            else{
                //Если есть оружие
                if(Dmg.weaponDmg > 0)
                    battleFrame.addBattleLog(one.getName()+" нанес "+Dmg.getAllDmg()+" урона "
                            + "используя "+one.getWeapon().getName());
                //Если нет оружия
                else
                    battleFrame.addBattleLog(one.getName()+" нанес "+Dmg.getAllDmg()+" урона");                  
                }
        }
            
        //Если промахнулся
        else
            battleFrame.addBattleLog(one.getName()+" промахнулся");
    }
 
    //Порядок атак, после сверения инициативы
    private void AttackAfterInit(AUnit one, AUnit two){ 
        
        //1 потом 2
            AttackLog(one, two);
            
            //Если второй после удара жив, то он атакует в ответ
            if(two.isAlive()){
            
                //Атакует второй
                AttackLog(two, one);
                
                if(!one.isAlive()) battleFrame.addBattleLog(one.getName()+" умер"); 
            }
            
            else battleFrame.addBattleLog(two.getName()+" умер");
    }   
}

