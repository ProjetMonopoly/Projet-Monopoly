package Data;

public class CarreauArgent extends CarreauAction {
	private int _montant;

    public CarreauArgent(int _montant, int _numero, String _nomCarreau, Monopoly monop) {
        super(_numero, _nomCarreau, monop);
        this._montant = _montant;
    }

   

    @Override
     public void action(Joueur j) {
        Monopoly m = super.getMonopoly();
        Interface inter= m.getInter();
        
        Carreau courant= j.getCarreau();
        
        if((courant.getNumcarreauCourant()>=1) && (courant.getNumcarreauCourant()>=1)){
            int c=j.getCash();
            j.setCash(c+200);
            inter.InfoDepart();
        }
        if(courant.getNumcarreauCourant()==5){
            int c=j.getCash();
            j.setCash(c-200);
            inter.InfoImpot();
        }
        if(courant.getNumcarreauCourant()==11){
            if(!j.isPrison()){
                inter.InfoVisitePrison();
            }
        }
        if(courant.getNumcarreauCourant()==21){
            inter.InfoParc();
        }
        if(courant.getNumcarreauCourant()==39){
            int c=j.getCash();
            j.setCash(c-100);
            inter.InfoLuxe();
        }
        
    }
        
        
}