package gomoku;
/**
 *
 * @author 
 */
public class Main {

	public enum PLAYER {
		HUMAN,
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		PLAYER p1 = PLAYER.HUMAN;
		PLAYER p2 = PLAYER.HUMAN;

		System.out.printf("Welcome to Gomoku\n\n\n");
		playGame(p1, p2);
		System.out.printf("\n\nGoodbye!\n\n");
	}

	private static void playGame(PLAYER p1, PLAYER p2) {
		int width = 15;
		int height = 15;
		Table gameTable = new Table(width, height);
		int win = 0;
		int validMove = 0;
		int[] move = new int[2];

		Player player1 = new Player(1);
		Player player2 = new Player(2);

			player2.setID(PLAYER.HUMAN);

		while (true) {
			// p1 move
			gameTable.printTable();
			while (validMove != 1) {
				move = player1.getMove(gameTable.getStore());
				validMove = gameTable.makeMove(1, move[0], move[1]);
			}
			validMove = 0;

			// check win
			win = gameTable.checkWin();
			if (win == 1) {
				gameTable.printTable();
				System.out.println("Player one Wins");
				break;
			}

			// p2 move
			gameTable.printTable();
			while (validMove != 1) {
				move = player2.getMove(gameTable.getStore());
				validMove = gameTable.makeMove(2, move[0], move[1]);
			}
			validMove = 0;

			// check win
			win = gameTable.checkWin();
			if (win == 2) {
				gameTable.printTable();
				System.out.println("Player two Wins");
				break;
			}
		}

	}
}