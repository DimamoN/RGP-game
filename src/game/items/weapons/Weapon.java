/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.items.weapons;

import game.items.AbstractItem;
import game.units.status.AbstractUnitEffect;

import javax.swing.ImageIcon;

/**
 * @author DimamoN
 */
public class Weapon extends AbstractItem {

    //Урон оружия
    private int damage;

    //Эффект который наносит оружие при крите
    private AbstractUnitEffect effect;

    public Weapon() {

    }

    public Weapon(String name, int damage, int weight, AbstractUnitEffect effect, String pathToImage) {
        super(name, weight, pathToImage);
        this.damage = damage;
        this.effect = effect;
    }

    //Для clone()
    public Weapon(String name, int damage, int weight, AbstractUnitEffect effect, ImageIcon image) {
        super(name, weight, image);
        this.damage = damage;
        this.effect = effect;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return this.getName() + ", Урон: " + this.damage;
    }

    public AbstractUnitEffect getEffect() {
        return effect;
    }

    //Вернуть обновленный эффент - вызывается в Атаке Юнита
    public AbstractUnitEffect getResetEffect() {
        effect.resetEffect();
        return effect;
    }

    @Override
    public Weapon clone() {
        return new Weapon(this.getName(), this.getDamage(),
                this.getWeight(), this.getEffect(), this.getImage());
    }
}
