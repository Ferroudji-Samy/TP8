package iia.espacesEtats.algorithmes;
/*
 * AEtoile.java
 */

import java.util.ArrayList;

import iia.espacesEtats.graphes.Noeud;
import iia.espacesEtats.modeles.Heuristique;
import iia.espacesEtats.modeles.Probleme;
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

    /* Lance l'exploration sur un problème */
    public Solution chercheSolution(Probleme p) {
        Solution sol = null;
        /* TODO  A compléter/modifier */
        ArrayList<Noeud> dejaDev= new ArrayList<Noeud>();
        ArrayList<Noeud> frontiere= new ArrayList<Noeud>();
        frontiere.add(sinit);
        /**
         * g(sinit)=0;
         * f(sinit)=h(sinit)
         */
        while(!frontiere.isEmpty()) {
        	Noeud n=choixFmin(frontiere);
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
