package ds.bowlinorder;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestBowlingOrder {
	@Test
	public void testAddBowler() throws Exception {
		BowlingOrder sequence = new BowlingOrder(4);
		
		assertTrue(sequence.addBowler(new Bowler("Navdeep", 3)));
		assertTrue(sequence.addBowler(new Bowler("Shami", 2)));
		assertTrue(sequence.addBowler(new Bowler("Bumrah", 4)));
		assertTrue(sequence.addBowler(new Bowler("Khaleel", 1)));
	}

	@Test
	public void testGetNextBowler() throws Exception {
		
		BowlingOrder bowlingOrder = new BowlingOrder(4);
		
		assertTrue(bowlingOrder.addBowler(new Bowler("Navdeep", 3)));
		assertTrue(bowlingOrder.addBowler(new Bowler("Shami", 2)));
		assertTrue(bowlingOrder.addBowler(new Bowler("Bumrah", 4)));
		assertTrue(bowlingOrder.addBowler(new Bowler("Khaleel", 1)));
		
		assertEquals("Bumrah", bowlingOrder.getNextBowler());
		assertEquals("Navdeep", bowlingOrder.getNextBowler());
		assertEquals("Bumrah", bowlingOrder.getNextBowler());
		assertEquals("Navdeep", bowlingOrder.getNextBowler());
		
		//	assertEquals("Bumrah", bowlingOrder.getNextBowler());
		assertNotEquals("Shami", bowlingOrder.getNextBowler());
		
		assertEquals("Shami", bowlingOrder.getNextBowler());
		assertEquals("Bumrah", bowlingOrder.getNextBowler());
		assertEquals("Shami", bowlingOrder.getNextBowler());
		assertEquals("Khaleel", bowlingOrder.getNextBowler());
	}
}
