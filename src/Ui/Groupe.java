package Ui;

import java.util.ArrayList;

public class Groupe {
	private int _prixAchatMaison;
	private CouleurPropriete _couleur;
	private ArrayList<ProprieteAConstruire> _proprietes = new ArrayList<ProprieteAConstruire>();

	public CouleurPropriete getCouleur() {
		return this._couleur;
	}

	public CouleurPropriete getNomGr() {
		throw new UnsupportedOperationException();
	}
}