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
public class PoisonEffect extends AUnitEffect{

    public PoisonEffect(String name, int duration, int power) {
        super(name, duration, power);
    }

    //Эффект яда (сила - power)
    @Override
    public void EffectAction(AUnit unit) {
        unit.setHp(unit.getHp() - power);
    }
       
}
