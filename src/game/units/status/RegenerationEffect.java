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
public class RegenerationEffect extends AbstractUnitEffect {

    public RegenerationEffect(String name, int duration, int power) {
        super(name, duration, power);
    }

    //Действие эфеекта регенерации (Восстаналивает power хп, каждый ход)
    @Override
    public void EffectAction(AbstractUnit unit) {
        unit.setHp(unit.getHp() + power);
    }

}
