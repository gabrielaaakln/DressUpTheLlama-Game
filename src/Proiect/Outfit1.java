package Proiect;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Outfit1 implements OutfitImplementor {

    private final String hairImage;
    private final String topImage;
    private final String shoesImage;
    private final String accImage;

    public Outfit1() {
        this.hairImage  = "./Imagini/glam hat.png";
        this.topImage   = "./Imagini/glam outfit.png";
        this.accImage = "./Imagini/glam acc.png";
        this.shoesImage = "./Imagini/glam shoes.png";
    }

    
    @Override
    public void apply(JLabel hair, JLabel top, JLabel acc, JLabel shoes) {
        top.setIcon(new ImageIcon(topImage));
        hair.setIcon(new ImageIcon(hairImage)); // sau alt element pentru păr
        acc.setIcon(new ImageIcon(accImage));
        shoes.setIcon(new ImageIcon(shoesImage));
    }
}
