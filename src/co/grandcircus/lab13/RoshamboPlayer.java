package co.grandcircus.lab13;

public abstract class RoshamboPlayer {
	private String name;
	private int wins;
	private int losses;
	private int draws;

	// Construct Player with no prior win/loss record
	public RoshamboPlayer(String name) {
		this.name = name;
		this.wins = 0;
		this.losses = 0;
		this.draws = 0;
	}

	public String getName() {
		return name;
	}

	public void setPlayer(String name) {
		this.name = name;
	}
	
	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public void setDraws(int draws) {
		this.draws = draws;
	}

	// Increment win count
	public void win() {
		wins++;
	}

	// Increment loss count
	public void lose() {
		losses++;
	}
	
	// Increment draw count
	public void draw() {
		draws++;
	}

	// Print win/loss record
	public void displayWinsLosses() {
		// TODO: Maybe some fancy string formatting...
		System.out.println("Wins: " + wins);
		System.out.println("Losses: " + losses);
		System.out.println("Draws: " + draws);
	}

	// Subclasses must have a generateRoshamboMove method!
	public abstract RoshamboMove getRoshamboMove();

}
