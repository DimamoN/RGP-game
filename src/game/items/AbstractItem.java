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

    public static String DEFAULT_IMAGE_PATH = "img/book.jpg";

    private ImageIcon image;
    private String name;
    private int weight;

    protected AbstractItem() {}

    //Крутой конструктор с путем к икноке
    public AbstractItem(String name, int weight, String pathToImage) {
        this.name = name;
        this.weight = weight;
        String imgPath = pathToImage.isEmpty() ? DEFAULT_IMAGE_PATH : pathToImage;
        image = new ImageIcon(this.getClass().getResource(imgPath));
    }

    //Конструктор, принимающий иконку (для clone())
    public AbstractItem(String name, int weight, ImageIcon image) {
        this.name = name;
        this.weight = weight;
        this.image = image;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "AbstractItem{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
