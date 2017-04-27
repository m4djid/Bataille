package jeu;

import javax.swing.*;
import java.util.Random;

public class Jeu32CartesPourLaBataille {

    private static Carte jeu[] = new Carte[32];
    private static String []figure = {"7","8","9","10","Valet","Dame","Roi","As"};
    private static String []couleur = {"Pique","Coeur","Carreau","Trefle"};
    private static int Figure;
    private static int Valeur = 0;
    private static  int nbrFigures = 8;
    public static final String[] couleurCodeImage = {"s", "h", "d", "c"};
    public static final String[] figureCodeImage = {"7","8","9","10","J","Q","K","A"};

    //jeu.Carte[] pli = new jeu.Carte[32];
    //int sommet;

    public static void JeuDe32CartesPourLaBataille()
    {
        for(int i = 0; i < couleur.length; i++)
        {
            for(int j=0;j<nbrFigures;j++)
            {
                jeu[Valeur] = new Carte(couleur[i],figure[j],j, new ImageIcon(Carte.class.getResource("images-cartes/"+figureCodeImage[j]+couleurCodeImage[i]+".gif")));
                Valeur++;
            }
        }
    }

    public Carte get(int i)
    {
        return jeu[i];
    }


    public static void battre(int n){
        int x = n;
        Random random = new Random();
        int valeurMin = x;
        //int valeurMax = n*2;
        Carte rnCarte;
        // Determine de nombre de changement
        int r = valeurMin + random.nextInt(valeurMin);
        // Boucle réalisant r changement

        // Boucle parcourant le tableau pour faire les échanges
        for (int j = 0; j<=r ; j++)
        {

            int rn = random.nextInt(x);
            int rn2 = random.nextInt(x);
            // jeu.Carte tampon pour les échanges d'objets

            rnCarte = jeu[rn];
            jeu[rn] = jeu[rn2];
            jeu[rn2] = rnCarte;

        }

    }


    // Methode qui coupe le jeu
    public void couper() {
        // Initiation des variables
        int demiPaquet = 16;
        int taillePaquet = 32;
        int k =0;
        int premier=16;
        int dernier=0;
        int quantite = 0;
        // Création d'un tableau tampon
        Carte[] temp = new Carte[demiPaquet];
	  /* 
	   * Copie de la seconde moitié du tableau jeu dans le tableau tampon
	   * grâce à un constructeur de copie visible dans la classe jeu.Carte
	   */
        for(int i = demiPaquet; i < taillePaquet; i++ ){
            Carte c = jeu[i];
            if (c != null) {
                temp[k] = new Carte(c);
                k++;
            }
        }
	  /*
	   * Le tableau jeu est rempli depuis le tableau tampon en suivant le schéma suivant
	   * L'objet à l'indice x du tableau jeu est déplacé à l'indice x+taille du demiPaquet
	   * L'objet à l'indice x du tableau jeu est ensuite remplacé par l'objet
	   * de l'objet tampon à l'indice j
	   */
        for(int j = 0; j < demiPaquet; j++) {
            if (quantite + demiPaquet == taillePaquet) {
                throw new RuntimeException("Queue overflow");
            }
            // Déplacement de l'objet
            jeu[premier] = jeu[dernier];
            // Remplacement de l'objet déplacé par un objet du tableau tampon
            jeu[dernier] = temp[j];
            dernier = (dernier + 1) % jeu.length;
            premier++;
            quantite++;
        }
    }

}
