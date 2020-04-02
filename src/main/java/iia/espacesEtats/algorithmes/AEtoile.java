package iia.espacesEtats.algorithmes;
/*
 * AEtoile.java
 */

import java.util.ArrayList;

import iia.espacesEtats.graphes.NoeudGF;
import iia.espacesEtats.modeles.Heuristique;
import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.ProblemeACout;
import iia.espacesEtats.modeles.Solution;

/**
 * La classe qui implémente l'algo A*
 * 
 * A completer !
 */
public class AEtoile implements AlgorithmeHeuristiqueRechercheEE {

    private Heuristique h;
    private int noeudsDeveloppe = 0;


    /* Constructeur de base */
    public AEtoile(Heuristique h) {
        this.h = h;
    }
    
    private NoeudGF choixFmin(ArrayList<NoeudGF> frontiere) {
    	NoeudGF min=null;
    	if(frontiere.size()>0)min=frontiere.get(0);
    	
    	for(int i=1;i<frontiere.size()-1;i++) {
    		if(f(min)>f(frontiere.get(i)))min=frontiere.get(i);
    	}
    	return min;
    }

    /* Lance l'exploration sur un problème */
    public Solution chercheSolution(Probleme p) {
        Solution sol = null;
        /* TODO  A compléter/modifier */
        ProblemeACout pcout = (ProblemeACout) p;
        ArrayList<NoeudGF> dejaDev= new ArrayList<NoeudGF>();
        ArrayList<NoeudGF> frontiere= new ArrayList<NoeudGF>();
        frontiere.add(sinit);
        /**
         * g(sinit)=0;
         * f(sinit)=h(sinit)
         */
        while(!frontiere.isEmpty()) {
        	NoeudGF n=choixFmin(frontiere);
        	if(estTerminal(n)) {
        		sol=construireSolution(n,Pere);
        	}
        	else {
        		frontiere.remove(n);
        		dejaDev.add(n);
        		for(Noeud s : successeurs(n)) {
        			if(!dejaDev.contains(s)&&!frontiere.contains(s)) {
        			/**	Pere(s)=n
        				g(s)=g(n)+cout(n,s);
        				f(s)=g(s)+h(s);
        			**/	frontiere.add(s);
        			}
        			else {
        				if(g(s)>g(n)+cout(n,s)) {
        					Pere(s)=n;
        					g(s)=g(n)+cout(n,s);
        					f(s)=g(s)+h(s);
        				}
        			}
        		}
        	}
        }
        return sol;
    }

    public void setHeuristique(Heuristique h) {
        this.h = h;
    }

    public Heuristique getHeuristique() {
        return h;
    }
}
