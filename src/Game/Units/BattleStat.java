/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Units;

import java.text.DecimalFormat;

public class BattleStat {
    
    //Число попаданий
    int hit = 0;
    //Число уклонений
    int miss = 0;

    public int getMiss() {
        return miss;
    }

    public int getHit() {
        return hit;
    }
    
    public void addHit(){
        this.hit++;
    }
    
    public void addMiss(){
        this.miss++;
    }
   
    public String getHitPerc(){
        
        
        if(hit==0 && miss==0) return "-";
        
        double sum = hit + miss;
        
        double hitStat = hit / sum;
        
        hitStat = hitStat * 100;
        
        String formattedHitStat = new DecimalFormat("#0.00").format(hitStat);
        
        return formattedHitStat + " %";  
    }
    
    //Вернуть Статистику Попаданий
    public String getHitStat(){        
        return "Попаданий: "+this.hit+" Промахов: "+this.miss+" Процент попаданий: "+this.getHitPerc();        
    }    
    
    public void resetStats(){
        this.miss = 0;
        this.hit = 0;
    }
    
    
    
}
