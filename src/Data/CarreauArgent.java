package Data;

public class CarreauArgent extends CarreauAction {
	private int _montant;

    public CarreauArgent(int _montant, int _numero, String _nomCarreau) {
        super(_numero, _nomCarreau);
        this._montant = _montant;
    }
        
        
}