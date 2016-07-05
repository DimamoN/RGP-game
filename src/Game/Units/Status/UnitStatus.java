/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Units.Status;

import Game.Units.AUnit;
import java.util.HashMap;

/**
 *
 * @author dimamon
 */
public class UnitStatus {
    
    //Эффекты могут складываться, нужно это решить!

    //Имя эффекта, сам эффект
    HashMap<String, AUnitEffect> currentStatus = new HashMap<>();
    
    public void addEffect(AUnitEffect effect){    
        this.currentStatus.put(effect.getName(), effect);    
    }    
    
    public void deleteEffect(AUnitEffect effect){
        this.currentStatus.remove(effect.getName());
    }
      
    //Действия всех эффектов, уменьшить продолжительность
    public void Turn(AUnit unit){
        
        for(AUnitEffect effect: currentStatus.values()){
           
            //Действие эффекта
            effect.EffectAction(unit);
           
            //уменьшить время эффекта
            effect.decrementDuration();
            
            //Удалить эффект, если его длительность прошла
            if(effect.getDuration() == 0) this.deleteEffect(effect);     
        }
        
    }
    
    
    //Возвращает массив описаний эффектов
    public String[] getAllEffectsToString(){
        
    String[] effectNames = new String[currentStatus.size()];
    
    int i = 0;
        for(AUnitEffect effect: currentStatus.values()){
           
           effectNames[i]  = effect.getName()+", сила "+effect.getPower()+", осталось "+effect.getDuration()+" ходов";
           
        }
        
        return effectNames; 
    }

}
