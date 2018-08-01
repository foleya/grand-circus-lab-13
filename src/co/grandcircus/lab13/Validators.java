package co.grandcircus.lab13;

public class Validators {

	public static void validateRoshamboChoice(String choice) {
		if (!choice.equals("r")
				&& !choice.equals("p")
				&& !choice.equals("s")
				&& !choice.equals("rock")
				&& !choice.equals("paper")
				&& !choice.equals("scissors")
		) {
			throw new IllegalArgumentException("\n-- You must enter Rock (r), Paper (p), or Scissors (s) --\n");
		}
	}
	
	public static void validateChoiceInOptions(int userInput, int optionsLength) {
		// This method just validates that a user has selected a number within the bounds of the menu
		if (userInput < 1 || userInput > optionsLength) {
			throw new IllegalArgumentException();
		}
	}

}
