package jeu;

import swing.VisionnageBataille;


public class Jeu {
	static Jeu32CartesPourLaBataille Game = new Jeu32CartesPourLaBataille();
	static File main1 = new File(32);
	static File main2 = new File(32);
	static Pile pli1 = new Pile(32);
	static Pile pli2 = new Pile(32);
	static Joueur P1 = new Joueur("Pierre", main1);
	static Joueur P2 = new Joueur("Paul", main2);
	static VisionnageBataille GUI = new VisionnageBataille(P1.getNom(),P2.getNom());

	static void distribution(){
		for(int i = 0; i < 32; i++){
			Carte c;

			if(i%2 == 0){

				c = Game.get(i);
				main1.entrer(c);
			}

			else{

				c = Game.get(i);
				main2.entrer(c);
			}
		}

	}
	static void remplissage(Pile p, File t){
		p.empiler(t.sortir());



	}
	static void remplissageMain(File t, Pile p, int k){
		for(int i =0; i<k;i++){
			t.entrer(p.sommet());
			p.depile();
		}

	}
  
/*  static void comparer(jeu.Carte c1, jeu.Carte c2){
	  System.out.println("");
	  int nBc = pli1.nombreDeCarte();
          if(c1.getValeur() > c2.getValeur()){
        	  
        	  remplissageMain(p1, pli1, nBc);
        	  remplissageMain(p1, pli2, nBc);
        	  
              System.out.println(P1.getNom() + " gagne le pli");
          }
          else if(c2.getValeur() > c1.getValeur()){
        	  
        	  remplissageMain(p2, pli2, nBc);
        	  remplissageMain(p2, pli1, nBc);
        	  
              System.out.println(P2.getNom()+ " gagne le pli");
          }
          else if(c1.getValeur() == c2.getValeur()){
        	  if(p1.nombreMain()>=2 && p2.nombreMain()>=2){
              System.out.println("jeu.Bataille !!");
              
              for (int i = 0; i<2;i++){
            	  
            	remplissage(pli1,p1);
            	remplissage(pli2,p2);
            	
              }
        	  }
        	  else if(p2.nombreMain() == 0){
            	  System.out.println(P1.getNom()+ " a gagné");
              }
        	  else {
        		  System.out.println(P2.getNom()+ " a gagné");
        	  }
              System.out.println(P1.getNom() + " : "+ pli1.sommet().getFigure() + " de " + pli1.sommet().getCouleur());
              System.out.println(P2.getNom() + " : "+ pli2.sommet().getFigure() + " de " + pli2.sommet().getCouleur());
             
          
        	  
          }
          
      }*/


	public static void Jeu() throws InterruptedException {
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
	/*for(int i=0; i<32; i++)
	{
	System.out.println("A l'indice "+i+" Nous avons : " +Game.get(i).getFigure()+" de "+Game.get(i).getCouleur());
	}*/
		Game.couper();
	/*for(int i=0; i<32; i++)
	{
	System.out.println("A l'indice "+i+" Nous avons post-couper : " +Game.get(i).getFigure()+" de "+Game.get(i).getCouleur());
	}*/

		distribution();


		System.out.println("Les joueurs sont : " +P1.getNom()+" et "+P2.getNom());
		int compteur = 0;

		while(main1.vide() != true || main2.vide() != true){
			compteur++;
			System.out.println("Tour : " +compteur);
			System.out.println("La main de "+P1.getNom()+" est :");
			GUI.setNbCartes1(main1.getTailleMain());

			main1.affiche();

			System.out.println("");
			System.out.println("La main de "+P2.getNom()+" est :");
			GUI.setNbCartes2(main2.getTailleMain());

			main2.affiche();

			//Remplissage de chaque jeu.Pile
			remplissage(pli1,main1);
			remplissage(pli2,main2);
			System.out.println("");
			System.out.println(P1.getNom()+ " pose la carte : "
					+ pli1.sommet().getFigure() + ":" + pli1.sommet().getCouleur() );
			GUI.setCarteTas1(pli1.sommet());
			System.out.println(P2.getNom()+ " pose la carte : "
					+ pli2.sommet().getFigure() + ":" + pli2.sommet().getCouleur() );
			GUI.setCarteTas2(pli2.sommet());
			Thread.sleep(1000);
	
/*	else if(p2.vide() == true){
		System.out.println(P1.getNom()+ " a gagné");
		
	}
	else {
		System.out.println(P2.getNom()+ " a gagné");
		
	}*/


			//Comparaison des cartes au sommet des piles
			while (pli1.nombreDeCarte() !=0) {
				//comparer(pli1.sommet(),pli2.sommet());
				System.out.println("");
				int nBc = pli1.nombreDeCarte();
				if(pli1.sommet().getValeur() > pli2.sommet().getValeur()){

					remplissageMain(main1, pli1, nBc);
					remplissageMain(main1, pli2, nBc);

					System.out.println(P1.getNom() + " gagne le pli");
				}
				else if(pli2.sommet().getValeur() > pli1.sommet().getValeur()){

					remplissageMain(main2, pli2, nBc);
					remplissageMain(main2, pli1, nBc);

					System.out.println(P2.getNom()+ " gagne le pli");
				}
				else if(pli1.sommet().getValeur() == pli2.sommet().getValeur()){
					if(main1.nombreMain()>=2 && main2.nombreMain()>=2){
						System.out.println("jeu.Bataille !!");

						for (int i = 0; i<2;i++){

							remplissage(pli1,main1);
							System.out.println("La carte " + pli1.sommet().getFigure() + ":" + pli1.sommet().getCouleur() + " est posée");
							remplissage(pli2,main2);
							System.out.println("La carte " + pli2.sommet().getFigure() + ":" + pli2.sommet().getCouleur() + " est posée");

						}
					}
					else{
						break;
					}
					System.out.println(P1.getNom() + " : "+ pli1.sommet().getFigure() + ":" + pli1.sommet().getCouleur());
					System.out.println(P2.getNom() + " : "+ pli2.sommet().getFigure() + ":" + pli2.sommet().getCouleur());



				}

			}
			System.out.println("----------------------------------------------------------------------------------------------");
			if (main1.vide() == true){
				System.out.println(P2.getNom() + " a gagné la partie");
				GUI.setGagnant(1);
				break;
			}
			else if(main2.vide() == true){
				System.out.println(P1.getNom() + " a gagné la partie");
				GUI.setGagnant(2);
				break;
			}
		}

	}


}
