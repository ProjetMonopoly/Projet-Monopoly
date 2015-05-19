import java.util.ArrayList;

public class Joueur {
	private String _nomJoueur;
	private int _cash = 1500;
	private Monopoly _monopoly;
	private ArrayList<Compagnie> _compagnies = new ArrayList<Compagnie>();
	private ArrayList<Gare> _gares = new ArrayList<Gare>();
	private Carreau _positionCourante;
	private ArrayList<ProprieteAConstruire> _proprietesAConstruire = new ArrayList<ProprieteAConstruire>();

	public int getCash() {
		return this._cash;
	}

	public void ajouterPropriete(Carreau aCp) {
		throw new UnsupportedOperationException();
	}

	public String getNomJoueur() {
		return this._nomJoueur;
	}

	public int getNbGares() {
		throw new UnsupportedOperationException();
	}

	public void setCash(int aPrixA) {
		this._cash = aPrixA;
	}

	public void ModifCarreau(int aD) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<ProprieteAConstruire> getLesPropio() {
		throw new UnsupportedOperationException();
	}
}