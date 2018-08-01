package co.grandcircus.lab13;

public class RockPlayer extends RoshamboPlayer {
	
	
	public RockPlayer(String name) {
		super(name);
	}

	@Override
	public RoshamboMove getRoshamboMove() {
		// Always chose rock
		return RoshamboMove.ROCK;
	}

}
