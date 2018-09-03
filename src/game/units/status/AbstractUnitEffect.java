/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.units.status;

import game.units.AbstractUnit;

/**
 * @author dimamon
 */
public abstract class AbstractUnitEffect {

    //Название эффекта
    private String name;

    //Продолжительность
    private int duration;
    private int startDuration;

    //Сила эффекта
    int power;

    public AbstractUnitEffect(String name, int duration, int power) {
        this.name = name;
        this.duration = duration + 1;
        this.startDuration = duration;
        this.power = power;
    }

    //Действие эффекта
    public abstract void EffectAction(AbstractUnit unit);

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getPower() {
        return power;
    }


    public void decrementDuration() {
        if (this.duration > 0) this.duration--;
    }

    public void resetEffect() {
        duration = startDuration;
    }

    //ЕСЛИ ИМЯ ТО ЖЕ, А ЭФФЕКТ СИЛЬНЕЕ - НУЖНО ПЕРЕЗАПИСАТЬ
    //ЕСЛИ ИМЯ ТО ЖЕ, А ЭФФЕКТ СЛАБЕЕ - НE НУЖНО

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (!obj.getClass().isInstance(this)) return false;

        AbstractUnitEffect effect = (AbstractUnitEffect) obj;

        return this.name.equals(effect.name)
                && this.power <= effect.power;
    }

}
