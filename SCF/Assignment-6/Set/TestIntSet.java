import static org.junit.Assert.*;

import org.junit.Test;


public class TestIntSet {
	private IntSet set = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});

	@Test
	public void testIsMemberOfSet() {
		assertTrue(set.isMemberOfSet(2));
		assertTrue(set.isMemberOfSet(4));
		assertTrue(set.isMemberOfSet(7));
		assertFalse(set.isMemberOfSet(0));
		assertFalse(set.isMemberOfSet(11));
	}

	@Test
	public void testSizeOfSet() {
		assertEquals(9, set.sizeOfSet());
		assertNotEquals(10, set.sizeOfSet());
	}
	
	@Test
	public void testIsSubsetOfSet() {
		assertTrue(set.isSubSetOfSet(new int[] {}));
		assertTrue(set.isSubSetOfSet(new int[] {1,2,3}));
		assertTrue(set.isSubSetOfSet(new int[] {1,2,3,4,5,6,7,8}));
		assertTrue(set.isSubSetOfSet(new int[] {1,2,3,4,5,6,7,8,9}));
		assertFalse(set.isSubSetOfSet(new int[] {1,2,3,10}));
	}
	
	@Test
	public void testComplementOfSet() {
		assertArrayEquals(new int[]{1,2,3}, set.complementOfSet(new int[]{4,5,6,7,8,9}));
	}
	
	@Test
	public void testUnionOfSet() {
		assertArrayEquals(new int[]{1,2,3}, set.unionOfSets(new int[]{1}, new int[]{2,3}));
		assertArrayEquals(new int[]{1,3}, set.unionOfSets(new int[]{1}, new int[]{1,3}));
	}
}
