/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.items.armor;

import game.items.AbstractItem;

import javax.swing.ImageIcon;

/**
 * @author DimamoN
 */
public class Armor extends AbstractItem {

    //Защита, которую дает броня (1-5)
    private int defence;

    public Armor() {}

    //Без картинки
    public Armor(String name, int defence, int weight) {
        super(name, weight);
        this.defence = defence;
    }

    //Новый, с картинкой
    public Armor(String name, int defence, int weight, String pathToImage) {
        super(name, weight, pathToImage);
        this.defence = defence;
    }

    //для clone()
    public Armor(String name, int defence, int weight, ImageIcon image) {
        super(name, weight, image);
        this.defence = defence;
    }

    public int getDefence() {
        return defence;
    }

    public Armor clone() {
        return new Armor(this.getName(), this.getDefence(),
                this.getWeight(), this.getImage());
    }

    @Override
    public String toString() {
        return this.getName() + ", Защита: " + this.defence;
    }

}
