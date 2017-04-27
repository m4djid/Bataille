package jeu;

import javax.swing.*;

public class Carte {

    private String couleur;
    private String figure;
    private int valeur;
    // Attribut pour swing
    private ImageIcon image;
    public static final ImageIcon imageVide = new ImageIcon(Carte.class.getResource("images-cartes/vide.gif"));
    public static final ImageIcon imageDos = new ImageIcon(Carte.class.getResource("images-cartes/carte_dos.gif"));
    public static final Carte carteVide = new Carte();
    public static final Carte carteDos = new Carte("", imageDos);

    public Carte(String couleur, String figure, int valeur, ImageIcon image) {
        this.couleur = couleur;
        this.figure = figure;
        this.valeur = valeur;
        this.image = image;
    }

 /*   public Carte(String couleur, String figure, int valeur) {
        this.couleur = couleur;
        this.figure = figure;
        this.valeur = valeur;
    }*/

    public Carte(String couleur, String figure, ImageIcon image) {
        this.couleur = couleur;
        this.figure = figure;
        this.image = image;
    }

    public Carte(String figure, ImageIcon image) {
        this.figure = figure;
        this.image = image;
    }

    public Carte() {
        this.couleur = "";
        this.figure = "";
        this.valeur = 0;
        this.image = imageVide;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getFigure() {
        return figure;
    }

    public int getValeur() {
        return valeur;
    }
    // Constructeur de copie
    public Carte(Carte c) {
        couleur = c.couleur;
        figure = c.figure;
        valeur = c.valeur;
    }

    public ImageIcon getImage() {
        return image;
    }



}
