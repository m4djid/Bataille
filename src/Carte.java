public class Carte {
	
 private String couleur;
 private String figure;
 private int valeur;

    public Carte(String couleur, String figure, int valeur) {
        this.couleur = couleur;
        this.figure = figure;
        this.valeur = valeur;
    }

    public Carte(String couleur, String figure) {
        this.couleur = couleur;
        this.figure = figure;
    }

    public Carte(String figure) {
        this.figure = figure;
    }

    public Carte() {
        this.couleur = "";
        this.figure = "";
        this.valeur = 0;
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
    


}
