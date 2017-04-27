package jeu;

public class File {


    private Carte[] file;
    private int premier;
    private int dernier;
    private int quantite;

    public File(int n) {
        file = new Carte[n];
        premier = 0;
        dernier = 0;
        quantite = 0;
    }

    public void entrer(Carte c) {
        if (plein()) {
            throw new RuntimeException("Queue overflow");
        }
        file[dernier] = c;
        dernier = (dernier + 1) % file.length;
        quantite++;
    }

    public Carte sortir() {
        if (vide()) {
            throw new RuntimeException("Queue underflow");
        }
        Carte c = file[premier];
        premier = (premier + 1) % file.length;
        quantite--;
        return c;
    }

    public boolean vide() {
        return quantite == 0;
    }

    public boolean plein() {
        return quantite == file.length;
    }

    public void affiche() {
        System.out.print("{ ");
        if (quantite > 0) {
            int p = premier;
            do {
                System.out.print(file[p].getFigure() + ":" + file[p].getCouleur() + " - ");
                p = (p + 1) % file.length;
            } while(p != dernier);
        }
        System.out.print("}");
    }
    
    public int nombreMain(){
    	return dernier;
    }

    public int getTailleMain() {
        return quantite;
    }
}
