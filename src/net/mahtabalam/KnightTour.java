package net.mahtabalam;

class KnightTour {
    private int BOARD_SIZE;
	private int[][] solutionMatrix;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public KnightTour(int chessBoardSize) {
		this.BOARD_SIZE = chessBoardSize;
		this.solutionMatrix = new int[BOARD_SIZE][BOARD_SIZE];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < BOARD_SIZE; ++i)
			for (int y = 0; y < BOARD_SIZE; ++y)
				this.solutionMatrix[i][y] = Integer.MIN_VALUE;
	}

	public void solveKnightTourProblem() {

		this.solutionMatrix[0][0] = 0;

		if ( !solveProblem(1, 0, 0) ) {
			System.out.println("No feasible solution found...");
			return;
		}
		 
		showSolution();	
	}

	public boolean solveProblem(int stepCount, int x, int y) {

		if (stepCount == BOARD_SIZE * BOARD_SIZE) {
			return true;
		}

		for (int i = 0; i < xMoves.length; ++i) {

			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			if ( isValidMove(nextX, nextY) ) {

				this.solutionMatrix[nextX][nextY] = stepCount;

				if ( solveProblem(stepCount + 1, nextX, nextY) ) {
					return true; // good solution, keep going
				}

				this.solutionMatrix[nextX][nextY] = Integer.MIN_VALUE; // remove from solutions --> backtracking
			}
		}

		return false;
	}

	public boolean isValidMove(int x, int y) {

		if (x < 0 || x >= BOARD_SIZE) return false;
		if (y < 0 || y >= BOARD_SIZE) return false;
		if (this.solutionMatrix[x][y] != Integer.MIN_VALUE) return false;

		return true;
	}

	public void showSolution() {
		for (int i = 0; i < BOARD_SIZE; ++i) {
			for (int j = 0; j < BOARD_SIZE; ++j) {
				System.out.print(this.solutionMatrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}
