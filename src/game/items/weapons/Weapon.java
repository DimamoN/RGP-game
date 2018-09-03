/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.items.weapons;

import game.items.AbstractItem;
import game.units.Status.AUnitEffect;

import javax.swing.ImageIcon;

/**
 * @author DimamoN
 */
public class Weapon extends AbstractItem {

    //Урон оружия
    int dmg;

    //Эффект который наносит оружие при крите
    AUnitEffect effect;

    public Weapon() {

    }

    public Weapon(String name, int dmg, int weight, AUnitEffect effect, String pathToImage) {
        super(name, weight, pathToImage);
        this.dmg = dmg;
        this.effect = effect;
    }

    //Для clone()
    public Weapon(String name, int dmg, int weight, AUnitEffect effect, ImageIcon image) {
        super(name, weight, image);
        this.dmg = dmg;
        this.effect = effect;
    }

    public int getDmg() {
        return dmg;
    }

    @Override
    public String toString() {
        return this.getName() + ", Урон: " + this.dmg;
    }

    public AUnitEffect getEffect() {
        return effect;
    }

    //Вернуть обновленный эффент - вызывается в Атаке Юнита
    public AUnitEffect getResetEffect() {
        effect.resetEffect();
        return effect;
    }

    @Override
    public Weapon clone() {
        return new Weapon(this.getName(), this.getDmg(),
                this.getWeight(), this.getEffect(), this.getImage());
    }
}
