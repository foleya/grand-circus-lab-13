package co.grandcircus.lab13;

import java.util.ArrayList;
import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		// Welcome
		System.out.println("Hello! Welcome to Roshambo! (AKA: Rock, Paper, Scissors)\n");

		// Instantiate a human player
		// TODO: Extract method and add some kind of validation
		System.out.println("What is your name?");
		String playerName = scnr.nextLine();
		RoshamboPlayer playerOne = new HumanPlayer(scnr, playerName);

		// Let user select an Opponent, then instantiate that opponent
		System.out.println("\nHello " + playerName + "! Select your opponent:");
		RoshamboPlayer opponent = getOpponent(scnr);

		// Enter the Roshambo LOOP!
		roshamboLoop(scnr, playerOne, opponent);

		// Report user's win/loss record and say goodbye
		// TODO: Extract method and add a more personalized message based on record
		System.out.println("Your final win/loss record was...");
		playerOne.displayWinsLosses();
		System.out.println("\nSee you next time!");

		scnr.close();
	}

	private static void roshamboLoop(Scanner scnr, RoshamboPlayer playerOne, RoshamboPlayer opponent) {
		boolean quitProgram = false;
		do {
			// Get and print user and opponent moves
			RoshamboMove userMove = playerOne.getRoshamboMove();
			RoshamboMove opponentMove = opponent.getRoshamboMove();
			System.out.println(playerOne.getName() + " chose " + userMove + " ... and " + opponent.getName() + " chose "
					+ opponentMove + "!\n");

			// Evaluate and report the match results
			String getMatchResult = getRoshamboMatchResult(userMove, opponentMove);
			reportRoshamboResult(playerOne, userMove, opponentMove, getMatchResult);

			// Report the user's current win/loss record
			System.out.println("Your current win/loss record:");
			playerOne.displayWinsLosses();

			// Ask if the user would like to play again or quit
			System.out.println("Play again? (Y/n)");
			if (scnr.nextLine().toLowerCase().trim().equals("n")) {
				quitProgram = true;
			}
		} while (!quitProgram);
	}

	private static RoshamboPlayer getOpponent(Scanner scnr) {
		ArrayList<String> opponents = new ArrayList<String>();
		opponents.add("1. Maui (Favors the Rock, like, a lot.)");
		opponents.add("2. Heihei (Favors randomness!)");

		for (String opponent : opponents) {
			System.out.println(opponent);
		}
		System.out.println("Enter a number (1-" + opponents.size() + "): ");
		int menuChoice = 0;
		boolean menuChoiceIsValid = false;
		do {
			try {
				menuChoice = Integer.parseInt(scnr.nextLine().trim());
				Validators.validateChoiceInOptions(menuChoice, opponents.size());
				menuChoiceIsValid = true;
			} catch (IllegalArgumentException ex) {
				System.out.println("\n-- You must enter a number between 1 and " + opponents.size() + "! --\n");
			}
		} while (!menuChoiceIsValid);

		if (menuChoice == 1) {
			System.out.println("You will face: MAUI!\n");
			return new RockPlayer("Maui");
		} else {
			System.out.println("You will face: HEIHEI!\n");
			return new RandomPlayer("Heihei");
		}
	}

	private static void reportRoshamboResult(RoshamboPlayer playerOne, RoshamboMove userMove, RoshamboMove opponentMove,
			String matchResult) {
		switch (matchResult) {
		case ("win"):
			System.out.println("-- " + userMove + " beats " + opponentMove + ". You win! --\n");
			playerOne.win();
			break;
		case ("loss"):
			System.out.println("-- " + opponentMove + " beats " + userMove + ". You lose! --\n");
			playerOne.lose();
			break;
		case ("draw"):
			System.out.println("-- You both picked " + userMove + ". It's a draw! --\n");
			playerOne.draw();
			break;
		default:
			break;
		}
	}

	private static String getRoshamboMatchResult(RoshamboMove userMove, RoshamboMove opponentMove) {
		if (userMove == opponentMove) {
			// draw
			return "draw";
		} else if (userMove == RoshamboMove.ROCK && opponentMove == RoshamboMove.SCISSORS) {
			// win
			return "win";
		} else if (userMove == RoshamboMove.PAPER && opponentMove == RoshamboMove.ROCK) {
			// win
			return "win";
		} else if (userMove == RoshamboMove.SCISSORS && opponentMove == RoshamboMove.PAPER) {
			// win
			return "win";
		} else {
			// lose
			return "loss";
		}
	}

}
