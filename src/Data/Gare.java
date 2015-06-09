package Data;

public class Gare extends CarreauPropriete {

    
    public Gare(int _loyerBase, int _prixAchat, int _numero, String _nomCarreau, Monopoly monop) {
        super(_loyerBase, _prixAchat, _numero, _nomCarreau,monop);
    }

        
    
    public int calculLoyerGare(int aNbg) {
		return 25*aNbg;
	}
    
    

    @Override
    public void calculLoyer(Joueur j) { //rien avoir uml
        
        
        int nbg = j.getNbGares();// pour avoir le nombre de gare du joueur proprietaire
        
        int l = this.calculLoyerGare(nbg);
        
        j.setLoyer(l); // pour avoir le prix du loyer
        
        Monopoly m = super.getMonopoly();
        
        m.InfosLoyer(j, l);
        
        
        
    }

    public Monopoly getMonopoly() {
            return super.getMonopoly();
        }
    
    @Override
    public void action(Joueur j) {
        Joueur jProprio = this.getProprietaire();
        
        if (jProprio == null){
            this.achatPropriete(j);
        }else if (jProprio == j)
        {System.out.println("Vous etes les propriétaires, vous n'avez rien à payer");
        }else{
            this.calculLoyer(jProprio);
            
            int loyerPro = jProprio.getLoyer();
            
            jProprio.recevoirLoyer(loyerPro);
            j.PayerLoyer(loyerPro);
            
            Monopoly M = getMonopoly();
           
            M.infoJoueur3(j);
            
        }
    }

    @Override
    public void achatPropriete(Joueur j){
		int prixA = this.getPrixAchat();  //pour avoir le prix du carreau               
                
                int cashJ = j.getCash();
                       
                if (cashJ >= prixA){
                    
                Monopoly m = this.getMonopoly();  // Pour obtenir le monop
                
                m.ProcedureAchat(j,this);  //envoi un message
                    
                boolean confirmer = false;
                confirmer = m.AchatProp();
                    
                if (confirmer == true){
                    super.setProprio(j);
                    j.setCash(cashJ-prixA);
                    j.addGare(this); 
                    
                    System.out.println("Tu as acheté la gare");
                    System.out.println("");
                }
                                     
                }else{
                    System.out.println("Le joueur " + j.getNomJoueur() + " ne peut pas acheter la case " + super.getNomC());
                }
                
    }
    
            
            
}
