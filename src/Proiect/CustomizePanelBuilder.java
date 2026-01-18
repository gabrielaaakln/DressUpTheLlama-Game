package Proiect;

import java.awt.*;
import javax.swing.*;

public class CustomizePanelBuilder {

    public static JPanel buildCustomizePanel(
            JLabel hatLabel,
            JLabel bluzaLabel,
            JLabel accesoriiLabel,
            JLabel copiteLabel,
            JPanel panelStanga,
            JPanel panelOutfits,
            Runnable refreshLeft
    ) {
        JPanel panelCustom = new JPanel(new GridLayout(5, 1, 10, 10));
        panelCustom.setBackground(Color.decode("#93BD57"));

        // Hat menu
        JPanel hatMenu = new JPanel(new GridLayout(1, 3, 5, 5));
        hatMenu.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.decode("#6B8E3D"), 2), "Hat"));
        hatMenu.setBackground(Color.decode("#93BD57"));

        JButton hatGlam = new JButton("Glam");
        JButton hatEmo = new JButton("Emo");
        JButton hatPikachu = new JButton("Pikachu");

        hatGlam.addActionListener(ev -> hatLabel.setIcon(new ImageIcon("./Imagini/glam hat.png")));
        hatEmo.addActionListener(ev -> hatLabel.setIcon(new ImageIcon("./Imagini/emotional hat.png")));
        hatPikachu.addActionListener(ev -> hatLabel.setIcon(new ImageIcon("./Imagini/pikachu hat.png")));

        hatMenu.add(hatGlam);
        hatMenu.add(hatEmo);
        hatMenu.add(hatPikachu);

        // Top menu
        JPanel topMenu = new JPanel(new GridLayout(1, 3, 5, 5));
        topMenu.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.decode("#6B8E3D"), 2), "Top"));
        topMenu.setBackground(Color.decode("#93BD57"));

        JButton topGlam = new JButton("Glam");
        JButton topEmo = new JButton("Emo");
        JButton topPikachu = new JButton("Pikachu");

        topGlam.addActionListener(ev -> bluzaLabel.setIcon(new ImageIcon("./Imagini/glam outfit.png")));
        topEmo.addActionListener(ev -> bluzaLabel.setIcon(new ImageIcon("./Imagini/emotional outfit.png")));
        topPikachu.addActionListener(ev -> bluzaLabel.setIcon(new ImageIcon("./Imagini/pkachu outfit.png")));

        topMenu.add(topGlam);
        topMenu.add(topEmo);
        topMenu.add(topPikachu);

        // Accessories menu
        JPanel accMenu = new JPanel(new GridLayout(1, 3, 5, 5));
        accMenu.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.decode("#6B8E3D"), 2), "Accessories"));
        accMenu.setBackground(Color.decode("#93BD57"));

        JButton accGlam = new JButton("Glam");
        JButton accEmo = new JButton("Emo");
        JButton accPikachu = new JButton("Pikachu");

        accGlam.addActionListener(ev -> accesoriiLabel.setIcon(new ImageIcon("./Imagini/glam acc.png")));
        accEmo.addActionListener(ev -> accesoriiLabel.setIcon(new ImageIcon("./Imagini/emotional acc.png")));
        accPikachu.addActionListener(ev -> accesoriiLabel.setIcon(new ImageIcon("./Imagini/pikachu acc.png")));

        accMenu.add(accGlam);
        accMenu.add(accEmo);
        accMenu.add(accPikachu);

        // Shoes menu
        JPanel shoesMenu = new JPanel(new GridLayout(1, 3, 5, 5));
        shoesMenu.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.decode("#6B8E3D"), 2), "Shoes"));
        shoesMenu.setBackground(Color.decode("#93BD57"));

        JButton shoesGlam = new JButton("Glam");
        JButton shoesEmo = new JButton("Emo");
        JButton shoesPikachu = new JButton("Pikachu");

        shoesGlam.addActionListener(ev -> copiteLabel.setIcon(new ImageIcon("./Imagini/glam shoes.png")));
        shoesEmo.addActionListener(ev -> copiteLabel.setIcon(new ImageIcon("./Imagini/emotional shoes.png")));
        shoesPikachu.addActionListener(ev -> copiteLabel.setIcon(new ImageIcon("./Imagini/pikachu shoes.png")));

        shoesMenu.add(shoesGlam);
        shoesMenu.add(shoesEmo);
        shoesMenu.add(shoesPikachu);

        // Back button
        JButton btnBack = new JButton("← Back");
        btnBack.addActionListener(ev -> {
            panelCustom.setVisible(false);
            panelOutfits.setVisible(true);
            refreshLeft.run();
        });

        panelCustom.add(hatMenu);
        panelCustom.add(topMenu);
        panelCustom.add(accMenu);
        panelCustom.add(shoesMenu);
        panelCustom.add(btnBack);

        return panelCustom;
    }
}