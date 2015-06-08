package Data;

public class Interface {
	public Monopoly _monopoly;

	public void infoJoueur(int D, Carreau c, Joueur j) {
                System.out.println("Le joueur "+ j.getNomJoueur()+" :");
                System.out.println("Total des dés : "+ D);
                System.out.println("Le nom du carreau : "+ c.getNomCarreau());
	}

	public void infoJoueur2(Joueur j, Carreau c ) {
                System.out.println("Le joueur "+ j.getNomJoueur()+" est sur la case "+ c.getNomCarreau()+ "avec "+ j.getCash()+"€ comme argent.");
		System.out.println("Ces propriétés sont: " );       
	}

	public void infoPropriete(ProprieteAConstruire p, Groupe groupe) {
		System.out.println("La propriété "+ p.getNomCarreau()+" a pour groupe "+ groupe.getCouleur()+ "et possède "+ p.getConstruction());
	}

	public void InfosLoyerGare(Joueur aJProprio, int aL, int aCash) {
		throw new UnsupportedOperationException();
	}

	public void InfoAchat(Joueur aJ, CarreauPropriete aCp) {
		throw new UnsupportedOperationException();
	}

	public void InfoConstruire(Joueur aJ, Groupe aPossibleConstruction) {
		throw new UnsupportedOperationException();
	}

	public void InfosLoyerCompagnie(Joueur aJProprio, int aL, int aCash) {
		throw new UnsupportedOperationException();
	}

	public void InfosLoyerPAC(Joueur aJProprio, int aL, int aCash) {
		throw new UnsupportedOperationException();
	}

	public void InfoTerrain(Joueur j, Groupe gr) {
		
	}
}