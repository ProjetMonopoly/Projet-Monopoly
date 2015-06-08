package Data;

public class Compagnie extends CarreauPropriete {

    public Compagnie(int _loyerBase, int _prixAchat, int _numero, String _nomCarreau, Monopoly monop) {
        super(_loyerBase, _prixAchat, _numero, _nomCarreau,monop);
    }
    public void calculLoyerCompagnie(int aD, int aLb) {
		throw new UnsupportedOperationException();
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
                        joueurActuel.addCompanie(this);
                        
                        
                    }
                                     
                }
    }
    
}