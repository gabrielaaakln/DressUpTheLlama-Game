package Proiect;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class lama2 extends Lama {
	
	
	public lama2(OutfitImplementor outfit) {
		super(outfit);
	}

	@Override
	public void display(JLabel panel) {
		ImageIcon lamaIcon = new ImageIcon("./Imagini/lama2.png");
        panel.setIcon(lamaIcon);
	}

}
