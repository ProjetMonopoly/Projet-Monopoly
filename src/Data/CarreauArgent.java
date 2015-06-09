package Data;

public class CarreauArgent extends CarreauAction {
	private int _montant;

    public CarreauArgent(int _montant, int _numero, String _nomCarreau, Monopoly monop) {
        super(_numero, _nomCarreau, monop);
        this._montant = _montant;
    }

   

    @Override
    public void action(Joueur j) {
        
    }
        
        
}