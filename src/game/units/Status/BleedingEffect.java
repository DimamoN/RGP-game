/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.units.Status;

import game.units.AbstractUnit;

/**
 * @author dimamon
 */
public class BleedingEffect extends AUnitEffect {

    public BleedingEffect(String name, int duration, int power) {
        super(name, duration, power);
    }

    //Эффект яда (сила - power)
    @Override
    public void EffectAction(AbstractUnit unit) {
        unit.setHp(unit.getHp() - power);
    }

}
