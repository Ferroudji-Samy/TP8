package problemes.tsp;

import java.util.LinkedList;

public class CarteRoutiereRoumanie {
	
	/*
	 * Un exemple simple. Noeuds Develop. = 275
	 */
	public static enum Villes {Arad,Bucharest,Craiova,
		Dobreta,Fagaras,Oradea,Pitesti,Riminiscu,Sibiu};
		
	private static int[][] distance = 
	{
		{   0,  -1,  -1, 374,  -1, 146,  -1,  -1, 140 },
		{  -1,   0, 160,  -1, 211,  -1, 101,  -1,  -1 },
		{  -1, 160,   0, 120,  -1,  -1, 138, 146,  -1 },
		{ 374,  -1, 120,   0,  -1,  -1,  -1,  -1,  -1 },
		{  -1, 211,  -1,  -1,   0,  -1,  -1,  -1,  99 },
		{ 146,  -1,  -1,  -1,  -1,   0,  -1,  -1, 151 },
		{  -1, 101, 138,  -1,  -1,  -1,   0,  97,  -1 },
		{  -1,  -1, 146,  -1,  -1,  -1,  97,   0,  80 },
		{ 140,  -1,  -1,  -1,  99, 151,  -1,  80,   0 }
			
	};
	
	
	/** 
		*Ci-dessous deux autres exemples. Décommentez pour tester. 
		*
		*Exemple 1. Cela est un peu plus complique,  il y a 191596 Noeuds Develop.
		*/
	/*
	public static enum Villes {Arad,Bucharest,Craiova,Dobreta,Fagaras,Oradea,
		Pitesti,Riminiscu,Sibiu,Bals,Botosani,Braila,TirguMures,Tulcea};
	
	private static int[][] distance = 
	{
		{   0,  -1,  -1, 374,  -1, 146,  -1,  -1, 140, 5, 22, 38,  2, 70},
		{  -1,   0, 160,  -1, 211,  -1, 101,  -1,  -1, 1,  2, 40, 25, 33},
		{  -1, 160,   0, 120,  -1,  -1, 138, 146,  -1, 3,  5,  7,  9, 15},
		{ 374,  -1, 120,   0,  -1,  -1,  -1,  -1,  -1, 2,  4,  8, 16, 35},
		{  -1, 211,  -1,  -1,   0,  -1,  -1,  -1,  99, 29,100, 1, 24, 10},
		{ 146,  -1,  -1,  -1,  -1,   0,  -1,  -1, 151,  1,  5, 7,  9, 104},
		{  -1, 101, 138,  -1,  -1,  -1,   0,  97,  -1,100, 2,  57, 21, 3},
		{  -1,  -1, 146,  -1,  -1,  -1,  97,   0,  80, 52, 74, 59, 35, 1},
		{ 140,  -1,  -1,  -1,  99, 151,  -1,  80,   0, 22, 11, 41,  5, 6},
		{   5,   1,  3,    2,  29,   1, 100,  52,  22,  0,  2, 10, 20, 7},
		{  22,  2,   5,    4, 100,   5,   2,  74,  11,  2,  0, 1,   7, 8},
		{  38, 40,   7,    8,   1,   7,  57,  59,  41, 10,  1, 0,  36, 244},
		{   2, 25,   9,   16,  24,   9,  21,  35,   5, 20,  7, 36,  0, 100},
		{  70, 33,  15,   35,  10, 104,   3,   1,   6,  7,  8, 244, 100, 0}
	};	
	*/
	
	
	/** 
		*Exemple 2. Cela est un peu plus complique,  il y a 8280 Noeuds Develop.
		*
		*/
	/*
	public static enum Villes {Arad,Bucharest,Craiova,Dobreta,Fagaras,Oradea,
		Pitesti,Riminiscu,Sibiu,Bals,TirguMures,Tulcea};
				
	private static int[][] distance = 
	{	
		{   0,  -1,  -1, 374,  -1, 146,  -1,  -1, 140, 5, 22, 38},
		{  -1,   0, 160,  -1, 211,  -1, 101,  -1,  -1, 1,  2, 40},
		{  -1, 160,   0, 120,  -1,  -1, 138, 146,  -1, 3,  5,  7},
		{ 374,  -1, 120,   0,  -1,  -1,  -1,  -1,  -1, 2,  4,  8},
		{  -1, 211,  -1,  -1,   0,  -1,  -1,  -1,  99, 29,100, 1},
		{ 146,  -1,  -1,  -1,  -1,   0,  -1,  -1, 151,  1,  5, 7},
		{  -1, 101, 138,  -1,  -1,  -1,   0,  97,  -1,100, 2,  57},
		{  -1,  -1, 146,  -1,  -1,  -1,  97,   0,  80, 52, 74, 59},
		{ 140,  -1,  -1,  -1,  99, 151,  -1,  80,   0, 22, 11, 41},
		{   5,   1,  3,    2,  29,   1, 100,  52,  22,  0,  2, 10},
		{  22,  2,   5,    4, 100,   5,   2,  74,  11,  2,  0, 1},
		{  38, 40,   7,    8,   1,   7,  57,  59,  41, 10,  1, 0} 
	};*/

		
	/* Distance la plus courte entre deux villes reliees par une route */
	public int distanceMinimum(){
		return 80;
	}
	
	/* Teste si nom correspond a une ville de la carte */
	public boolean checkVille(String nom){
		try {
			 Villes.valueOf(nom);
		} catch(java.lang.IllegalArgumentException e) {
                    System.out.println("Erreur : "+ nom + " n'est pas une ville de la carte actuelle");
			return false;
		}
		//System.out.println(Villes.valueOf(nom));
		return true;
	}
	
	
	/* Renvoie un entier positif correspondant à la longueur de la route
	 * Si une route existe entre les deux villes. 
	 * Renvoie -1 sinon 
	 *  */
	public int connexion(Villes va, Villes vb){
		return distance[va.ordinal()][vb.ordinal()];
	}
	
	
	public int connexion(String sa, String sb){
		int va = Villes.valueOf(sa).ordinal();
		int vb = Villes.valueOf(sb).ordinal();
		return distance[va][vb];
	}
	
	
	/* Retourne la liste des villes de la carte */
	public LinkedList<String> getListeVilles(){
		LinkedList<String> toRet = new LinkedList<String>(); 
		for (int i=0; i< Villes.values().length; i++)
			toRet.add(Villes.values()[i].toString());
		return toRet;
	}
	
	
	/* A partir d'une ville s, retourne la route la plus courte
	   qui passe par elle.  */
	public int routeLaPlusCourte(String s){
		int va = Villes.valueOf(s).ordinal();
		int min=Integer.MAX_VALUE;
		for (int i=0; i < distance.length; i++){
			if ((distance[i][va]<min) && ((distance[i][va]>0)))
				min =distance[i][va];
			
		} 
		return min;
	}
	
	
}
