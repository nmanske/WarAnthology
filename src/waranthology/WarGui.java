package waranthology;

import java.util.Scanner;

public class WarGui {
	
	public enum WarGame {
		WAR("Traditional War"),
		INEVITABLE_WAR("Inevitable War"),
		SAVAGE_WAR("Savage War"),
		GALACTIC_WAR("Galactic War"),		/* Created by Lee Walker */
		CLONE_WAR("Clone War");				/* Created by Ken Scherer */
		
		public static final int CLONE_WAR_UNIQUE_FACE_COUNT = 16;
		private static final int size = WarGame.values().length;
		
		private String name;
		
		private WarGame(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public static int size() {
			return size;
		}
	}

	public static void main(String[] args) {
		while (true) {
			displayMenu();
			WarGame gameMode = getInput();
			int numGames = 10;
			//WarHandler handler = new WarHandler(gameMode);
			for (int i = 0; i < numGames; i++) {
				//handler.run();
				System.out.println("Test " + i);
			}
			System.out.println();
		}		
	}
	
	private static void displayMenu() {
		System.out.println("=======================    -------------------------------\n" +
						   "|    WAR ANTHOLOGY    |    |         COMMAND LIST        |\n" +
						   "|---------------------|    |-----------------------------|\n" +
						   "|  1 : Standard War   |    |  # : Start game (replace #  |\n" +
						   "|  2 : Inevitable War |    |      w/ valid game number)  |\n" +
						   "|  3 : Savage War     |    | i# : View game instructions |\n" +
						   "|  4 : Galactic War   |    | s# : View game statistics   |\n" +
						   "|  5 : Clone War      |    |  x : Quit                   |\n" +
						   "=======================    -------------------------------\n");
		System.out.print("Enter Command: ");
	}
	
	private static void displayInstructions(int instructionNum) {
		System.out.println();
		switch (instructionNum) {
			case 1:
				System.out.println("----------------                                                                    \n" +
								   "| STANDARD WAR |                                                                    \n" +
								   "---------------------------------------------------------------------------------- |\n" +
								   "| Divide the deck evenly, with the cards dealt face down in a stack.               |\n" +
								   "|                                                                                  |\n" +
								   "| Each player turns up a card at the same time. The player with the higher card    |\n" +
								   "| takes both cards and places them in a random order on the bottom of the stack.   |\n" +
								   "|                                                                                  |\n" +
								   "| If the cards are the same rank, the players engage in war. Each player turns one |\n" +
								   "| card face down and another face up. The winner takes both piles of cards. If the |\n" +
								   "| two face up cards are again the same rank, then engage in another War.           |\n" +
								   "|                                                                                  |\n" +
								   "| If a player runs out of cards during a war the player loses. If both players run |\n" +
								   "| out of cards at the same time during a war then it is a draw.                    |\n" +
								   "|                                                                                  |\n" +
								   "| The game continues until one player (the winner) has all the cards.              |\n" +
								   "------------------------------------------------------------------------------------\n");
				break;
			case 2:
				System.out.println("------------------                                                                  \n" +
								   "| INEVITABLE WAR |                                                                  \n" +
								   "-----------------------------------------------------------------------------------|\n" +
								   "| A Joker card causes an automatic war. Otherwise gameplay is the same as the      |\n" +
								   "| standard version of War.                                                         |\n" +
								   "|----------------------------------------------------------------------------------|\n");
				break;
			case 3:
				System.out.println("----------------                                                                    \n" +
								   "| GALACTIC WAR |                                                                    \n" +
								   "-----------------------------------------------------------------------------------|\n" +
								   "| This game is played much like standard War, the only difference is that suits    |\n" +
								   "| affect the outcome of war. In the event of a war:                                |\n" +
								   "|                                                                                  |\n" +
								   "|    * If only the value of the matching cards is the same, each player deals out  |\n" +
								   "|      three cards face down.                                                      |\n" +
								   "|                                                                                  |\n" +
								   "|    * If the value and color match, but NOT the suit, each player deals out seven |\n" +
								   "|      cards face down.                                                            |\n" +
								   "|                                                                                  |\n" +
								   "|    * If both the value AND the suit match, each player deals out eleven cards    |\n" +
								   "|      face down.                                                                  |\n" +
								   "|----------------------------------------------------------------------------------|\n");
				break;
			case 4:
				System.out.println("--------------                                                                      \n" +
								   "| SAVAGE WAR |                                                                      \n" +
								   "-----------------------------------------------------------------------------------|\n" +
								   "| Any card that loses a battle is eliminated from the game. The winning card       |\n" +
								   "| is placed on the bottom of the owners deck. Only one card is played by each      |\n" +
								   "| player in the event of a war. It is possible to have a draw.                     |\n" +
								   "|----------------------------------------------------------------------------------|\n");
				break;
			case 5:
				System.out.println("-------------                                                                       \n" +
								   "| CLONE WAR |                                                                       \n" +
								   "-----------------------------------------------------------------------------------|\n" +
								   "| The gameplay is identical to standard War, the only difference is that the game  |\n" +
								   "| is played using face cards. The rule is that there should be 16 of each face     |\n" +
								   "| card in the deck, evenly split in regards in suit. This leads to faster games.   |\n" +
								   "|----------------------------------------------------------------------------------|\n");
				break;
			default:
				System.out.println("Not a valid game number! Try again.\n");
				break;
		}
		System.out.print("Enter Command: ");
	}

	private static WarGame getInput() {
		WarGame game = null;
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		do {
			if (sc.hasNextInt()) {
				gameNum = sc.nextInt();
				if (isValidGame(gameNum)) {
					game = WarGame.values()[gameNum-1];
				}
				else {
					System.out.println("\nInteger is not a valid game! Please try again.\n");
				}
			}
			else if (sc.hasNextLine()) {
				String command = sc.nextLine();
				if (command.charAt(0) == 'i' && command.length() == 2) {
					try {
						int instructionNum = Integer.parseInt(command.charAt(1) + "");
						displayInstructions(instructionNum);
					}
					catch (NumberFormatException e) {
						System.out.println("\nA number was expected after 'i', try again!\n");
					}
				}
				else if (command.charAt(0) == 'x' && command.length() == 1) {
					System.out.println("\nYou are now exiting the game. Goodbye!");
					System.exit(0);
				}
				else {
					System.out.println("\nInvalid command! Please try again.\n");
					displayMenu();
				}
			}
			else if (sc.hasNext()) {
				sc.next();
			}
		} while (!isValidGame(gameNum));
		sc.close();
		return game;
	}
	
	private static boolean isValidGame(int gameNum) {
		return gameNum <= WarGame.size() && gameNum > 0;
	}

}
