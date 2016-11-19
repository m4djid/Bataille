import java.util.Random;

public class Jeu32CartesPourLaBataille {
	
	private static Carte jeu[] = new Carte[32];
	    private static String []figure = {"7","8","9","10","Valet","Dame","Roi","As"};
	    private static String []couleur = {"Pique","Coeur","Carreau","Trefle"};

	    private static int Figure;
	    private static int Valeur = 0;
	    private static  int nbrFigures = 8;

	    public static void JeuDe32CartesPourLaBataille()
	        {
	          for(String Couleur : couleur)
	            {
	                for(Figure=0;Figure<nbrFigures;Figure++)
	                    {
	                     jeu[Valeur] = new Carte(Couleur,figure[Figure],Figure);
	                     Valeur++;
	                    }
	            }
	        }
	
	    
	    public static Carte get(int i)
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
			// Carte tampon pour les échanges d'objets
			
			rnCarte = jeu[rn];
			jeu[rn] = jeu[rn2];
			jeu[rn2] = rnCarte;
						
		}
		
	}
	
	
	
  public void couper() {
	  int demiPaquet = 16;
	  int taillePaquet = 32;
	  int k =0;
	  int premier=16;
	  int dernier=0;
	  int quantite = 0;
	  ;
	  Carte[] temp = new Carte[demiPaquet];
	  
	  for(int i = demiPaquet; i < taillePaquet; i++ ){
		  Carte c = jeu[i];
		    if (c != null) {
		        temp[k] = new Carte(c);
		        k++;
		    } 
	  }
	  
	  for(int j = 0; j < demiPaquet; j++) {
	  if (quantite + demiPaquet == taillePaquet) {
          throw new RuntimeException("Queue overflow");
      }
	  jeu[premier] = jeu[dernier];
      jeu[dernier] = temp[j];
      dernier = (dernier + 1) % jeu.length;
      premier++;
      quantite++;
	  }
  }

}
