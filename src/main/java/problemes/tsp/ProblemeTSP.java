package problemes.tsp;

import java.util.LinkedList;

import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.ProblemeACout;

public class ProblemeTSP extends ProblemeACout {

    public ProblemeTSP(Etat eInit, String nom) {
        super(eInit, nom);
    }

    public boolean isTerminal(Etat e) {
        if (e instanceof EtatTSP) {
            EtatTSP et = (EtatTSP) e;
            return (et.getaParcourir().size() == 0 &&
                    et.getVilleCourante().equals(((EtatTSP) super.getEtatInitial()).getVilleCourante()));
        }
        return false;
    }

    public LinkedList<Etat> successeurs(Etat e) {
        LinkedList<Etat> toRet = new LinkedList<Etat>();
        if ((e instanceof EtatTSP) && (!this.isTerminal(e))) {
            EtatTSP et = (EtatTSP) e;
            for (String ville : et.getaParcourir()) {
                if (et.allerA(ville)) {
                    LinkedList<String> newList = new LinkedList<String>(et.getaParcourir());
                    newList.remove(ville);
                    toRet.add(new EtatTSP(newList, ville));
                }
            }
        }
        return toRet;
    }

    public float cout(Etat e1, Etat e2) {
        return ((EtatTSP) e1).cout(e2);
    }
}
