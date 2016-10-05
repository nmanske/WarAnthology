package waranthology;

import java.lang.Math;
import java.util.List;
import java.util.Random;

import waranthology.WarLauncher.WarGame;

public class WarHandler {

	private Player player1;
	private Player player2;
	
	public WarHandler(Player player1, Player player2, WarGame gameMode) {
		this.player1 = player1;
		this.player2 = player2;
		initGame();
	}
	
	private void run() {
		
	}
	
	private void initGame() {
		Random rand = new Random();
		int firstPlayer = rand.nextInt(2) + 1;			// returns a 1 (HEADS) or 2 (TAILS)
		if (firstPlayer == 1) player1.setTurn(true);
		else player2.setTurn(true);
	}
	
	private boolean isGameOver() {
		return player1.isOutOfCards() || player2.isOutOfCards();
	}
	
	private String getGameWinner() {
		if (player1.isOutOfCards()) return player1.getName();
		else if (player2.isOutOfCards()) return player2.getName();
		else return "Draw!";
	}
	
}
