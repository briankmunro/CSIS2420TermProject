package monsterHunt;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Represents a monster object that leaves tracks as it moves around the map.
 * 
 * @author Brian Munro + John Platt
 *
 */
public class Monster {
	protected int location;
	protected Queue<Queue<Integer>> tracks; 
	protected Queue<Queue<Integer>> foundTracks; 
	
	/**
	 * Constructor for the monster object.
	 */
	public Monster() {
		this.location = StdRandom.uniform(75,100);
		this.tracks = new Queue<Queue<Integer>>();
		tracks.enqueue(initialTrack(location));
		this.foundTracks = new Queue<Queue<Integer>>();
	}	
	
	/**
	 * Randomly moves the monster location between 0-2 spaces.  Adds tracks to the queue.
	 * @param G
	 */
	public void moveMonster(Graph G){
		Queue<Integer> moves = new Queue<Integer>();
		int spaces = StdRandom.uniform(4);
		for (int i = 0; i < spaces; i++ ) {
			int[] adj = new int[G.degree(location)];
			int k = 0;
			for(int e : G.adj(location)) {
				adj[k] = e;
				k++;
			}
			int adjMove = StdRandom.uniform(adj.length);
			location = adj[adjMove];
			moves.enqueue(location);
		}
		tracks.enqueue(moves);
		while (tracks.size() > 3) tracks.dequeue();
	}
	
	// Random starting location
	private Queue<Integer> initialTrack(int location){
		Queue<Integer> temp = new Queue<Integer>();
		temp.enqueue(location);
		return temp;
	}

}