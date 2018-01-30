package Search;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GreedyPlayer implements BasePlayer {

	// ==========================================================
	// Private Members
	// ==========================================================
	private int Color = 0;
	
	// ==========================================================
	// Constructor
	// ==========================================================
	public GreedyPlayer() {
		System.out.println("Created Greedy Player");
	}
	
	// ==========================================================
	// Base Player Methods
	// ==========================================================
		
	
	@Override
	public void initialize(int myColor) {
		Color = myColor;

	}

	@Override
	public int getColor() {
		return Color;
	}

	@Override
	public Coordinates nextMove(GameBoard gb, ArrayList<Coordinates> possibleMoves) {
		// return null if no move is available
		if (possibleMoves.isEmpty()) return null; 
		
		// implement the greedy move
		Coordinates greedyMove = null;
		int maxStones = 0;
		
		for(Coordinates move : possibleMoves) {
			
			GameBoard copy = gb.clone();
			copy.makeMove(Color, move);
			
			if (maxStones < copy.countStones(Color)) {
				maxStones = copy.countStones(Color);
				greedyMove = move;
			}
			
		}
		
		return greedyMove;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
