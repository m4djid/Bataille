package swing;

import jeu.Carte;
import jeu.Jeu;
import jeu.Joueur;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Madjid on 26/04/2017.
 */
public class VisionnageBataille {
    private JLabel labelNom1, labelNom2;
    private JLabel labelNbCartes1, labelNbCartes2;
    private JLabel labelCarteTas1, labelCarteTas2;
    private JFrame frame;
    private JPanel cards, bottom;

    public VisionnageBataille(String nom1, String nom2) {
        labelNom1 = new JLabel(nom1);
        labelNom2 = new JLabel(nom2);
        frame = new JFrame("Bataille");
        frame.setLayout(new BorderLayout());
        cards = new JPanel();
        cards.setLayout(new GridLayout(1,2));
        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        frame.getContentPane().add(cards, BorderLayout.CENTER);
        frame.getContentPane().add(bottom,BorderLayout.SOUTH);
        frame.getContentPane().add(labelNom1, BorderLayout.WEST);
        frame.getContentPane().add(labelNom2,BorderLayout.EAST);
        labelNbCartes1 = new JLabel("0");
        labelNbCartes2 = new JLabel("0");
        bottom.add(labelNbCartes1, BorderLayout.WEST);
        bottom.add(labelNbCartes2, BorderLayout.EAST);
        labelCarteTas1 = new JLabel(Carte.carteVide.getImage(), JLabel.CENTER);
        labelCarteTas2 = new JLabel(Carte.carteVide.getImage(), JLabel.CENTER);
        cards.add(labelCarteTas1);
        cards.add(labelCarteTas2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension( 600,200));
        frame.setVisible(true);
        frame.pack();


    }

    public void setNbCartes1(int n) {
        labelNbCartes1.setText(""+n);
    }
    public void setNbCartes2(int n) {
        labelNbCartes2.setText(""+n);
    }
    public void setCarteTas1(Carte c) {
        labelCarteTas1.setIcon(c.getImage());
    }
    public void setCarteTas2(Carte c) {
        labelCarteTas2.setIcon(c.getImage());
    }
    public void setGagnant(int g) {
        String win = "Bravo!!!";
        String lose = "Dommage!!!";
        String draw = "Match nul";
        if (g == 1) {
            labelNom1.setText("<html>" + win + "<br>" + labelNom1.getText()+"</html>");
            labelNom2.setText("<html>" + lose + "<br>" + labelNom2.getText()+"</html>");
        } else if (g == 2) {
            labelNom2.setText("<html>" + win + "<br>" + labelNom2.getText()+"</html>");
            labelNom1.setText("<html>" + lose + "<br>" + labelNom1.getText()+"</html>");
        } else {
            labelNom1.setText("<html>" + draw + "<br>" + labelNom1.getText()+"</html>");
            labelNom2.setText("<html>" + draw + "<br>" + labelNom2.getText()+"</html>");
        }
    }
}
