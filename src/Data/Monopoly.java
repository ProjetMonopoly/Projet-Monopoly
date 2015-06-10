package Data;

import Data.Carreau;
import static Data.CouleurPropriete.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Monopoly {

    private int nbMaisons = 32;

    private int nbHotels = 12;
//        private int des;//pour le resultat du lancé de des
    private int numero; //pour le numero de la case en cour
    private HashMap<Integer, Carreau> lescarreaux;
    private ArrayList<Joueur> lesjoueurs = new ArrayList<Joueur>();
    public Interface inter;
    private ArrayList<Integer, Carte> Chance;
    private ArrayList<Integer, Carte> Communauté;
    private ArrayList<Groupe> groupe = new ArrayList<>();
    private HashMap<String,Integer> ordre = new HashMap<>();

    public HashMap<Integer, Carreau> getLesCarreaux() {
        return lescarreaux;
    }

    public Interface getInter() {
        return inter;
    }

    
    
    public int resultatDés(Joueur j) {
        Random rnd = new Random();
        int i = rnd.nextInt(6) + 1;

        return i;
//            int des1 = ((int) (Math.random()*6) + 1);
//            int des2 = ((int) (Math.random()*6) + 1);
//            
//            if (des1==des2){ //si le joueur a un double alors se compteur de double augmente
//                j.setDouble(j.getDouble()+1);
//                
//                if(j.getDouble()==3)
//                
//                return (((int) (Math.random()*6) + 1) + ((int) (Math.random()*6)+1)); //a voir si il refait encore un double
//            }else {return (((int) (Math.random()*6) + 1) + ((int) (Math.random()*6)+1));}
    }


    public boolean AchatProp() {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Vous voulez l'acheter (oui/non) ? ");
        String reponse = sc1.nextLine();

        String oui = "oui";
        if (oui.equals(reponse)) {
            return true;
        } else {
            return false;
        }
    }

    public void InfosLoyerJoueur(Joueur j, int l) {
        inter.InfosLoyerJoueur(j, l);
    }

    public void InfosLoyerPro(Joueur j, int l) {
        inter.InfosLoyerPro(j, l);
    }

    public ArrayList<Joueur> getJoueurs() {
        return lesjoueurs;
    }

    public void setLesJoueurs(Joueur j) {
        lesjoueurs.add(j);
    }

    public void ProcedureAchat(Joueur aJ, CarreauPropriete aCp) {
        System.out.println("Le joueur " + aJ.getNomJoueur() + " a la possibilité d'acheter la case " + aCp.getNomC());
    }

    public void ProcedureConstruire(Joueur j, ArrayList<ProprieteAConstruire> possibleConstruction) {
        inter.InfoConstruire(j, possibleConstruction);
    }

    public boolean getReponse(Joueur j, ProprieteAConstruire pac) {
        pac.debutConstruction(j);
        return true;

    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }

    public void choixTerrain(Joueur aJ, Groupe aGr) {
        throw new UnsupportedOperationException();
    }

    public void CréerGroupe() {
        //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge
        Groupe Bleufonce = new Groupe(null, bleuFonce);
        Groupe Orange = new Groupe(null, orange);
        Groupe Mauve = new Groupe(null, mauve);
        Groupe Violet = new Groupe(null, violet);
        Groupe Bleuciel = new Groupe(null, bleuCiel);
        Groupe Jaune = new Groupe(null, jaune);
        Groupe Vert = new Groupe(null, vert);
        Groupe Rouge = new Groupe(null, rouge);

        groupe.add(Bleufonce);
        groupe.add(Orange);
        groupe.add(Mauve);
        groupe.add(Violet);
        groupe.add(Bleuciel);
        groupe.add(Jaune);
        groupe.add(Vert);
        groupe.add(Rouge);

    }

    public void CréerCartesChance() {
        CarteSpecial BreakFree = new CarteSpecial("Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.", this);
        CarteDeplace ReculeTroisCases = new CarteDeplace("Reculez de trois cases.", this);
        CartePArgent ImpMaison = new CartePArgent(0, "Vous êtes imposés pour les réparations de voirie à raison de : 40€ par maison et 115€ par hôtel.", this);
        CartePArgent ExesVitesse = new CartePArgent(15, "Amende pour excès de vitesse : 15€.", this);
        CartePArgent RepMaison = new CartePArgent(0, "Faites des réparations dans toutes vos maisons : versez pour chaque maison 25€ et pour chaque hôtel 100€.", this);
        CartePArgent Ivresse = new CartePArgent(20, "Amende pour ivresse : 20€.", this);
        CarteDeplace CaseDep = new CarteDeplace("Avancez jusqu'à la case Départ.", this);
        CartePrison AllerPrison = new CartePrison("Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne recevez pas 200€.", this);
        CarteDeplace AllerHenriMartin = new CarteDeplace("Rendez-vous à l'Avenue Henri-Martin. Si vous passez par la case Départ, recevez 200€.", this);
        CarteDeplace AllerGdeLyon = new CarteDeplace("Allez à la gare de Lyon. Si vous passez par la case Départ, recevez 200€.", this);
        CartePArgent Fscolarite = new CartePArgent(150, "Payez pour frais de scolarité : 150€.", this);
        CarteGArgent MotsCroisés = new CarteGArgent(100, "Vous avez gagné le prix de mots croisés. Recevez 100€.", this);
        CarteGArgent BanqDivi = new CarteGArgent(50, "La Banque vous verse un dividende de 50€.", this);
        CarteDeplace AllerRdePaix = new CarteDeplace("Rendez-vous à la Rue de la Paix.", this);
        CarteGArgent ImmeublePret = new CarteGArgent(150, "Votre immeuble et votre prêt rapportent. Vous devez toucher 150€", this);
        CarteDeplace AllerBoulevard = new CarteDeplace("Accédez au Boulevard de la Villette. Si vous passez par la case Départ, recevez 200€.", this);


    
        Chance.put(1, BreakFree);
        Chance.put(2, ReculeTroisCases);
        Chance.put(3, ImpMaison);
        Chance.put(4, ExesVitesse);
        Chance.put(5, RepMaison);
        Chance.put(6, Ivresse);
        Chance.put(7, CaseDep);
        Chance.put(8, AllerPrison);
        Chance.put(9, AllerHenriMartin);
        Chance.put(10, AllerGdeLyon);
        Chance.put(11, Fscolarite);
        Chance.put(12, MotsCroisés);
        Chance.put(13, BanqDivi);
        Chance.put(14, AllerRdePaix);
        Chance.put(15, ImmeublePret);
        Chance.put(16, AllerBoulevard);

    }

    public void LancerDésEtAvancer(Joueur j) {
        inter = new Interface();
        boolean verif = true;

        System.out.println("");
        int des1 = 0;
        int des2 = 0;
   
        des1 = resultatDés(j);
        des2 = resultatDés(j);
        int des = 0;
        j.setDouble(0);
        des = des1 + des2;

        j.setDes(des);
        j.ModifPosition(des);

        Carreau carreauCourant = lescarreaux.get(j.getDeplacement()); //le nouveaux carreau avec le deplacement
        j.setPositionCourante(carreauCourant); //j'associe le carreaux ou le joueur est apres son deplacement

        inter.infoJoueur(des, carreauCourant, j);
        System.out.println("");

		ArrayList<Joueur> collectionJoueur = new ArrayList<>();
		collectionJoueur = lesjoueurs;

        inter.infoJoueur2(j, carreauCourant);
        System.out.println("");

        //}
    }

    public void JouerUnCoup(Joueur j) {
        LancerDésEtAvancer(j);

        Carreau c = j.getCarreau(); // pour avoir le carreau actuel

        if ((c.getNumcarreauCourant() == 6) || (c.getNumcarreauCourant() == 16) || (c.getNumcarreauCourant() == 26) || (c.getNumcarreauCourant() == 36)) {

            c.action(j);  //gare

        }else if ((c.getNumcarreauCourant() == 13) || (c.getNumcarreauCourant() == 29)){
           
            c.action(j);//companie
            
        }else if ((c.getNumcarreauCourant() == 1) || (c.getNumcarreauCourant() == 5)||(c.getNumcarreauCourant() == 11) || (c.getNumcarreauCourant() == 21)|| (c.getNumcarreauCourant() == 39)){
            //case argent
        }else if ((c.getNumcarreauCourant() == 3) || (c.getNumcarreauCourant() == 8)||(c.getNumcarreauCourant() == 18) || (c.getNumcarreauCourant() == 23)|| (c.getNumcarreauCourant() == 34)|| (c.getNumcarreauCourant() == 37)){
            //case tirage
        }else if ((c.getNumcarreauCourant() == 31)){
            //case mouvement
        }else {
            //case propriete
        }
            

    }
        }
    
    public void InitialiserPartie(){
     
        Carreau carreauInit = lescarreaux.get(1);
        int nbJoueur;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Combien de joueur: ");
        nbJoueur = Integer.parseInt(sc1.nextLine());
        
        System.out.println("Entrer le nom du joueur " + 1 + " :");
        Joueur j1 = new Joueur(sc1.nextLine(),this,carreauInit);
      
        
        for (int i = 1; i <= nbJoueur; i++) {
            System.out.println("Entrer le nom du joueur " + i + " :");
            Joueur j = new Joueur(sc1.nextLine(), this, carreauInit);
            int de1 = j.resultatDés();
            int de2 = j.resultatDés();
            int des = de1+de2;
            ordre.put(j.getNomJoueur(),des);
            }
        System.out.println(ordre);
        TreeMap<String,Integer> sorted = SortByValue(ordre);
        System.out.println(sorted);
    }
    
    public static TreeMap<String,Integer> SortByValue (HashMap<String,Integer> map){
        ValueComparator vc = new ValueComparator(map);
        TreeMap<String,Integer> sorted= new TreeMap<String,Integer>(vc);
        sorted.putAll(map);
        return sorted;
        
}

    

    /**
     * @param aCash  
     */
    public Monopoly(String dataFilename) {
        buildGamePlateau(dataFilename);
    }

    @SuppressWarnings("empty-statement")
    private void buildGamePlateau(String dataFilename) { ///message 
        try {

            // mettre des commentaires 
            lescarreaux = new HashMap<Integer, Carreau>();
            Carreau carreau;
            Carreau carreauAConstruire;
            ArrayList<Integer> loyer;
            ArrayList<ProprieteAConstruire> pro;
            ArrayList<String[]> data = readDataFile(dataFilename, ",");

            //TODO: create cases instead of displaying
            loyer = new ArrayList<>();
            pro = new ArrayList<>();

            for (int i = 0; i < data.size(); ++i) {
                String caseType = data.get(i)[0];
                if (caseType.compareTo("P") == 0) {
                    System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    for (int j = 5; 10 >= j; j++) {
                        loyer.add(Integer.parseInt(data.get(i)[j]));
                    }

                    //Groupe(int _prixAchatMaison, CouleurPropriete _couleur)
                    //ProprieteAConstruire(ArrayList<Integer> _loyerMaison, Groupe _groupePropriete, int _loyerBase, int _prixAchat, int _numero, String _nomCarreau)
                    carreauAConstruire = new ProprieteAConstruire(loyer, Integer.parseInt(data.get(i)[5]), Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);

                    for (Groupe g : groupe) {

                        if ((CouleurPropriete.valueOf(data.get(i)[3])) == g.getCouleur()) {
                            g.addPropriete((ProprieteAConstruire) carreauAConstruire);

                        }
                    }

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauAConstruire);

                    System.out.println("ajouté propriété fait");

                } else if (caseType.compareTo("G") == 0) {
                    System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    carreauAConstruire = new Gare(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauAConstruire);

                    System.out.println("ajouté gare fait");

                } else if (caseType.compareTo("C") == 0) {
                    System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    carreauAConstruire = new Compagnie(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauAConstruire);

                    System.out.println("ajouté Companie fait");

                } else if (caseType.compareTo("CT") == 0) {
                    System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    carreauAConstruire = new CarreauTirage(Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauAConstruire);

                    System.out.println("ajouté carte tirage fait");

                } else if (caseType.compareTo("CA") == 0) {
                    System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    carreauAConstruire = new CarreauArgent(Integer.parseInt(data.get(i)[3]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauAConstruire);

                    System.out.println("ajouté case argent fait");
                } else if (caseType.compareTo("CM") == 0) {
                    System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);

                    carreauAConstruire = new CarreauMouvement(Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauAConstruire);

                    System.out.println("ajouté case mouvement fait");
                } else {
                    System.err.println("[buildGamePleateau()] : Invalid Data type");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("[buildGamePlateau()] : File is not found!");
        } catch (IOException e) {
            System.err.println("[buildGamePlateau()] : Error while reading file!");
        }
    }

    private void buildGameJoueur(ArrayList<Joueur> lesjoueurs) {
        this.lesjoueurs = lesjoueurs;
    }

    private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException {
        ArrayList<String[]> data = new ArrayList<String[]>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        while ((line = reader.readLine()) != null) {
            data.add(line.split(token));
        }
        reader.close();

        return data;
    }

}
    


        