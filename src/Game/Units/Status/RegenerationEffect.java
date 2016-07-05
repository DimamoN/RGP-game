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
public class RegenerationEffect extends AUnitEffect{

    public RegenerationEffect(String name, int duration, int power) {
        super(name, duration, power);
    }

    //Действие эфеекта регенерации (Восстаналивает power хп, каждый ход)
    @Override
    public void EffectAction(AUnit unit) {
       unit.setHp(unit.getHp() + power);
    }
    
}
