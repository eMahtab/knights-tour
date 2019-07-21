package net.mahtabalam.tour1;

class KnightTour {
    private int BOARD_SIZE;
	private int[][] visited;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	public KnightTour(int chessBoardSize) {
		this.BOARD_SIZE = chessBoardSize;
		this.visited = new int[BOARD_SIZE][BOARD_SIZE];
		this.initializeBoard();
	}
	
	private void initializeBoard() {
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++)
				this.visited[i][j] = Integer.MIN_VALUE;
	}

	public void solveKnightTourProblem() {	
		visited[0][0] = 0;
		// start knight's tour from top left corner square (0, 0)
		if( solveProblem(1, 0, 0)) {
			printSolution();
		} else {
			System.out.println("No feasible solution found...");
		}			
	}

	public boolean solveProblem(int moveCount, int x, int y) {
		// Base Case : We were able to move to each square exactly once
		if (moveCount == BOARD_SIZE * BOARD_SIZE) {
			return true;
		}

		for (int i = 0; i < xMoves.length; ++i) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			// check if new position is a valid and not visited yet
			if ( isValidMove(nextX, nextY) && visited[nextX][nextY] == Integer.MIN_VALUE) {

				visited[nextX][nextY] = moveCount;
				if ( solveProblem(moveCount + 1, nextX, nextY) ) {
					return true; 
				}
				
                // BACKTRACK !!! 
				visited[nextX][nextY] = Integer.MIN_VALUE;
			}
		}
	  return false;
	}

	public boolean isValidMove(int x, int y) {
		if (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE) {
			return false;
		} else {
			return true;	
		}
	}
	
	public void printSolution() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
}
