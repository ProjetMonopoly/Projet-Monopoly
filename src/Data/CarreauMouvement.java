package Data;

public class CarreauMouvement extends CarreauAction {

    public CarreauMouvement(int _numero, String _nomCarreau, Monopoly monop) {
        super(_numero, _nomCarreau, monop);
    }

   
    @Override
    public void action(Joueur j) {
        j.setPrison(true);
        
        Monopoly m = super.getMonopoly();
        Interface inter= m.getInter();
        
        Carreau carreauprison = m.getLesCarreaux().get(11);
        
        j.setPositionCourante(carreauprison);
        inter.InfoPrison();

        
    }
    
    
}