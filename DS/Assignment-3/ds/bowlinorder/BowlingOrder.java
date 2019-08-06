package ds.bowlinorder;

import ds.priorityqueue.*;

/**
 * @author Surender
 * This class contains method to set the order of bowling
 */
public class BowlingOrder {

	private int totalNumberOfBowlers;
	private PriorityQueue priorityQueue;

	public BowlingOrder(int totalNumberOfBowlers) {
		this.totalNumberOfBowlers =totalNumberOfBowlers;
		this.priorityQueue = new PriorityQueue(this.totalNumberOfBowlers);
	}

	/**
	 * Method to add a bowler to the list
	 * @param Bowler is the bowler object
	 * @return true after adding bowler
	 * @throws exception if bowler list is full
	 */
	public boolean addBowler(Bowler bowler) throws Exception {
		if (totalNumberOfBowlers > 0) {
			
			if(bowler.getNumberOfBallsLeft() != 0){
				priorityQueue.enQueue(bowler.getNumberOfBallsLeft(), bowler.getNameOfBowler());
			}
			
			totalNumberOfBowlers--;
			return true;
			
		} else {
			throw new Exception("Bowlers List is already Full");
		}
	}

	/**
	 * Method to return the next Bowler to bowl
	 * @return Bowlers Name
	 * @throws exception if no bowler is left to bowl
	 */
	public String getNextBowler() throws Exception {
		if (totalNumberOfBowlers == 0) {
			
			if (priorityQueue.isEmpty()) {
				throw new Exception("No Bowler has balls left to bowl");
			}
			
			Element element = priorityQueue.deQueue();
			
			Bowler bowler = new Bowler(element.getValue(), element.getPriority());
			totalNumberOfBowlers++;
			
			bowler.setNumberOfBallsLeft(bowler.getNumberOfBallsLeft() - 1);
			addBowler(bowler);
			
			return bowler.getNameOfBowler();
			
		} else {
			throw new Exception("Complete Addition Of Bowlers First");
		}
	}
}
