package Proiect;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class DressUpGameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Lama lama1;
    private static Lama lama2;
    private static Lama lamaSelectata;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DressUpGameGUI::new);
    }

    public DressUpGameGUI() {
        super("Proiect Bridge Pattern - Dress Up Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        List<OutfitImplementor> outfits = new ArrayList<>();
        outfits.add(new Outfit1());
        outfits.add(new Outfit2());
        outfits.add(new Outfit3());

        lama1 = new lama1(outfits.get(0));
        lama2 = new lama2(outfits.get(0));

        //Left (menu)
        JPanel panelStanga = new JPanel(new GridBagLayout());
        panelStanga.setBackground(Color.decode("#93BD57"));
        panelStanga.setMinimumSize(new Dimension(300, 0));

        //Right (display)
        JPanel wrapperDreapta = new JPanel(new GridBagLayout());
        wrapperDreapta.setBackground(Color.decode("#D1855C"));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBackground(Color.decode("#B77466"));
        layeredPane.setOpaque(true);
        layeredPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JLabel fundalLabel = new JLabel("", SwingConstants.CENTER);
        JLabel logoLabel = new JLabel("", SwingConstants.CENTER);
        JLabel lamaLabel = new JLabel("", SwingConstants.CENTER);
        JLabel bluzaLabel = new JLabel("", SwingConstants.CENTER);
        JLabel hatLabel = new JLabel("", SwingConstants.CENTER);
        JLabel copiteLabel = new JLabel("", SwingConstants.CENTER);
        JLabel accesoriiLabel = new JLabel("", SwingConstants.CENTER);

        layeredPane.add(fundalLabel, Integer.valueOf(0));
        layeredPane.add(logoLabel, Integer.valueOf(1));
        layeredPane.add(lamaLabel, Integer.valueOf(2));
        layeredPane.add(hatLabel, Integer.valueOf(3));
        layeredPane.add(bluzaLabel, Integer.valueOf(4));
        layeredPane.add(copiteLabel, Integer.valueOf(5));
        layeredPane.add(accesoriiLabel, Integer.valueOf(6));

        // Resize logic: keep square
        wrapperDreapta.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int margin = 40;
                int size = Math.min(wrapperDreapta.getWidth() - margin, wrapperDreapta.getHeight() - margin);
                if (size < 50) size = 50;

                layeredPane.setPreferredSize(new Dimension(size, size));

                fundalLabel.setBounds(0, 0, size, size);
                logoLabel.setBounds(0, 0, size, size);
                lamaLabel.setBounds(0, 0, size, size);
                bluzaLabel.setBounds(0, 0, size, size);
                hatLabel.setBounds(0, 0, size, size);
                copiteLabel.setBounds(0, 0, size, size);
                accesoriiLabel.setBounds(0, 0, size, size);

                wrapperDreapta.revalidate();
                wrapperDreapta.repaint();
            }
        });

        wrapperDreapta.add(layeredPane, new GridBagConstraints());

        //Split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelStanga, wrapperDreapta);
        splitPane.setResizeWeight(0.0);
        splitPane.setDividerLocation(300);

        add(splitPane);

        //Load initial images
        ImageIcon fundalIcon = new ImageIcon("./Imagini/barn.jpeg");
        ImageIcon logoIcon = new ImageIcon("./Imagini/logo dress up the llama.png");
        fundalLabel.setIcon(fundalIcon);
        logoLabel.setIcon(logoIcon);

        Runnable refreshLeft = () -> {
            panelStanga.revalidate();
            panelStanga.repaint();
        };

        //Panels (left)

        // Start panel
        JPanel panelStart = new JPanel(new GridLayout(1, 1, 10, 10));
        panelStart.setBackground(Color.decode("#93BD57"));
        JButton btnStart = new JButton("Start");
        panelStart.add(btnStart);

        // Llama panel
        JPanel panelLame = new JPanel(new GridLayout(2, 1, 10, 10));
        panelLame.setBackground(Color.decode("#93BD57"));
        panelLame.setVisible(false);
        JButton btnLama1 = new JButton("Lama 1");
        JButton btnLama2 = new JButton("Lama 2");
        panelLame.add(btnLama1);
        panelLame.add(btnLama2);

        // Outfit panel
        JPanel panelOutfits = new JPanel(new GridLayout(5, 1, 10, 10));
        panelOutfits.setBackground(Color.decode("#93BD57"));
        panelOutfits.setVisible(false);

        JButton btnOutfit1 = new JButton("Glam");
        JButton btnOutfit2 = new JButton("Emo");
        JButton btnOutfit3 = new JButton("Pikachu");
        JButton btnCustomize = new JButton("Customize");
        JButton btnDone = new JButton("✓ Done");

        panelOutfits.add(btnOutfit1);
        panelOutfits.add(btnOutfit2);
        panelOutfits.add(btnOutfit3);
        panelOutfits.add(btnCustomize);
        panelOutfits.add(btnDone);

        // Restart panel
        JPanel panelRestart = new JPanel(new GridLayout(1, 1, 10, 10));
        panelRestart.setBackground(Color.decode("#93BD57"));
        panelRestart.setVisible(false);
        JButton btnRestart = new JButton("↻ Restart");
        panelRestart.add(btnRestart);

        // Custom panel
        JPanel panelCustom = CustomizePanelBuilder.buildCustomizePanel(
                hatLabel, bluzaLabel, accesoriiLabel, copiteLabel,
                panelStanga, panelOutfits, refreshLeft
        );
        panelCustom.setVisible(false);

        // Add all to left with GBC
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        panelStanga.add(panelStart, gbc);
        gbc.gridy = 1;
        panelStanga.add(panelLame, gbc);
        gbc.gridy = 2;
        panelStanga.add(panelOutfits, gbc);
        gbc.gridy = 3;
        panelStanga.add(panelCustom, gbc);
        gbc.gridy = 4;
        panelStanga.add(panelRestart, gbc);

        // Actions

        btnStart.addActionListener(e -> {
            panelStart.setVisible(false);
            panelLame.setVisible(true);
            logoLabel.setIcon(null);
            refreshLeft.run();
        });

        btnLama1.addActionListener(e -> {
            lamaSelectata = lama1;
            panelLame.setVisible(false);
            panelOutfits.setVisible(true);
            lama1.display(lamaLabel);
            refreshLeft.run();
        });

        btnLama2.addActionListener(e -> {
            lamaSelectata = lama2;
            panelLame.setVisible(false);
            panelOutfits.setVisible(true);
            lama2.display(lamaLabel);
            refreshLeft.run();
        });

        btnOutfit1.addActionListener(e -> {
            lamaSelectata.setOutfit(outfits.get(0));
            lamaSelectata.applyOutfit(bluzaLabel, hatLabel, accesoriiLabel, copiteLabel);
            layeredPane.repaint();
        });

        btnOutfit2.addActionListener(e -> {
            lamaSelectata.setOutfit(outfits.get(1));
            lamaSelectata.applyOutfit(bluzaLabel, hatLabel, accesoriiLabel, copiteLabel);
            layeredPane.repaint();
        });

        btnOutfit3.addActionListener(e -> {
            lamaSelectata.setOutfit(outfits.get(2));
            lamaSelectata.applyOutfit(bluzaLabel, hatLabel, accesoriiLabel, copiteLabel);
            layeredPane.repaint();
        });

        btnCustomize.addActionListener(e -> {
            panelOutfits.setVisible(false);
            panelCustom.setVisible(true);
            refreshLeft.run();
        });

        btnDone.addActionListener(e -> {
            fundalLabel.setIcon(new ImageIcon("./Imagini/runway show.png"));

            panelOutfits.setVisible(false);
            panelCustom.setVisible(false);
            panelRestart.setVisible(true);

            panelStanga.setBackground(Color.decode("#FFAAB8"));
            panelRestart.setBackground(Color.decode("#FFAAB8"));

            refreshLeft.run();
            layeredPane.repaint();
        });

        btnRestart.addActionListener(e -> {
            // Reset background + logo
            fundalLabel.setIcon(new ImageIcon("./Imagini/barn.jpeg"));
            logoLabel.setIcon(logoIcon);

            // Clear layers
            lamaLabel.setIcon(null);
            bluzaLabel.setIcon(null);
            hatLabel.setIcon(null);
            copiteLabel.setIcon(null);
            accesoriiLabel.setIcon(null);

            // Reset left panels
            panelRestart.setVisible(false);
            panelCustom.setVisible(false);
            panelOutfits.setVisible(false);
            panelLame.setVisible(false);
            panelStart.setVisible(true);

            panelStanga.setBackground(Color.decode("#93BD57"));
            panelStart.setBackground(Color.decode("#93BD57"));
            panelRestart.setBackground(Color.decode("#93BD57"));

            refreshLeft.run();
            layeredPane.repaint();
        });

        //Show window LAST
        setVisible(true);
        splitPane.setDividerLocation(300);
    }
    
}