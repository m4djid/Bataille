
public class Bataille {
	static Jeu32CartesPourLaBataille Game = new Jeu32CartesPourLaBataille();
	public static void main(String[] args){
		
		Game.JeuDe32CartesPourLaBataille();
		/*for(int i = 0; i < jeu.length; i++)
		{
		  System.out.println("Création, à l'index " + i +" du tableau nous avons = " 
				  + jeu[i].getFigure() + " de " + jeu[i].getCouleur());
		}*/
		Game.battre(32);
		/*for(int i = 0; i < jeu.length; i++)
		{
		  System.out.println("À l'emplacement " + i +" du tableau nous avons = " 
				  + jeu[i].getFigure() + " de " + jeu[i].getCouleur());
		}*/
		for(int i=0; i<32; i++)
		{
		System.out.println("A l'indice "+i+" Nous avons : " +Game.get(i).getFigure()+" de "+Game.get(i).getCouleur());
		}
		Game.couper();
		for(int i=0; i<32; i++)
		{
		System.out.println("A l'indice "+i+" Nous avons post-couper : " +Game.get(i).getFigure()+" de "+Game.get(i).getCouleur());
		}
	}
	
}
