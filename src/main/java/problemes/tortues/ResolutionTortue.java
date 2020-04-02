package problemes.tortues;

import iia.espacesEtats.algorithmes.*;
import iia.espacesEtats.modeles.*;

/**
 * Exemple de résolution de problème
 */
public class ResolutionTortue {

	public static void main(String[] args) {
		/* Définition d'un problème : choix de l'état initial
		 * et construction du problème*/
		Etat initial = new EtatTortue();
		Probleme pb = new ProblemeTortue(initial);
		/* Choix de l'algorithe de résolution*/
		//AlgorithmeRechercheEE algo = new RechercheEnLargeur();
		AlgorithmeRechercheEE algo = new RechercheEnProfondeurdDetectionDeCycles();
		/* La solution, si elle est trouvé est retournée sous forme d'une
		 *  liste de noeuds allant de l'état initial à l'état final
		 */
		Solution sol = algo.chercheSolution(pb);
		if (sol != null) {
			System.out.println("Solution trouvée : ");
			sol.affiche();
		}

		else
			System.out.println("Echec !");
	}
}
