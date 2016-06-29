/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items;

/**
 *
 * @author DimamoN
 */
public class AItem {
    
    //Название айтема
    private String name;
    
    //Вес айтема
    protected int weight;
    
    public AItem() {
    }

    public AItem(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.getName()+" Weight: "+this.weight;
    }
         
}
