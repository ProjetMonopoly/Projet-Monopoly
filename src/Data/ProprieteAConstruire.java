package Data;

import static Data.CouleurPropriete.*;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private final int nbMaisons = 0;
	private ArrayList<Integer> lesloyerMaison;
        private Groupe groupePropriete;
        //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge

    public ProprieteAConstruire(ArrayList<Integer> lesloyerMaison, int loyerBase, int prixAchat, int numero, String nomCarreau, Monopoly monop) {
        super(loyerBase, prixAchat, numero, nomCarreau,monop);
        this.lesloyerMaison = lesloyerMaison;
      
       
    }        
    public String getConstruction() {
		if (nbMaisons==5){
                    return "1 hotel";
                }
                else if(nbMaisons==1){
                    return "1 maison";
                }
                else if(nbMaisons==0){
                    return "0 maison";
                }
                return (String.valueOf(nbMaisons)+" maisons");
                    
	}

	public CouleurPropriete getcouleurProp() {
		return groupePropriete.getCouleur();
	}

        public String getNomMaison() {
		return super.getNomC();
	}

	public void calculLoyerPAC(CouleurPropriete aCoul, int aNbc) {
		//regarder les  couleurs;
	}

	public void construire() {
		throw new UnsupportedOperationException();
	}

	public void debutConstruction(Joueur aJ, ProprieteAConstruire aP) {
		throw new UnsupportedOperationException();
	}

	public Groupe getGroupe() {
		return groupePropriete;
	}
        
        public String getCouleurGroupe(){
            return groupePropriete.getCouleur().name();
        }
        
        public Joueur getPropriétaire(){
            return super.getProprietaire();
        }

        @Override
        public void calculLoyer(Joueur j) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void action(Joueur j) {
            Joueur jProprio = getProprietaire();

            if (jProprio == null){
                this.achatPropriete(j);
            }
        }
        
    

    public Monopoly getMonopoly() {
            return super.getMonopoly();
        }
        
    @Override
    public void achatPropriete(Joueur j){
		int prixA=getPrixAchat();  //pour avoir le prix du carreau
                
                Monopoly m = this.getMonopoly();  // Pour obtenir le monop
              
                
                Joueur joueurActuel = j; //variable pour le joueur actuel
                
                
                int cashJ = joueurActuel.getCash();
                
                
                
                if (cashJ > prixA){
                    m.ProcedureAchat(joueurActuel, this);
                    System.out.println("Le joueur " + joueurActuel.getNomJoueur() + " veut acheté " + this.getNomC() + " ?");
                    
                    Boolean confirmer = false;
                    confirmer = m.AchatProp();
                    
                    if (confirmer == true){
                        this.setProprio(joueurActuel);
                        joueurActuel.setCash(cashJ-prixA);
                        joueurActuel.addProprietes(this);
                        
                        
                    }
                                     
                }
    }
    public int getNbMaisons() {
        return nbMaisons;
    }

    public ArrayList<Integer> getLesloyerMaison() {
        return lesloyerMaison;
    }

    public Groupe getGroupePropriete() {
        return groupePropriete;
    }
    
    public void construire(Joueur j) {
		Groupe gr;
                int c;
                
                ArrayList<ProprieteAConstruire> possibleConstruction;
                
                gr=this.getGroupe();
                possibleConstruction= VerifConstruction(j,gr);
                
                super.getMonopoly().ProcedureConstruire(j,possibleConstruction);
                    
	}
        public ArrayList<ProprieteAConstruire> VerifConstruction(Joueur j, Groupe gr){
                int prixMaison;
                int NbMaisons;
                int c;
                boolean possedeGr;
                
                NbMaisons= super.getMonopoly().getNbMaisons();
                possedeGr= j.PossedeGroupe(gr);
                c= j.getCash();
                prixMaison= gr.getPrixAchatMaison();
                ArrayList<ProprieteAConstruire> terrain= new ArrayList();
                
                if(NbMaisons!=0 && possedeGr && c>=prixMaison){
                    terrain= TerrainConstructible(gr);
                }
                return terrain;
        }
        
        public ArrayList<ProprieteAConstruire> TerrainConstructible (Groupe gr){
            ArrayList<ProprieteAConstruire> terrainGr= new ArrayList();
            ArrayList<ProprieteAConstruire> terrainConstruc= new ArrayList();
            ProprieteAConstruire pac1;
            ProprieteAConstruire pac2;
            ProprieteAConstruire pac3;
            
            terrainGr=gr.getLesproprietes();
            
            pac1=terrainGr.get(0);
            pac2=terrainGr.get(1);
            int n1=pac1.getNbMaisons();
            int n2=pac2.getNbMaisons();
            
            
            if(terrainGr.get(2)!=null){
                pac3=terrainGr.get(2);
                int n3=pac3.getNbMaisons();
                
                if(n1==n2 && n2==n3 && n1<5 ){
                    terrainConstruc.add(pac1);
                    terrainConstruc.add(pac2);
                    terrainConstruc.add(pac3);
                }
                
                if(n1==n2-1 && n1==n3 && n1<5){
                    terrainConstruc.add(pac1);
                    terrainConstruc.add(pac3);
                }
                if(n1==n2 +1 && n1==n3 && n1<=5){
                    terrainConstruc.add(pac2);
                }
                if(n1-1==n2 && n2==n3 && n2<5){
                    terrainConstruc.add(pac2);
                    terrainConstruc.add(pac3);
                }
                if(n1+1==n2 && n2==n3 && n2<=5){
                    terrainConstruc.add(pac1);
                }
                if(n1==n3-1 && n1==n2 && n1<5){
                    terrainConstruc.add(pac1);
                    terrainConstruc.add(pac2);
                }
                if(n1==n3 +1 && n1==n2 && n1<=5){
                    terrainConstruc.add(pac3);
                }
                
                
                if(n1==n2 && n2==n3 && n1==5 ){
                    return null;
                }
                
                return terrainConstruc;
              
            
            }
            
            
            if(n1==n2 && n1<5){
                terrainConstruc.add(pac1);
                terrainConstruc.add(pac2);
            }
            if(n1==n2-1 && n1<5){
                terrainConstruc.add(pac1);
            }
            if(n1==n2 +1 &&n1<=5){
                terrainConstruc.add(pac2);
            }
            if(n1-1==n2 && n1<=5){
                terrainConstruc.add(pac2);
            }
            if(n1+1==n2 && n1<5){
                terrainConstruc.add(pac1);
            }
            if(n1==n2 && n1==5){
                return null;
            }
            return terrainConstruc;
        }
        
        
	
}