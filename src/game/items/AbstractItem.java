/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.items;

import javax.swing.ImageIcon;

/**
 * @author DimamoN
 */
public class AbstractItem {

    //Картинка айтема
    private ImageIcon image;

    //Название айтема
    private String name;

    //Вес айтема
    protected int weight;

    public AbstractItem() {}

    //УДАЛИТЬ ПОТОМ!!!
    public AbstractItem(String name, int weight) {
        this.name = name;
        this.weight = weight;
        image = new ImageIcon();
    }

    //Крутой конструктор с путем к икноке
    public AbstractItem(String name, int weight, String pathToImage) {
        this.name = name;
        this.weight = weight;
        image = new ImageIcon(this.getClass().getResource(pathToImage));
    }

    //Конструктор, принимающий иконку (для clone())
    public AbstractItem(String name, int weight, ImageIcon image) {
        this.name = name;
        this.weight = weight;
        this.image = image;
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
        return this.getName() + " Weight: " + this.weight;
    }

}
