package problemes.tortues;

import iia.espacesEtats.modeles.Etat;

/**
 * Formalisation du problèmes des tortues en tant que
 * problème de recherche dans un graphe d'états.
 * 
 * @author  Philippe Chatalic
 * @author  Alexandre Allauzen
 */
public class EtatTortue implements Etat {

    // Constantes ----------------------------------------------------------
    /**
     * Nombre de tortues pour un état du problème.
     */
    public final static int NOMBRE_DE_TORTUES = 6;
    // Attributs -----------------------------------------------------------
    /**
     * Les tortues
     * Chaque tortues est représentée par un boolen
     * L'ordre des indices sur le tableau correspond
     * aux tortues considérées de gauche a droite
     */
    private boolean[] tortues;

    // Constructeurs -----------------------------------------------------------
    /**
     * Par défaut toutes les tortues sont sur le dos 
     * sauf la troisièmme et la quatrième en partant de la gauche.
     */
    public EtatTortue() {
        tortues = new boolean[NOMBRE_DE_TORTUES];
        for (int i = 0; i < NOMBRE_DE_TORTUES; i++) {
            tortues[i] = false;
        }
        tortues[1] = true;
        tortues[2] = true;
    }

    /** Constructeur a partir d'un tableau de booleens
     * (avec recopie du tableau)
     * @param _tab : un tableau de booleens
     */
    public EtatTortue(boolean[] _tab) {
        tortues = new boolean[NOMBRE_DE_TORTUES];
        System.arraycopy(_tab, 0, tortues, 0, NOMBRE_DE_TORTUES);
    }

    /** Constructeur  dupliquant à l'identique un EtatTortue
     * @param _tab : un tableau de booleens
     */
    public EtatTortue(EtatTortue et) {
        tortues = new boolean[NOMBRE_DE_TORTUES];
        System.arraycopy(et.tortues, 0, tortues, 0, NOMBRE_DE_TORTUES);
    }

   // Accesseurs -----------------------------------------------------------

    public boolean[] getTortue() {
        return tortues;
    }

    public boolean getTortue(int i) throws Exception {
        if ((i > tortues.length) || (i < 0)) {
            throw new Exception("Erreur : Pas autant de tortues");
        }
        return tortues[i];
    }

    // Modifieurs -----------------------------------------------------------
   /**
     * Modifie le statut de i-ème tortue (numérotées de O à NOMBRE_DE_TORTUES - 1)
     * @param i l'index de la tortues
     * @param p de la tortues modifée
     */
    public void setPositionTortue(int i, boolean p) throws Exception {
        if (0 <= i && i < NOMBRE_DE_TORTUES) {
            throw new Exception("Erreur : Pas autant de tortues");
        }
        tortues[i] = p;
    }

   
    /* ********** Methodes requises par l'interface Etat ************* */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EtatTortue) {
            System.out.println("-- test - equel EtatTortue --");
            EtatTortue et = (EtatTortue) obj;
            for (int i = 0; i < NOMBRE_DE_TORTUES; i++) {
                if (this.tortues[i] != et.tortues[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        String s = new String("tortue = [ ");
        for (int i = 0; i < NOMBRE_DE_TORTUES; i++) {
            if (tortues[i]) {
                s = s.concat("1 ");
            } else {
                s = s.concat("0 ");
            }
        }
        s = s.concat("]");
        return s;
    }

  
    /**
     * Inverse la tortue désignée ainsi que celle située à sa droite.
     * @param i l'indice de la tortue à inverser (implique
     * l'inversion de sa voisine de droite).
     * i est donc < (NOMBRE_DE_TORTUES-1)
     * @throws Exception
     */
    public void inverseTortue(int i) throws Exception {
        if ((i > EtatTortue.NOMBRE_DE_TORTUES - 1) || (i < 0)) {
            throw new Exception("Mauvais appel de inverseTortue");
        }
        this.tortues[i] = !this.tortues[i];
        this.tortues[i + 1] = !this.tortues[i + 1];
    }

   
}
