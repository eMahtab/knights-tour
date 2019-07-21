package net.mahtabalam.tour2;

public class App {

	public static void main(String[] args) {
		final int  chess_board_size = 6;
		KnightTour knightTour = new KnightTour(chess_board_size);
		knightTour.solveKnightTourProblem();	
	}
}
