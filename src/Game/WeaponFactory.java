/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Items.Weapons.Weapon;
import java.util.ArrayList;

/**
 *
 * @author DimamoN
 */
public class WeaponFactory {
    
    ArrayList<Weapon> weapons = new ArrayList();
    
    {
    Weapon dagger = new Weapon("Кинжал", 2, 1, "src\\Images\\Weapons\\dagger.png");
    Weapon hammer = new Weapon("Молоток", 2, 1, "src\\Images\\Weapons\\hammer.png" );
    Weapon sword = new Weapon("Меч", 3, 2, "src\\Images\\Weapons\\sword.png");
    Weapon pike = new Weapon("Копье", 4, 5, "src\\Images\\Weapons\\pike.png");
    Weapon longSword = new Weapon("Длинный меч", 5, 3, "src\\Images\\Weapons\\longSword.png");
    Weapon axe = new Weapon("Секира", 5, 5, "src\\Images\\Weapons\\axe.png");
    Weapon orkAxe = new Weapon("Орочья секира", 6, 10, "src\\Images\\Weapons\\axeBig.png");
    Weapon orkAxeBig = new Weapon("Орочья двойная секира", 7, 14, "src\\Images\\Weapons\\axeBigDouble.png" );
    
    weapons.add(dagger);
    weapons.add(hammer);
    weapons.add(sword);
    
    weapons.add(pike);
    weapons.add(longSword);
    
    weapons.add(axe);
    weapons.add(orkAxe);
    weapons.add(orkAxeBig);
    }

    public WeaponFactory() {
    }
    
    public Weapon getDagger() {
        return weapons.get(0);
    }
    
    public Weapon getHammer() {
        return weapons.get(1);
    }
    
    public Weapon getSword() {
        return weapons.get(2);
    }

    public Weapon getPike() {
        return weapons.get(3);
    }  
    
    public Weapon getLongSword() {
        return weapons.get(4);
    }
    
    public Weapon getAxe() {
        return weapons.get(5);
    }

    public Weapon getOrkAxe() {
        return weapons.get(6);
    }

    public Weapon getOrkAxeBig() {
        return weapons.get(7);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
    
    public String[] getNames(){
        
        //Массив имен
        String[] names = new String[weapons.size()];
        
        for(int i=0; i < weapons.size(); i++)
            names[i] = weapons.get(i).getName();
        
        return names;
    }

    
    
}
