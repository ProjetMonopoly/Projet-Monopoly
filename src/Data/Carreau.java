package Data;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
	private Monopoly monopoly;
        
        public Carreau(int _numero, String _nomCarreau, Monopoly monop) {
            this.numero = _numero;
            this.nomCarreau = _nomCarreau;
            this.monopoly = monop;
        }

       

        public String getNomCarreau() {
            return nomCarreau;
	}
        

	public void setNumero(int numero) {
            this.numero=numero;
	}


	public int getNumPositionCourante() {
            return numero;
	}


        public Monopoly getMonopoly() {
            return monopoly;
        }

        public void setMonopoly(Monopoly monopoly) {
            this.monopoly = monopoly;
        }

    
        public abstract void action(Joueur j);
        

        
        
        

        
        
        
}