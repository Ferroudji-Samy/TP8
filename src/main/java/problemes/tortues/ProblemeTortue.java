package problemes.tortues;

import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Probleme;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Modélisation du problème des tortues
 * 
 * @author Philippe Chatalic
 */
public class ProblemeTortue extends Probleme {

    // Constructeurs -------------------------------------------------------
    public ProblemeTortue(Etat eInit) {
        super(eInit, "Pb des Tortues");
        if (!(eInit instanceof EtatTortue)) {
            try {
                throw new Exception("Un ProblemeTortue se construit avec un EtatTortue !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Creation d'un probleme " + getNom());
        System.out.println("etat initial : " + eInit.toString());
    }

    // Constructeurs -------------------------------------------------------
	/* *** Méthodes abstraites de la classe Probleme  à instancier *** */
    public boolean isTerminal(Etat e) {
        if (!(e instanceof EtatTortue)) {
            return false;
        }
        EtatTortue et = (EtatTortue) e;
        for (int i = 0; i < EtatTortue.NOMBRE_DE_TORTUES; i++) {
            try {
                if (et.getTortue(i) == false) {
                    return false;
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return true;
    }

    public Collection<Etat> successeurs(Etat e) {
        LinkedList<Etat> toRet = new LinkedList<Etat>();
        if ((e instanceof EtatTortue) && (!this.isTerminal(e))) {
            EtatTortue et = (EtatTortue) e;
            EtatTortue newEt = null;
            for (int i = 0; i < EtatTortue.NOMBRE_DE_TORTUES - 1; i++) {
                try {
                    et.inverseTortue(i);
                    newEt = new EtatTortue(et);
                    et.inverseTortue(i);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                toRet.add(newEt);
            }
        }
        return toRet;
    }

    /* ********** Constructeurs ************* */
    public static void main(String[] args) {
        EtatTortue et1 = new EtatTortue();
        System.out.println("la tortue et1 : " + et1);
        ProblemeTortue pb = new ProblemeTortue(et1);
        System.out.println(pb.successeurs(et1));
    }
}
