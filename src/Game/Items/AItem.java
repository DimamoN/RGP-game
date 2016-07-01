/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items;
import javax.swing.ImageIcon;

/**
 *
 * @author DimamoN
 */
public class AItem {
    
    //Картинка айтема
    private ImageIcon image;
    
    //Название айтема
    private String name;
    
    //Вес айтема
    protected int weight;
    
    public AItem() {
    }

    //УДАЛИТЬ ПОТОМ!!!
    public AItem(String name, int weight) {
        this.name = name;
        this.weight = weight;
        image = new ImageIcon();
    }
    
    //Крутой конструктор с путем к икноке
    public AItem(String name, int weight, String pathToImage) {
        this.name = name;
        this.weight = weight;
        image = new ImageIcon(pathToImage);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public ImageIcon getImage() {
        return image;
    }
    
    public void setImage(ImageIcon image) {
      this.image = image;
   }

    @Override
    public String toString() {
        return this.getName()+" Weight: "+this.weight;
    }
         
}
