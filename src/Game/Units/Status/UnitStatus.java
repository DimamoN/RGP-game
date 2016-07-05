/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Units.Status;

import Game.Units.AUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.function.BiFunction;

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
        
        //для удаления
        boolean delete = false;
        AUnitEffect deleteEffect = new BleedingEffect("NO", 0, 0);
        
        for(AUnitEffect effect: currentStatus.values()){
           
            //Действие эффекта
            effect.EffectAction(unit);
           
            //уменьшить время эффекта
            effect.decrementDuration();
            
            //Если время вышло - удалить эффект (после итараций)
            if(effect.getDuration() == 0) {
                delete = true;
                deleteEffect = effect;
            }    
        }
        
        //Удалить эффект, если его длительность прошла
        if(delete) this.deleteEffect(deleteEffect);  
        
    }
    
    public void clearStatus(){
        this.currentStatus.clear();
    }
    
    //Возвращает массив описаний эффектов
    public String[] getAllEffectsToString(){
        
    String[] effectNames = new String[currentStatus.size()];
    
    int i = 0;
    
        for(AUnitEffect effect: currentStatus.values()){
           
           effectNames[i]  = effect.getName()+", сила "+effect.getPower()+", осталось "+effect.getDuration()+" ходов";
              
           i++;
        }
        
        return effectNames; 
    }

}
