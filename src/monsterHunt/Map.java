package monsterHunt;

//import java.io.File;
import java.util.ArrayList;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Represents a game board using Graph connected vertices.
 * 
 * @author Brian Munro + John Platt
 *
 */
public class Map {

	Graph mapGraph;
	ArrayList<Integer> water;
	BreadthFirstPaths[] paths;
	
	/**
	 * Constructor initializes the Map.
	 * 
	 * @param file .txt file formatted for Graphs.
	 */
	public Map(In file) {
		//In in = new In(file);
		mapGraph = new Graph(file);
		water = new ArrayList<Integer>();
		findWater(mapGraph, water);
		paths = findPaths(mapGraph);
	}
	
	/**
	 * locates vertices with no edges for water spaces that can't be traveled to.
	 * @param G
	 * @param list
	 */
	private void findWater (Graph G, ArrayList<Integer> list) {
			for (int i = 0; i < G.V(); i++) {
			if (G.degree(i) == 0) list.add(i);
		}		
	}
	
	/**
	 * Finds shortest path to each vertex from each source vertex.
	 * @param G
	 * @return
	 */
	private BreadthFirstPaths[] findPaths(Graph G) {
		BreadthFirstPaths[] temp = new BreadthFirstPaths[G.V()];
		for (int i = 0; i < G.V(); i++) {
			temp[i] = new BreadthFirstPaths(G, i);
		}
		return temp;
	}
	
}
