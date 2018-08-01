package co.grandcircus.lab13;

import java.util.Scanner;

public class HumanPlayer extends RoshamboPlayer {
	Scanner scnr;

	public HumanPlayer(Scanner scnr, String name) {
		super(name);
		this.scnr = scnr;
	}

	@Override
	public RoshamboMove getRoshamboMove() {
		boolean moveChoiceIsValid = false;
		String userMoveChoice;
		
		// Prompt user to choose a move
		do {
			System.out.println("Type your move (Rock (r), Paper (p), or Scissors (s):");
			userMoveChoice = scnr.nextLine().toLowerCase().trim();
			try {
				Validators.validateRoshamboChoice(userMoveChoice);
				moveChoiceIsValid = true;
			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			} 
		} while (!moveChoiceIsValid);
		
		// Return corresponding RoshamboMove
		if (userMoveChoice.equals("r") || userMoveChoice.equals("rock")) {
			return RoshamboMove.ROCK;
		} else if (userMoveChoice.equals("p") || userMoveChoice.equals("paper")) {
			return RoshamboMove.PAPER;
		} else {
			return RoshamboMove.SCISSORS;
		}
		
	}

}
