/**
 * 
 */
package problemes.tsp;

import iia.espacesEtats.algorithmes.AEtoile;
import iia.espacesEtats.algorithmes.AlgorithmeHeuristiqueRechercheEE;
import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Heuristique;
import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.Solution;
import problemes.tsp.CarteRoutiereRoumanie.Villes;

import java.util.LinkedList;


/**
 * Main générique pour la résolution de problème.
 * @author chatalic
 */
public class ResolutionTSP {

    public static void main(String[] args) {


        /* Fonction heuristique de base : prend la route la plus courte sur
         *  la carte, et multiplie par le nombre de villes qui reste à
         *  parcourir.
         * Cette heuristique est minorante, mais peu efficace !
         *
         * Quelle critique peut-on lui faire ?
         *
         * */

        final float minDistance = EtatTSP.CARTE.distanceMinimum();

        Heuristique h1 = new Heuristique() {

            @Override
            public float eval(Etat e) {
                if (e instanceof EtatTSP) {
                    return ((EtatTSP) e).getaParcourir().size() * minDistance;
                } else {
                    throw new Error("Cette heursitique ne peut s'appliquer que sur des EtatTSP");
                }
            }
        };


        /* NB : A vous d'essayer les autres heuristiques  */
        
        Heuristique h2 = new Heuristique() {

			@Override
			public float eval(Etat e) {
				int sum = 0;
				EtatTSP eTSP = (EtatTSP) e;
				LinkedList<String> vL = EtatTSP.CARTE.getListeVilles();
				
				for(String s : eTSP.getaParcourir()) {
					int nbRoutes = 0;
					int dist = 0;
					
					for(int i=0; i<vL.size(); i++) {
						int d = EtatTSP.CARTE.connexion(vL.get(i), s);
						if(d>0) { 
							dist+=d;
							nbRoutes++;
						}
					}
					
					sum += dist/nbRoutes; 
				}
				
				return sum;
			}
        };
        
        
        Heuristique h3 = new Heuristique() {

			@Override
			public float eval(Etat e) {
				int sum = 0;
				EtatTSP eTSP = (EtatTSP) e;
				LinkedList<String> vL = EtatTSP.CARTE.getListeVilles();
				
				for(String s : eTSP.getaParcourir()) {
					int min = Integer.MAX_VALUE;
					
					for(int i=0; i<vL.size(); i++) {
						int d = EtatTSP.CARTE.connexion(vL.get(i), s);
						if(d>0) { 
							if(d<min) {
								min = d;
							}
						}
					}
					
					sum += min;
				}
				
				return sum;
			}
        	
        };



        /* Définition d'un problème : choix de l'état initial
         * et construction du problème*/
        LinkedList<String> villesAVisiter = EtatTSP.CARTE.getListeVilles();
         /* n'importe quelle ville peut être un point de départ */
        String depart = villesAVisiter.getFirst();

        System.out.println("Depart : " + depart);
        System.out.println("Parcours : " + villesAVisiter);

        Etat initial = new EtatTSP(villesAVisiter, depart);
        Probleme pb = new ProblemeTSP(initial, "Voyage en Roumanie");

        /* Choix de l'algorithe de ésolution */
        AlgorithmeHeuristiqueRechercheEE algo = new AEtoile(h1);

        /* La solution, si elle est trouvée est retournée sous forme d'une
         *  liste d'états allant de l'état initial à  l'état final
         */
        Solution sol = algo.chercheSolution(pb);
        if (sol != null) {
            System.out.println("La solution est la suite : ");
            sol.affiche();
        } else {
            System.out.println("Echec !");
        }
    }
}
