package knighttour;

public class KnightTour extends Size{

	private int[][] solutionMatrix;
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public KnightTour() {
		this.solutionMatrix = new int[super.getSize()][super.getSize()];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < super.getSize(); ++i)
			for (int y = 0; y < super.getSize(); ++y)
				this.solutionMatrix[i][y] = Integer.MIN_VALUE;
	}

	public void solveKnightTour() {

		this.solutionMatrix[0][0] = 0;

		if ( !solveProblem(1, 0, 0) ) {
			System.out.println("No solution found...");
			return;
		}
		 
		showSolution();	
	}

	public boolean solveProblem(int stepCount, int x, int y) {

		if (stepCount == super.getSize() * super.getSize()) {
			return true;
		}

		for (int i = 0; i < super.getSize(); ++i) {

			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];

			if ( isValidMove(nextX, nextY) ) {

				this.solutionMatrix[nextX][nextY] = stepCount;

				if ( solveProblem(stepCount + 1, nextX, nextY) ) {
					return true; 
				}

				this.solutionMatrix[nextX][nextY] = Integer.MIN_VALUE; // remove from solutions --> backtracking
			}
		}

		return false;
	}

	public boolean isValidMove(int x, int y) {

		if (x < 0 || x >= super.getSize()) return false;
		if (y < 0 || y >= super.getSize()) return false;
		if (this.solutionMatrix[x][y] != Integer.MIN_VALUE) return false;

		return true;
	}

	public void showSolution() {
		for (int i = 0; i < super.getSize(); ++i) {
			for (int j = 0; j < super.getSize(); ++j) {
				System.out.print(this.solutionMatrix[i][j] + " ");
			}

			System.out.println();
		}
	}
}