package Data;

import static Data.CouleurPropriete.*;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
	private final int nbMaisons = 0;
	private ArrayList<Integer> lesloyerMaison;
        private Groupe groupePropriete;
        //bleuFonce, orange, mauve, violet, bleuCiel, jaune, vert, rouge

    public ProprieteAConstruire(ArrayList<Integer> lesloyerMaison, int loyerBase, int prixAchat, int numero, String nomCarreau, Monopoly monop) {
        super(loyerBase, prixAchat, numero, nomCarreau, monop);
        this.lesloyerMaison = lesloyerMaison;

    }

    public String getConstruction() {

        if (nbMaisons == 5) {
            return "1 hotel";
        } else if (nbMaisons == 1) {
            return "1 maison";
        } else if (nbMaisons == 0) {
            return "0 maison";
        }

        return (String.valueOf(nbMaisons) + " maisons");

    }

    public CouleurPropriete getcouleurProp() {
        return groupePropriete.getCouleur();
    }

    public String getNomMaison() {
        return super.getNomC();
    }

    public void calculLoyerPAC(CouleurPropriete aCoul, int aNbc) {
        //regarder les  couleurs;
    }

    public void debutConstruction(Joueur j) {
        if (this.getNbMaisons() <= 4) {
            this.setNbMaisons(nbMaisons + 1);
            j.setCash(j.getCash() - this.getGroupe().getPrixAchatMaison());
            super.getMonopoly().setNbMaisons(super.getMonopoly().getNbMaisons() - 1);
        } else {
            this.setNbMaisons(nbMaisons + 1);
            j.setCash(j.getCash() - this.getGroupe().getPrixAchatMaison());
            super.getMonopoly().setNbHotels(super.getMonopoly().getNbHotels() - 1);
        }
        super.getMonopoly().setNbMaisons(super.getMonopoly().getNbMaisons() + 4);

    }

    public Groupe getGroupe() {
        return groupePropriete;
    }

    public String getCouleurGroupe() {
        return groupePropriete.getCouleur().name();

    }

    public int calculLoyerPAC(CouleurPropriete Coul, int Nbc, Joueur j) {
        if (Coul == CouleurPropriete.valueOf("bleuFonce")) {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 35 * 2;
                } else {
                    return 50 * 2;
                }
            } else if ((Nbc == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 35;
                } else {
                    return 50;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 175;
                } else {
                    return 200;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 500;
                } else {
                    return 600;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 1100;
                } else {
                    return 1400;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 1300;
                } else {
                    return 1700;
                }
            } else {
                if (super.getNomC().equals("Av. des Champs-Elysées")) {
                    return 1500;
                } else {
                    return 2000;
                }
            }

        } else if (Coul == CouleurPropriete.valueOf("orange")) {
            if ((j.getNbPropriCouleur(Coul) == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 16 * 2;
                } else {
                    return 14 * 2;
                }
            } else if ((Nbc == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 16;
                } else {
                    return 14;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 80;
                } else {
                    return 70;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 220;
                } else {
                    return 200;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 600;
                } else {
                    return 550;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 800;
                } else {
                    return 750;
                }
            } else {
                if (super.getNomC().equals("Place Pigalle")) {
                    return 1000;
                } else {
                    return 950;
                }
            }

        } else if (Coul == CouleurPropriete.valueOf("mauve")) {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 4 * 2;
                } else {
                    return 2 * 2;
                }
            } else if ((j.getNbPropriCouleur(Coul) == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 4;
                } else {
                    return 2;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 20;
                } else {
                    return 10;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 60;
                } else {
                    return 30;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 180;
                } else {
                    return 90;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 320;
                } else {
                    return 160;
                }
            } else {
                if (super.getNomC().equals("Rue Lecourbe")) {
                    return 450;
                } else {
                    return 250;
                }
            }

        } else if (Coul == CouleurPropriete.valueOf("violet")) {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 12 * 2;
                } else {
                    return 10 * 2;
                }
            } else if ((Nbc == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 12;
                } else {
                    return 10;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 60;
                } else {
                    return 50;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 180;
                } else {
                    return 150;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 500;
                } else {
                    return 450;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 625;
                } else {
                    return 160;
                }
            } else {
                if (super.getNomC().equals("Rue de Paradis")) {
                    return 750;
                } else {
                    return 250;
                }
            }

        } else if (Coul == CouleurPropriete.valueOf("bleuCiel")) {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Av. de la République")) {
                    return 8 * 2;
                } else {
                    return 6 * 2;
                }
            } else if ((Nbc == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Av. de la République")) {
                    return 8;
                } else {
                    return 6;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Av. de la République")) {
                    return 40;
                } else {
                    return 30;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Av. de la République")) {
                    return 100;
                } else {
                    return 90;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Av. de la République")) {
                    return 300;
                } else {
                    return 270;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Av. de la République")) {
                    return 450;
                } else {
                    return 400;
                }
            } else {
                if (super.getNomC().equals("Av. de la République")) {
                    return 600;
                } else {
                    return 550;
                }
            }

        } else if (Coul == CouleurPropriete.valueOf("jaune")) {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 24 * 2;
                } else {
                    return 22 * 2;
                }
            } else if ((Nbc == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 24;
                } else {
                    return 22;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 120;
                } else {
                    return 330;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 360;
                } else {
                    return 800;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 850;
                } else {
                    return 800;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 1025;
                } else {
                    return 975;
                }
            } else {
                if (super.getNomC().equals("Rue La Fayette")) {
                    return 1200;
                } else {
                    return 1150;
                }
            }
        } else if (Coul == CouleurPropriete.valueOf("vert")) {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 28 * 2;
                } else {
                    return 26 * 2;
                }
            } else if ((j.getNbPropriCouleur(Coul) == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 28;
                } else {
                    return 26;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 150;
                } else {
                    return 130;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 450;
                } else {
                    return 390;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 1000;
                } else {
                    return 900;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 1200;
                } else {
                    return 1100;
                }
            } else {
                if (super.getNomC().equals("Bd des Capucines")) {
                    return 1400;
                } else {
                    return 1275;
                }
            }
        } else {
            if ((Nbc == 2) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 20 * 2;
                } else {
                    return 18 * 2;
                }
            } else if ((Nbc == 1) && (this.getNbMaisons() == 0)) {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 20;
                } else {
                    return 18;
                }
            } else if (this.getNbMaisons() == 1) {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 100;
                } else {
                    return 90;
                }
            } else if (this.getNbMaisons() == 2) {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 300;
                } else {
                    return 250;
                }
            } else if (this.getNbMaisons() == 3) {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 750;
                } else {
                    return 700;
                }
            } else if (this.getNbMaisons() == 4) {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 925;
                } else {
                    return 875;
                }
            } else {
                if (super.getNomC().equals("Av. Henri-Martin")) {
                    return 1100;
                } else {
                    return 1050;
                }

            }
        }
    }

    public Joueur getPropriétaire() {
        return super.getProprietaire();
    }

    public Monopoly getMonopoly() {
        return super.getMonopoly();
    }

    @Override
    public void calculLoyer(Joueur j) {

        Joueur jproprio = super.getProprietaire();

        CouleurPropriete coul = getGroupe().getCouleur();

        int nbc = jproprio.getNbPropriCouleur(coul);

        int l = calculLoyerPAC(coul, nbc, jproprio);

    }

    @Override
    public void action(Joueur j) {
        Joueur jProprio = this.getProprietaire();

        if (jProprio == null) {
            this.achatPropriete(j);
        } else if (jProprio == j) {
            System.out.println("Vous etes les propriétaires, vous n'avez rien à payer");
            this.construire(j);
        } else {
            this.calculLoyer(j);

            int loyerPro = jProprio.getLoyer();

            jProprio.recevoirLoyer(loyerPro);
            j.PayerLoyer(loyerPro);

            Monopoly m = super.getMonopoly();

            m.InfosLoyerPro(jProprio, loyerPro);   //info propri
            m.InfosLoyerJoueur(j, loyerPro);  //info joueur

        }
    }

    @Override
    public void achatPropriete(Joueur j) {
        int prixA = this.getPrixAchat();  //pour avoir le prix du carreau               

        int cashJ = j.getCash();

        if (cashJ >= prixA) {

            Monopoly m = this.getMonopoly();  // Pour obtenir le monop

            m.ProcedureAchat(j, this);  //envoi un message
            
            boolean confirmer = false;
            confirmer = m.AchatProp();

            if (confirmer == true) {
                super.setProprio(j);
                j.setCash(cashJ - prixA);
                j.addProprietes(this);

                System.out.println("Tu as acheté la propriete");
                System.out.println("Il vous reste " + j.getCash() +'€');

                System.out.println("");
            }

        } else {
            System.out.println("Le joueur " + j.getNomJoueur() + " ne peut pas acheter la case " + super.getNomC());
        }

    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public ArrayList<Integer> getLesloyerMaison() {
        return lesloyerMaison;
    }

    public Groupe getGroupePropriete() {
        return groupePropriete;
    }

    public void construire(Joueur j) {
        Groupe gr;
        int c;

        ArrayList<ProprieteAConstruire> possibleConstruction;

        gr = this.getGroupe();
        possibleConstruction = VerifConstruction(j, gr);

        while (!possibleConstruction.isEmpty()) {
            super.getMonopoly().ProcedureConstruire(j, possibleConstruction);

            possibleConstruction = VerifConstruction(j, gr);
        }
        super.getMonopoly().getInter().InfoPasConstruire(j);

    }

    public ArrayList<ProprieteAConstruire> VerifConstruction(Joueur j, Groupe gr) {
        int prixMaison;
        int NbMaisons;
        int c;
        boolean possedeGr;

        NbMaisons = super.getMonopoly().getNbMaisons();
        possedeGr = j.PossedeGroupe(gr);
        c = j.getCash();
        prixMaison = gr.getPrixAchatMaison();
        ArrayList<ProprieteAConstruire> terrain = new ArrayList();

        if (NbMaisons != 0 && possedeGr && c >= prixMaison) {
            terrain = TerrainConstructible(gr);
        }
        return terrain;
    }

    public ArrayList<ProprieteAConstruire> TerrainConstructible(Groupe gr) {
        ArrayList<ProprieteAConstruire> terrainGr = new ArrayList();
        ArrayList<ProprieteAConstruire> terrainConstruc = new ArrayList();
        ProprieteAConstruire pac1;
        ProprieteAConstruire pac2;
        ProprieteAConstruire pac3;

        terrainGr = gr.getLesproprietes();

        pac1 = terrainGr.get(0);
        pac2 = terrainGr.get(1);
        int n1 = pac1.getNbMaisons();
        int n2 = pac2.getNbMaisons();

        if (terrainGr.get(2) != null) {
            pac3 = terrainGr.get(2);
            int n3 = pac3.getNbMaisons();

            if (n1 == n2 && n2 == n3 && n1 < 5) {
                terrainConstruc.add(pac1);
                terrainConstruc.add(pac2);
                terrainConstruc.add(pac3);
            }

            if (n1 == n2 - 1 && n1 == n3 && n1 < 5) {
                terrainConstruc.add(pac1);
                terrainConstruc.add(pac3);
            }
            if (n1 == n2 + 1 && n1 == n3 && n1 <= 5) {
                terrainConstruc.add(pac2);
            }
            if (n1 - 1 == n2 && n2 == n3 && n2 < 5) {
                terrainConstruc.add(pac2);
                terrainConstruc.add(pac3);
            }
            if (n1 + 1 == n2 && n2 == n3 && n2 <= 5) {
                terrainConstruc.add(pac1);
            }
            if (n1 == n3 - 1 && n1 == n2 && n1 < 5) {
                terrainConstruc.add(pac1);
                terrainConstruc.add(pac2);
            }
            if (n1 == n3 + 1 && n1 == n2 && n1 <= 5) {
                terrainConstruc.add(pac3);
            }

            if (n1 == n2 && n2 == n3 && n1 == 5) {
                return null;
            }

            return terrainConstruc;

        }

        if (n1 == n2 && n1 < 5) {
            terrainConstruc.add(pac1);
            terrainConstruc.add(pac2);
        }
        if (n1 == n2 - 1 && n1 < 5) {
            terrainConstruc.add(pac1);
        }
        if (n1 == n2 + 1 && n1 <= 5) {
            terrainConstruc.add(pac2);
        }
        if (n1 - 1 == n2 && n1 <= 5) {
            terrainConstruc.add(pac2);
        }
        if (n1 + 1 == n2 && n1 < 5) {
            terrainConstruc.add(pac1);
        }
        if (n1 == n2 && n1 == 5) {
            return null;
        }
        return terrainConstruc;
    }

}

