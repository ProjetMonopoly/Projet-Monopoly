public abstract class CarreauPropriete extends Carreau {
	private int _loyerBase;
	private int _prixAchat;
	private Joueur _proprietaire;

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

	public CouleurPropriete getNomGr() {
		throw new UnsupportedOperationException();
	}
}