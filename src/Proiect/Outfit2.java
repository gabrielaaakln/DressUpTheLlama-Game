package Proiect;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Outfit2 implements OutfitImplementor {

	private final String hairImage;
    private final String topImage;
    private final String shoesImage;
    private final String accImage;

    public Outfit2() {
        this.hairImage  = "./Imagini/emotional hat.png";
        this.topImage   = "./Imagini/emotional outfit.png";
        this.accImage = "./Imagini/emotional acc.png";
        this.shoesImage = "./Imagini/emotional shoes.png";
    }


    @Override
    public void apply(JLabel hair, JLabel top, JLabel acc, JLabel shoes) {
        top.setIcon(new ImageIcon(topImage));
        hair.setIcon(new ImageIcon(hairImage)); // sau alt element pentru păr
        acc.setIcon(new ImageIcon(accImage));
        shoes.setIcon(new ImageIcon(shoesImage));
    }
}
