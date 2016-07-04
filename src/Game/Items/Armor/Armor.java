/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items.Armor;

import Game.Items.AItem;

/**
 *
 * @author DimamoN
 */
public class Armor extends AItem{
    
    //Защита, которую дает броня (1-5)
    int def;

    public Armor() {
    }
    
    //Без картинки
    public Armor(String name, int def, int weight) {
        super(name, weight);
        this.def = def;
    }

    //Новый, с картинкой
    public Armor(String name, int def, int weight, String pathToImage) {
        super(name, weight, pathToImage);
        this.def = def;
    }

    public int getDef() {
        return def;
    }

    @Override
    public String toString() {
        return this.getName()+", Защита: "+this.def+", Вес: "+this.weight;
    }
     
}
