package Data;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
	private Monopoly monopoly;
        
        public Carreau(int _numero, String _nomCarreau) {
            this.numero = _numero;
            this.nomCarreau = _nomCarreau;
        }

       
        ///fdsf sdfsdfsdfsd
        public String getNomCarreau(int numero) {
            this.numero=numero;
            return nomCarreau;
	}
        

	public void setNumero(int numero) {
            this.numero=numero;
	}

	public boolean getReponse() {
            throw new UnsupportedOperationException();
	}

	public int getNumcarreauCourant() {
            return numero;
	}

	public String getNomCarreauMaison() {
            return nomCarreau;
	}

        
        
        
}