
public class Joueur {
	String nom;
	File main = new File(32);
	
	
	public Joueur() {
	}


	public String getNom() {
		return nom;
	}


	public Joueur(String nom, File main) {
		super();
		this.nom = nom;
		this.main = main;
	}


	public Joueur(String nom) {
		super();
		this.nom = nom;
	}
	
	
	
}
