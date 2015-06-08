package Data;

public class Gare extends CarreauPropriete {

    
    public Gare(int _loyerBase, int _prixAchat, int _numero, String _nomCarreau, Monopoly monop) {
        super(_loyerBase, _prixAchat, _numero, _nomCarreau,monop);
    }

        
    
    public int calculLoyerGare(int aNbg) {
		return super.getLoyerBase()*aNbg;
	}
    
    

    @Override
    public void calculLoyer(Joueur j) { //rien avoir uml
        
        Joueur jproprio = super.getProprietaire();
        
        int nbg = jproprio.getNbGares(); // pour avoir le nombre de gare du joueur proprietaire
        
        jproprio.setLoyer(calculLoyerGare(nbg)); // pour avoir le prix du loyer
        
        int l = calculLoyerGare(nbg);
        
        
        System.out.println("Le proprietaire de cette case est " + jproprio.getNomJoueur() + ", le montant du loyer est " + l);
        
    }

    public Monopoly getMonopoly() {
            return super.getMonopoly();
        }
    
    @Override
    public void action(Joueur j) {
        Joueur jProprio = getProprietaire();
        
        if (jProprio == null){
            this.achatPropriete(j);
        }else if (jProprio != j){
            this.calculLoyer(jProprio);
            jProprio.recevoirLoyer(jProprio.getLoyer());
            j.PayerLoyer(jProprio.getLoyer());
            Monopoly M = getMonopoly();
            M.InfosLoyerGare(jProprio, jProprio.getLoyer(),j.getCash());
            
        }
    }

    @Override
    public void achatPropriete(Joueur j){
		int prixA = this.getPrixAchat();  //pour avoir le prix du carreau               
                
                int cashJ = j.getCash();
                       
                if (cashJ >= prixA){
                    
                Monopoly m = this.getMonopoly();  // Pour obtenir le monop
                
                m.ProcedureAchat(j,this);
                    
                boolean confirmer = false;
                confirmer = m.AchatProp();
                    
                if (confirmer == true){
                    this.setProprio(j);
                    j.setCash(cashJ-prixA);
                    j.addGare(this); 
                    
                }
                                     
                }else{
                    System.out.println("Le joueur " + j.getNomJoueur() + " ne peut pas acheter la case " + super.getNomC());
                }
                
    }
    
            
            
}
