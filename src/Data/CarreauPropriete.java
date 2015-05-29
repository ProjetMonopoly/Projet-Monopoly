package Data;

public abstract class CarreauPropriete extends Carreau {
	private int _loyerBase;
	private int _prixAchat;
	private Joueur _proprietaire;

        public CarreauPropriete(int _loyerBase, int _prixAchat, int _numero, String _nomCarreau) {
            super(_numero, _nomCarreau);
            this._loyerBase = _loyerBase;
            this._prixAchat = _prixAchat;
        }

        
        	public int getPrixAchat() {
		return this._prixAchat;
	}

	public void achatPropriete() {
		throw new UnsupportedOperationException();
	}

	public void Infos(String aNomCarreau, String aNomG) {
		throw new UnsupportedOperationException();
	}

	public String getNomC() {
		throw new UnsupportedOperationException();
	}

	public void setProprio(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public boolean estProprio() {
		throw new UnsupportedOperationException();
	}

	public int getNbMaison() {
		throw new UnsupportedOperationException();
	}

	public void calculLoyer() {
		throw new UnsupportedOperationException();
	}

	public boolean ConstruireRep(Joueur aJ, CouleurPropriete aCouleur, CarreauPropriete aCp) {
		throw new UnsupportedOperationException();
	}
        
        
        
}