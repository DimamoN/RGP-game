/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Units.Status;

import Game.Units.AUnit;

/**
 *
 * @author dimamon
 */
public abstract class AUnitEffect {
    
    //Название эффекта
    String name;
    
    //Продолжительность
    int duration;
    int startDuration;
    
    //Сила эффекта
    int power;

    public AUnitEffect(String name, int duration, int power) {
        this.name = name;
        this.duration = duration;
        this.startDuration = duration;
        this.power = power;
    }
    
    //Действие эффекта
    public abstract void EffectAction(AUnit unit);

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }  

    public int getPower() {
        return power;
    }
   
    
    public void decrementDuration(){
        if(this.duration > 0) this.duration --;
    }
    
    public void resetEffect(){   
        duration = startDuration;
    }
    
}
