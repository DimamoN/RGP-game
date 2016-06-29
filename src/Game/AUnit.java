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
abstract public class AUnit {
    
    String name; //имя 
    
    int sHp; //стартовые хитпоинты
    int hp; //текущие хитпоинты
    int str; //сила
    int def; //защита
    int agl; //ловкость (Максимум 10)
    int init; //инициатива
    
    //Статистика битвы для юнита
    BattleStat unitStat;

    
    //Имя, ХП, Сила, Ловкость
    public AUnit(String name, int hp, int str, int agl) {
        this.name = name;
        this.hp = hp;
        this.sHp = hp;
        this.str = str;        
        this.agl = agl;        
        unitStat = new BattleStat();
    }  

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }    
    
    public int getDef() {
        return def;
    }

    public int getAgl() {
        return agl;
    }

    public int getInit() {
        return init;
    }

    public int getStr() {
        return str;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    //Атака другого юнита, возвращает нанесенный урон
    int Attack(AUnit another){        
        
       //Нанесенный урон
       int dmg = this.str-another.getDef();
       
       //Проверка на уклонение
       if (another.Evade()){
           System.out.println(this.getName()+" промахивается");
           
           //Добавить промах в статистику
           this.unitStat.addMiss();           
           return 0;
       }
       
       else{           
       another.setHp(another.getHp()-dmg);
       
       //Добавить попадание в статистику
       this.unitStat.addHit();
       
       return dmg;
       }
    }

    public boolean isAlive(){
        return hp>0;
    }   
    
    //Получить шанс уклонения
    public boolean Evade(){
        
        Random dice = new Random();
        
        //Бросок кубика (1-6)
        
        //Число КУБИКА
        int diceNumber = 1 + dice.nextInt(6);        
        //Число ЛОВКОСТИ
        int aglNumber = agl;
        
        int evadeNumber = diceNumber + aglNumber;
        
        switch(dice.nextInt(17-evadeNumber)){
            case 0: return true; //100%
            case 1: return Dice(1); //90%
            case 2: return Dice(2); //50%
            case 3: return Dice(3);
            case 4: return Dice(4);
            case 5: return Dice(5);
            case 6: return Dice(6);
            case 7: return Dice(7);
            case 8: return Dice(8);
            case 9: return Dice(9);
            case 10: return Dice(10);
            case 11: return Dice(11);
            case 12: return Dice(12);
            case 13: return Dice(13);
            case 14: return Dice(14);
            case 15: return Dice(15);
            default: return true;
        }
    }  
    
    //Рандом от 1 до number, Успех если rnd == number
    private boolean Dice(int number){
        Random rnd = new Random();
        
        if (number == 1){
           if ((rnd.nextInt(10) + 1) < 10) return true;
           else return false;
        }
        
        if ((rnd.nextInt(number) + 1) == number) return true;        
        else return false;         
    }
    
    //Инфомация для боя
    public String BattleInfo(){
        return this.getName()+" HP: "+this.hp+" ("+this.sHp+")";
    }
    
    //Информация по концу боя про попадания и уклонения
    public void BattleFinalInfo(){        
        System.out.println(this.getName() + " | " + this.unitStat.getHitStat());        
    }
    
    
}
