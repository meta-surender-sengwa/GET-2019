import static org.junit.Assert.*;

import org.junit.Test;

public class TestNQueen {
	private int dimensionOfMatrix = 0;
	private int[][] board;
	NQueen Queen = new NQueen(); 
	
	@Test
	public void testWhenSolExist() {
		dimensionOfMatrix = 4;
		board = new int[dimensionOfMatrix][dimensionOfMatrix];
		
		assertTrue(Queen.nQueen(board,0,dimensionOfMatrix));
		
	}
	
	@Test
	public void testWhenSolNotExist() {
		int dimensionOfMatrix = 3;
		board = new int[dimensionOfMatrix][dimensionOfMatrix];
		
		assertFalse(Queen.nQueen(board,0,dimensionOfMatrix));
	}

}
