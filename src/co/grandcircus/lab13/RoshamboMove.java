package co.grandcircus.lab13;

// Created a value that can only have the listed options
public enum RoshamboMove {
	ROCK, PAPER, SCISSORS;

	@Override
	public String toString() {
		switch (this) {
		case ROCK:
			return "Rock";
		case PAPER:
			return "Paper";
		case SCISSORS:
			return "Scissors";
		default:
			throw new IllegalArgumentException();
		}
	}

}
