package Proiect;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class lama1 extends Lama {
	
	
	public lama1(OutfitImplementor outfit) {
		super(outfit);
	}

	@Override
	public void display(JLabel panel) {
		ImageIcon lamaIcon = new ImageIcon("./Imagini/lama1.png");
        panel.setIcon(lamaIcon);
	}

}
