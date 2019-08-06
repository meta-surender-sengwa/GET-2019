package ds.bowlinorder;

/**
 * @author Surender
 * This class represents Bowler
 */
public class Bowler {

	private final String nameOfBowler;
	private int numberOfBallsLeft;

	public Bowler(String nameOfBowler, int numberOfBallsLeft) {
		this.nameOfBowler = nameOfBowler;
		this.numberOfBallsLeft = numberOfBallsLeft;
	}

	public int getNumberOfBallsLeft() {
		return this.numberOfBallsLeft;
	}

	public void setNumberOfBallsLeft(int numberOfBallsLeft) {
		this.numberOfBallsLeft = numberOfBallsLeft;
	}

	public String getNameOfBowler() {
		return this.nameOfBowler;
	}
}