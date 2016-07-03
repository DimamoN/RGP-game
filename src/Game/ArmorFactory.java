/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Items.Armor.Armor;
import java.util.ArrayList;

/**
 *
 * @author DimamoN
 */
public class ArmorFactory {
    
    ArrayList<Armor> armors = new ArrayList();
    
    {
    Armor noArmor = new Armor("Без брони", 0, 0, "src\\Images\\Armor\\noArmor.png");
    Armor leather = new Armor("Кожаная броня", 1, 2, "src\\Images\\Armor\\leather.png");
    Armor steelLight = new Armor("Стальная легкая", 2, 6, "src\\Images\\Armor\\steelLight.png");
    Armor steel = new Armor("Стальная броня", 3, 10, "src\\Images\\Armor\\steel.png");
    Armor steelStrong = new Armor("Стальная крепкая", 4, 15, "src\\Images\\Armor\\steelStrong.png");
    
    armors.add(noArmor);
    armors.add(leather);
    armors.add(steelLight);
    armors.add(steel);
    armors.add(steelStrong);
    }


    public ArmorFactory() {
    }

    public Armor getNoArmor() {
        return armors.get(0);
    }

    public Armor getLeather() {
        return armors.get(1);
    }

    public Armor getSteelLight(){
        return armors.get(2);
    }
    
    public Armor getSteel() {
        return armors.get(3);
    }

    public Armor getSteelStrong() {
        return armors.get(4);
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }
    
     public String[] getNames(){
        
        //Массив имен
        String[] names = new String[armors.size()];
        
        for(int i=0; i < armors.size(); i++)
            names[i] = armors.get(i).getName();
        
        return names;
    }
    
    
}
