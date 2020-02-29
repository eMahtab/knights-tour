# Knight's Tour
Knight's Tour Problem


## Implementation 1 : Whether Knight's Tour is possible or not

```java
class KnightTour {
	private static final int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	public void solveKnightTourProblem(int chessboardSize) {	
		int[][] visited = new int[chessboardSize][chessboardSize];
		visited[0][0] = 1;
		// start knight's tour from top left corner square (0, 0)
		if( solveProblem(visited, 2, 0, 0)) {
			printSolution(visited);
		} else {
			System.out.println("No feasible solution found...");
		}			
	}

	public boolean solveProblem(int[][] visited, int moveCount, int x, int y) {
		// Base Case : We were able to move to each square exactly once
		if (moveCount > visited.length * visited.length) {
			return true;
		}

		for (int i = 0; i < xMoves.length; ++i) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			// check if new position is a valid and not visited yet
			if ( isValidMove(visited, nextX, nextY) && visited[nextX][nextY] == 0) {
				visited[nextX][nextY] = moveCount;
				if ( solveProblem(visited, moveCount + 1, nextX, nextY) ) {
					return true; 
				}
				visited[nextX][nextY] = 0;
			}
		}
	   return false;
	}

	public boolean isValidMove(int[][] visited, int x, int y) {
		if (x < 0 || x >= visited.length || y < 0 || y >= visited.length) {
			return false;
		} else {
			return true;	
		}
	}
	
	public void printSolution(int[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
}

```

## Implementation 2 : Print all possible Knight's Tour

```java
class KnightTour {
	private static final int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	private static int solution;
	
	public void solveKnightTourProblem(int chessboardSize) {	
		int[][] visited = new int[chessboardSize][chessboardSize];
		visited[0][0] = 1;
		// start knight's tour from top left corner square (0, 0)
		solveProblem(visited, 2, 0, 0);			
	}

	public void solveProblem(int[][] visited, int moveCount, int x, int y) {
		// Base Case : We were able to move to each square exactly once
		if (moveCount > visited.length * visited.length) {
			solution++;
			printSolution(visited);
		} else {
			for (int i = 0; i < xMoves.length; ++i) {
				int nextX = x + xMoves[i];
				int nextY = y + yMoves[i];
				// check if new position is a valid and not visited yet
				if ( isValidMove(visited, nextX, nextY) && visited[nextX][nextY] == 0) {
					visited[nextX][nextY] = moveCount;
					solveProblem(visited, moveCount + 1, nextX, nextY);
					visited[nextX][nextY] = 0;
				}
			}
		}
	}

	public boolean isValidMove(int[][] visited, int x, int y) {
		if (x < 0 || x >= visited.length || y < 0 || y >= visited.length) {
			return false;
		} else {
			return true;	
		}
	}
	
	public void printSolution(int[][] visited) {
		System.out.println("Solution " + solution);
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}

```

# References :
https://www.youtube.com/watch?v=D8KFwjohDNg
