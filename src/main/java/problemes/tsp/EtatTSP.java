package problemes.tsp;

import java.util.*;

import iia.espacesEtats.modeles.Etat;

/**
 * @author chatalic
 * @version 2010
 * Implemente la classe Etat pour le voyageur de commerce en Roumanie
 * L'etat est caracterise par : 
 * 		- la liste de ville qui reste à  parcourir
 * 		- la ville ou l'on est. 
 * 
 * */
public class EtatTSP implements Etat {

    // Les données de la carte
    public final static CarteRoutiereRoumanie CARTE = new CarteRoutiereRoumanie();

    // Attributs
    private LinkedList<String> aParcourir;
    private String villeCourante;

    // Constructeurs
    public EtatTSP(LinkedList<String> list, String ville) {
        this.aParcourir = new LinkedList<String>(list);
        this.villeCourante = ville;
    }

    // Accesseurs
    public LinkedList<String> getaParcourir() {
        return aParcourir;
    }

    public String getVilleCourante() {
        return villeCourante;
    }

    // Autres methodes

    /* Peut-on aller de villeCourante a ville */
    public boolean allerA(String ville) {
        if (CARTE.connexion(villeCourante, ville) != -1) {
            return true;
        }
        return false;
    }

    float cout(Etat e) {
        if (e instanceof EtatTSP) {
            return CARTE.connexion(this.villeCourante, ((EtatTSP) e).villeCourante);
        }
        return Float.MAX_VALUE;
    }


    public String toString() {
        return "Ici : " + villeCourante + " / Parcours : " + aParcourir;
    }




    public boolean equals(Object obj) {
        if (!(obj instanceof EtatTSP)) {
            return false;
        }
        EtatTSP et = (EtatTSP) obj;
        if (this.getaParcourir().size() != et.getaParcourir().size()) {
            return false;
        }
        for (String ville : this.getaParcourir()) {
            if (!et.getaParcourir().contains(ville)) {
                return false;
            }
        }
        if (!this.villeCourante.equals(et.villeCourante)) {
            return false;
        }
        return true;
    }

}
