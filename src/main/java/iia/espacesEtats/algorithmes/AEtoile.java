package iia.espacesEtats.algorithmes;
/*
 * AEtoile.java
 */

import java.util.ArrayList;
import java.util.LinkedList;

import iia.espacesEtats.graphes.Noeud;
import iia.espacesEtats.graphes.NoeudGF;
import iia.espacesEtats.modeles.Etat;
import iia.espacesEtats.modeles.Heuristique;
import iia.espacesEtats.modeles.Probleme;
import iia.espacesEtats.modeles.ProblemeACout;
import iia.espacesEtats.modeles.Solution;
import problemes.tsp.EtatTSP;
import problemes.tsp.ProblemeTSP;

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
    
    private NoeudGF choixFmin(LinkedList<NoeudGF> frontiere) {
    	NoeudGF min=null;
    	if(frontiere.size()>0)min=frontiere.get(0);
    	
    	for(int i=1;i<frontiere.size()-1;i++) {
    		if(min.getF()>frontiere.get(i).getF())min=frontiere.get(i);
    	}
    	return min;
    }

    /* Lance l'exploration sur un problème */
    public Solution chercheSolution(Probleme p) {
        Solution sol = null;
        /* TODO  A compléter/modifier */
        ProblemeACout pcout = (ProblemeACout) p;
        LinkedList<NoeudGF> dejaDev= new LinkedList<NoeudGF>();
        LinkedList<NoeudGF> frontiere= new LinkedList<NoeudGF>();
        frontiere.add(sinit);
        /**
         * g(sinit)=0;
         * f(sinit)=h(sinit)
         */
        while(!frontiere.isEmpty()) {
        	NoeudGF n=choixFmin(frontiere);
        	if(estTerminal(n.getEtat())) {
        		sol=construireSolution(n,n.getPere());
        	}
        	else {
        		frontiere.remove(n);
        		dejaDev.add(n);
        		for(NoeudGF s : successeurs(n.getEtat())) {
        			if(!dejaDev.contains(s)&&!frontiere.contains(s)) {
        				s.setPere(n);
        				g(s)=g(n)+cout(n,s);
        				s.setF(g(s)+getHeuristique());
        				frontiere.add(s);
        			}
        			else {
        				if(g(s)>g(n)+cout(n,s)) {
        					s.setPere(n);
        					g(s)=g(n)+cout(n,s);
        					s.setF(g(s)+getHeuristique() );
        				}
        			}
        		}
        	}
        }
        return sol;
    }
    
    private Solution construireSolution(Noeud n, Noeud pere) {
		Solution sol=new Solution(n.getEtat());
		Noeud stock=pere;
		while(stock!=null) {
			sol.add(stock.getEtat());
			stock=stock.getPere();
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
