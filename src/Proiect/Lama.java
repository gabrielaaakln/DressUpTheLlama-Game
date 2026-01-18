package Proiect;

import javax.swing.JLabel;

public abstract class Lama {
    protected OutfitImplementor outfit;

    public Lama(OutfitImplementor outfit) {
        this.outfit = outfit;
    }

    public void setOutfit(OutfitImplementor outfit) {
        this.outfit = outfit;
    }

    public void applyOutfit(JLabel bluza, JLabel pantaloni, JLabel accesorii, JLabel copite) {
        outfit.apply(bluza, pantaloni, accesorii, copite);
    }

    public abstract void display(JLabel lamaLabel);
}