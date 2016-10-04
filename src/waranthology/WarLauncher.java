package waranthology;

import java.util.Scanner;
import java.util.InputMismatchException;

public class WarLauncher {
	
	public static final String[] warGames = { "War" };

	public static void main(String[] args) {
		
		System.out.println("=====================");
		System.out.println("|   WAR ANTHOLOGY   |");
		System.out.println("=====================\n");
		System.out.println("1. War (2-6 players)\n");
		
		int gameNum = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (!isValidGame(gameNum)) {
				System.out.print("Enter game number to begin: ");
				gameNum = sc.nextInt();
				System.out.println();
			}			
		}
		catch (InputMismatchException e) {
			System.out.println("\nInvalid game! Please try again.\n");
		}
		System.out.println("Starting " + warGames[gameNum-1] + "...");
		
	}
	
	private static boolean isValidGame(int gameNum) {
		return gameNum <= warGames.length && gameNum > 0;
	}

}
