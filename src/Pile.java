
public class Pile {
	 private Carte[] pile;
	    private int sommet;

	    public Pile(int a){
	       pile = new Carte[a];
	       sommet=0;
	    }

	    public Pile(Carte[] pile, int sommet) {
	        this.pile = pile;
	        this.sommet = sommet;
	    }

	 
	    public Pile() {
	    }

	    public Pile(Carte[] pile) {
	        this.pile = pile;
	    }


	    public void empiler(Carte t){
	        pile[sommet++]=t;
	    }

	    public Carte sommet(){
	        return pile[sommet-1];
	    }

	    public Carte depile(){
	        return pile[--sommet];
	    }

	    public boolean vide(){
	        return sommet ==0;
	    }
	    
	    public int nombreDeCarte(){
	    	return sommet;
	    }


}
