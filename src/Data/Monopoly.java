package Data;

import Data.Carreau;
import static Data.CouleurPropriete.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
    public Interface inter= new Interface();
    private ArrayList<Carte> Chance;
    private ArrayList<Carte> Communaute;
    private ArrayList<Groupe> groupe = new ArrayList<>();
    private HashMap<Joueur,Integer> ordre = new HashMap<>();
    private LinkedList<Carte> ChanceTrie = new LinkedList<>();
    private LinkedList<Carte> CommunauteTrie = new LinkedList<>();

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

    }

    public boolean AchatProp() {

        
        if (inter.InfosAchatOuiNon()) {
            return true;
        } else {
            return false;
        }
        
    }
    public boolean construire() {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Voulez-vous construire? (oui/non) ");
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
    public void removeJoueur(Joueur j) {
        lesjoueurs.remove(j);
    }

    public void ProcedureAchat(Joueur aJ, CarreauPropriete aCp) {
        inter.InfosPossibilitéAchat(aJ, aCp);
    }

    public void ProcedureConstruire(Joueur j, ArrayList<ProprieteAConstruire> possibleConstruction) {
        inter.InfoConstruire(j, possibleConstruction, this);
    }
     public void InfoCarte(Carte ca, Joueur j){
        inter.InfoCarte(ca, j);
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
    public void actionCarte(Joueur j) {
        Carte c = TirerUneCarteChance();
        InfoCarte(c, j);
        if (c.getNumero()<=2){
            c.action(j);
        }else if (c.getNumero()>2 && c.getNumero()<=10){
            c.action(j);
        }else if(c.getNumero()>10 && c.getNumero()<=19) {
            c.action(j);
        }else if (c.getNumero()>19 && c.getNumero()<=21){
            c.action(j);
        }else {
            c.action(j);
        }
        
    }
    public void MelangeCarteCommunaute(){
        
        int taille = Communaute.size();
        for (int i=0;i<=taille;){
            
                Random rnd = new Random();
                int M = rnd.nextInt(Communaute.size());

                Carte m = Communaute.get(M);

                CommunauteTrie.add(m);

                Communaute.remove(m);
                
                taille = Communaute.size();

            }
    }        
public Carte TirerUneCarteCommunaute() {
        
            Carte c = CommunauteTrie.element();

            CommunauteTrie.remove(c);
            CommunauteTrie.add(c);

            return c;
        
    }
    public void MelangeCarteChance(){
        
        int taille = Chance.size();
        for (int i=0;i<=taille;){
            
                Random rnd = new Random();
                int M = rnd.nextInt(Chance.size());

                Carte m = Chance.get(M);

                ChanceTrie.add(m);

                Chance.remove(m);
                
                taille = Chance.size();

            }
    }        
    
        
    public Carte TirerUneCarteChance() {
        
            Carte c = ChanceTrie.element();

            ChanceTrie.remove(c);
            ChanceTrie.add(c);

            return c;
        
    }

    public void CréerGroupe() {
        //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge
        ArrayList<ProprieteAConstruire> bleuF = new ArrayList<>();
        ArrayList<ProprieteAConstruire> orang = new ArrayList<>();
        ArrayList<ProprieteAConstruire> mauv = new ArrayList<>();
        ArrayList<ProprieteAConstruire> viole = new ArrayList<>();
        ArrayList<ProprieteAConstruire> bleuC = new ArrayList<>();
        ArrayList<ProprieteAConstruire> jaun = new ArrayList<>();
        ArrayList<ProprieteAConstruire> ver = new ArrayList<>();
        ArrayList<ProprieteAConstruire> roug = new ArrayList<>();
        
        Groupe Bleufonce = new Groupe(bleuF,bleuFonce);
        Groupe Orange = new Groupe(orang,orange);
        Groupe Mauve = new Groupe(mauv,mauve);
        Groupe Violet = new Groupe(viole,violet);
        Groupe Bleuciel = new Groupe(bleuC,bleuCiel);
        Groupe Jaune = new Groupe(jaun,jaune);
        Groupe Vert = new Groupe(ver,vert);
        Groupe Rouge = new Groupe(roug,rouge);
        
        

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
        CarteSpecial BreakFree = new CarteSpecial(1,"Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.", this);
        CarteDeplace ReculeTroisCases = new CarteDeplace(3,"Reculez de trois cases.", this,-3);
        CartePArgent ImpMaison = new CartePArgent(0,11, "Vous êtes imposés pour les réparations de voirie à raison de : 40€ par maison et 115€ par hôtel.", this);
        CartePArgent ExesVitesse = new CartePArgent(15,12, "Amende pour excès de vitesse : 15€.", this);
        CartePArgent RepMaison = new CartePArgent(0,13, "Faites des réparations dans toutes vos maisons : versez pour chaque maison 25€ et pour chaque hôtel 100€.", this);
        CartePArgent Ivresse = new CartePArgent(20,14, "Amende pour ivresse : 20€.", this);
        CarteDeplace CaseDep = new CarteDeplace(4,"Avancez jusqu'à la case Départ.", this, 1);
        CartePrison AllerPrison = new CartePrison(20,"Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne recevez pas 200€.", this);
        CarteDeplace AllerHenriMartin = new CarteDeplace(5,"Rendez-vous à l'Avenue Henri-Martin. Si vous passez par la case Départ, recevez 200€.", this,25);
        CarteDeplace AllerGdeLyon = new CarteDeplace(6,"Allez à la gare de Lyon. Si vous passez par la case Départ, recevez 200€.", this, 16);
        CartePArgent Fscolarite = new CartePArgent(150,15, "Payez pour frais de scolarité : 150€.", this);
        CarteGArgent MotsCroisés = new CarteGArgent(100,22, "Vous avez gagné le prix de mots croisés. Recevez 100€.", this);
        CarteGArgent BanqDivi = new CarteGArgent(50,23, "La Banque vous verse un dividende de 50€.", this);
        CarteDeplace AllerRdePaix = new CarteDeplace(7,"Rendez-vous à la Rue de la Paix.", this, 40);
        CarteGArgent ImmeublePret = new CarteGArgent(150,24, "Votre immeuble et votre prêt rapportent. Vous devez toucher 150€", this);
        CarteDeplace AllerBoulevard = new CarteDeplace(8,"Accédez au Boulevard de la Villette. Si vous passez par la case Départ, recevez 200€.", this,12);
        
        Chance.add(BreakFree);
        Chance.add(ReculeTroisCases);
        Chance.add(ImpMaison);
        Chance.add(ExesVitesse);
        Chance.add(RepMaison);
        Chance.add(Ivresse);
        Chance.add(CaseDep);
        Chance.add(AllerPrison);
        Chance.add(AllerHenriMartin);
        Chance.add(AllerGdeLyon);
        Chance.add(Fscolarite);
        Chance.add(MotsCroisés);
        Chance.add(BanqDivi);
        Chance.add(AllerRdePaix);
        Chance.add(ImmeublePret);
        Chance.add(AllerBoulevard);
    }

      

    
    public void CreerCarteCommunaute() {
        CarteSpecial BreakFree = new CarteSpecial(2,"Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.", this);
        CartePArgent Amende = new CartePArgent(10,16, "Payez une amende de 10€.", this);
        CarteGArgent Anniversaire = new CarteGArgent(10,25, "C'est votre anniversaire. Chaque joueur doit vous donner 10€", this);
        CarteGArgent ErreurBanq = new CarteGArgent(200,26, "Erreur de la banque en votre faveur. Recevez 200€", this);
        CarteDeplace AllerBelleville = new CarteDeplace(9,"Retournez à Belleville", this,2);
        CartePArgent NoteMedecin = new CartePArgent(50,17, "Payez la note du médecin : 50€.", this);
        CarteGArgent ContribuRembourse = new CarteGArgent(20,27, "Les contributions vous remboursent la somme de 20€.", this);
        CartePArgent PayezHopital = new CartePArgent(100,18, "Payez l'hôpital : 100€.", this);
        CarteGArgent Herite = new CarteGArgent(100,28, "Vous héritez : 100€.", this);
        CartePrison AllerPrison = new CartePrison(21,"Allez en prison. Avancez tout droit en prison. Ne passez pas par la case Départ. Ne recevez pas 200€.", this);
        CartePArgent PayezPolice = new CartePArgent(50,19, "Payez la Police d'Assurance : 50€.", this);
        CarteGArgent VenteStock = new CarteGArgent(50,29, "La vente de votre stock vous rapporte : 50€.", this);
        CarteDeplace CaseDep = new CarteDeplace(10,"Avancez jusqu'à la case Départ.", this,1);
        CarteGArgent RecevezInteret = new CarteGArgent(25,30, "Recevez votre intérêt sur l'emprunt à 7% : 25€", this);
        CarteGArgent RecevezRevenu = new CarteGArgent(100,31, "Recevez votre revenu annuel : 100€.", this);
        CarteGArgent GagneBeaute = new CarteGArgent(10,32, "Vous avez gagné le deuxième prix de beauté : recevez 10€.", this);

        Communaute.add(BreakFree);
        Communaute.add(Amende);
        Communaute.add(Anniversaire);
        Communaute.add(ErreurBanq);
        Communaute.add(AllerBelleville);
        Communaute.add(NoteMedecin);
        Communaute.add(ContribuRembourse);
        Communaute.add(PayezHopital);
        Communaute.add(Herite);
        Communaute.add(AllerPrison);
        Communaute.add(PayezPolice);
        Communaute.add(VenteStock);
        Communaute.add(CaseDep);
        Communaute.add(RecevezInteret);
        Communaute.add(RecevezRevenu);
        Communaute.add(GagneBeaute);

    }
    

    public void LancerDésEtAvancer(Joueur j) {
        inter = new Interface();

        System.out.println("");
        int des1 = 0;
        int des2 = 0;
        int nbDouble = 0;

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
        

        inter.infoJoueur2(j, carreauCourant);
        System.out.println("");

        if (des2 == des1) {
            j.setDouble(j.getDouble() + 1);
            nbDouble = nbDouble + 1;

            System.out.println("Le joueur " + j.getNomJoueur() + " a fait " + nbDouble + " double");
            j.setVerif(true);

            if (j.getDouble() == 3) {
                j.setDouble(0);
                Carreau carreauPrison = lescarreaux.get(11);
                j.setPositionCourante(carreauPrison);

                System.out.println("Le joueur " + j.getNomJoueur() + " à fait 3 double à la suite ce qui l'amene sur la case " + lescarreaux.get(11).getNomCarreau());
                j.setVerif(false);

            }

        } else {
            j.setVerif(false);
        }
    }

    public void JouerUnCoup(Joueur j) {
        boolean test = true;
        while (test) {
            
            

            LancerDésEtAvancer(j);

            Carreau c = j.getCarreau(); // pour avoir le carreau actuel

            if ((c.getNumcarreauCourant() == 6) || (c.getNumcarreauCourant() == 16) || (c.getNumcarreauCourant() == 26) || (c.getNumcarreauCourant() == 36)) {

                c.action(j);  //gare

            } else if ((c.getNumcarreauCourant() == 13) || (c.getNumcarreauCourant() == 29)) {

                c.action(j);//companie

            } else if ((c.getNumcarreauCourant() == 1) || (c.getNumcarreauCourant() == 5) || (c.getNumcarreauCourant() == 11) || (c.getNumcarreauCourant() == 21) || (c.getNumcarreauCourant() == 39)) {
                //case argent
            } else if ((c.getNumcarreauCourant() == 3) || (c.getNumcarreauCourant() == 8) || (c.getNumcarreauCourant() == 18) || (c.getNumcarreauCourant() == 23) || (c.getNumcarreauCourant() == 34) || (c.getNumcarreauCourant() == 37)) {
                //case tirage
            } else if ((c.getNumcarreauCourant() == 31)) {
                //case mouvement
                c.action(j);
            } else {
                c.action(j); //case propriete
            }
            test = j.isVerif();
        }

    }
    
    public void InitialiserPartie(){
     
        Carreau carreauInit = lescarreaux.get(1);
        int nbJoueur;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Combien de joueur ? (entre 2 et 6): ");
        
        nbJoueur = Integer.parseInt(sc1.nextLine());
               
        for (int i = 1; i <= nbJoueur; i++) {
            
            System.out.println("Entrer le nom du joueur " + i + " :");
            
            Joueur j = new Joueur(sc1.nextLine(), this, carreauInit);
            int de1 = j.resultatDés();
            int de2 = j.resultatDés();
            int des = de1+de2;
            ordre.put(j,des);
            }

        TreeMap<Joueur,Integer> sorted = new TreeMap<>();
                sorted=SortByValue(ordre);
        int i = 1;
        for(Map.Entry<Joueur,Integer> entry : sorted.entrySet()) {
            
            Joueur key = entry.getKey();
            Integer value = entry.getValue();
            inter.InfoDebPartie(key, value, i);
            i++;
            
        }
    }
    
    public static TreeMap<Joueur,Integer> SortByValue (HashMap<Joueur,Integer> map){
        ValueComparator vc = new ValueComparator(map);
        TreeMap<Joueur,Integer> sorted= new TreeMap<Joueur,Integer>(vc);
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
            ProprieteAConstruire carreauProprieteAConstruire;
            Carreau carreauAConstruire;
            ArrayList<Integer> loyer;
            ArrayList<ProprieteAConstruire> pro;
            ArrayList<String[]> data = readDataFile(dataFilename, ",");

            //TODO: create cases instead of displaying
            loyer = new ArrayList<>();
            pro = new ArrayList<>();
            
            groupe = new ArrayList<>();
            this.CréerGroupe();
            
            for (int i = 0; i < data.size(); ++i) {
                String caseType = data.get(i)[0];
                if (caseType.compareTo("P") == 0) {
                    System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1] + " groupe " + data.get(i)[3]);

                    for (int j = 5; 10 >= j; j++) {
                        loyer.add(Integer.parseInt(data.get(i)[j]));
                    }

                    //Groupe(int _prixAchatMaison, CouleurPropriete _couleur)
                    //ProprieteAConstruire(ArrayList<Integer> _loyerMaison, Groupe _groupePropriete, int _loyerBase, int _prixAchat, int _numero, String _nomCarreau)
                   carreauProprieteAConstruire = new ProprieteAConstruire(loyer, Integer.parseInt(data.get(i)[5]), Integer.parseInt(data.get(i)[4]), Integer.parseInt(data.get(i)[1]), data.get(i)[2], this);
                   
                    for (Groupe g : groupe) {
                        
                        CouleurPropriete c = g.getCouleur();
                        
                        
                        if (data.get(i)[3].equals(c.toString())) {
                            g.addPropriete(carreauProprieteAConstruire);
                            carreauProprieteAConstruire.setGroupePropriete(g);
                                
                        }
                    }

                    lescarreaux.put(Integer.parseInt(data.get(i)[1]), carreauProprieteAConstruire);

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
    public boolean partiefinie(){
        int i;
        ArrayList<Joueur> joueurs=new ArrayList();
        joueurs=this.getJoueurs();
        
        if(joueurs.size()==1){
            return true;
        }
        return false;
    }
    public void faillite(Joueur j){
         if (j.getCash()<=0){
                ArrayList<ProprieteAConstruire> mesPropri= new ArrayList();
                mesPropri=j.getLesPropio();
                
                for (ProprieteAConstruire pac: mesPropri){
                    int num=pac.getNumcarreauCourant();
                    
                    this.setNbMaisons(pac.getNbMaisons()+nbMaisons);
                    this.setNbHotels(pac.getNbMaisons()+nbHotels);
                    lescarreaux.put(num, pac);
                }
             
                this.removeJoueur(j);
            }
    }

}
