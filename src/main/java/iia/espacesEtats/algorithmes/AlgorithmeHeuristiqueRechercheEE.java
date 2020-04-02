/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iia.espacesEtats.algorithmes;

import iia.espacesEtats.modeles.Heuristique;

/**
 *
 * @author pc
 */
public interface AlgorithmeHeuristiqueRechercheEE extends AlgorithmeRechercheEE {

    public void setHeuristique(Heuristique h);
    
    public Heuristique getHeuristique();

}
