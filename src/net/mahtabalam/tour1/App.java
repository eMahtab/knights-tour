package net.mahtabalam.tour1;

public class App {

	public static void main(String[] args) {
		final int  chess_board_size = 5;
		KnightTour knightTour = new KnightTour(chess_board_size);
		knightTour.solveKnightTourProblem();	
	}
}
