package co.grandcircus.lab13;

public class RandomPlayer extends RoshamboPlayer {

	public RandomPlayer(String name) {
		super(name);
	}

	@Override
	public RoshamboMove getRoshamboMove() {
		double randomNum = Math.random();
		if (randomNum <= (1.0 / 3.0)) {
			// 0-0.33ish of the time, pick Rock
			return RoshamboMove.ROCK;
		} else if (randomNum <= (2.0 / 3.0)) {
			// 0.34-0.66ish of the time, pick Paper
			return RoshamboMove.PAPER;
		} else {
			// 0.67-0.99ish of the time, pick Scissors
			return RoshamboMove.SCISSORS;
		}
	}

}
