/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.units.status;

import game.units.AbstractUnit;

import java.util.HashMap;

/**
 * @author dimamon
 */
public class UnitStatus {

    //Эффекты могут складываться, нужно это решить!

    //Имя эффекта, сам эффект
    private HashMap<String, AbstractUnitEffect> currentStatus = new HashMap<>();

    public void addEffect(AbstractUnitEffect newEffect) {

        boolean check = false;

        //Если пустой - просто добавить эффект
        if (this.currentStatus.isEmpty()) {
            currentStatus.put(newEffect.getName(), newEffect);
        } else {
            //Проверить есть ли уже этот эффект
            if (this.currentStatus.get(newEffect.getName()) != null){
                this.currentStatus.replace(newEffect.getName(), newEffect);
            } else {
                this.currentStatus.put(newEffect.getName(), newEffect);
            }

        }

//        //Проверка на повторение - если да - то обновить
//        for(AbstractUnitEffect effect: this.currentStatus.values()){
//            
//            //Для каждого эффекта     
//            if(newEffect.equals(effect)){
//                currentStatus.remove(effect.getName()); // Удалить
//                
//                currentStatus.put(newEffect.getName(), newEffect); //Добавить новый
//            }
//            
//            else currentStatus.put(newEffect.getName(), newEffect); //Добавить новый        
//        }

//        currentStatus.put(newEffect.getName(), newEffect);

    }

    public void deleteEffect(AbstractUnitEffect effect) {
        this.currentStatus.remove(effect.getName());
    }

    //Действия всех эффектов, уменьшить продолжительность
    public void Turn(AbstractUnit unit) {

        //для удаления
        boolean delete = false;
        AbstractUnitEffect effectToDelete = new BleedingEffect("NO", 0, 0);

        for (AbstractUnitEffect effect : currentStatus.values()) {

            //Действие эффекта
            effect.EffectAction(unit);
            //уменьшить время эффекта
            effect.decrementDuration();

            //Если время вышло - удалить эффект (после итараций)
            if (effect.getDuration() == 0) {
                delete = true;
                effectToDelete = effect;
            }
        }

        //Удалить эффект, если его длительность прошла
        if (delete) {
            deleteEffect(effectToDelete);
        }

    }

    public void clearStatus() {
        this.currentStatus.clear();
    }

    //Возвращает массив описаний эффектов
    public String[] getAllEffectsToString() {
        String[] effectNames = new String[currentStatus.size()];
        int i = 0;
        for (AbstractUnitEffect effect : currentStatus.values()) {
            effectNames[i] = effect.getName() + ", сила " + effect.getPower() + ", осталось " + effect.getDuration() + " ходов";
            i++;
        }
        return effectNames;
    }

    //Возвращает ХешМап текущих эффектов
    public HashMap<String, AbstractUnitEffect> getCurrentStatus() {
        return currentStatus;
    }

}
