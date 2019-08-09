package dictionary;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDictionary {

	static String keyValuePairsJsonString = "";
	
	@BeforeClass
	public static void setUpBeforeClass(){
		keyValuePairsJsonString = " { \"keys\" : [\"1\"] , \"values\" : [\"apple\"]}";
	}

	@Test
	public void testAddMethod() {
		
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "mango";
		
		try {
			Dictionary dictionary = new DictionaryImplementation(keyValuePairsJsonString);
			assertTrue(dictionary.add(key1, value1));
			assertTrue(dictionary.add(key2, value2));
			assertTrue(dictionary.add(key3, value3));
		
		} catch(Exception e) {
			
		}
		
	}

	@Test
	public void testDeleteMethod() {
		
		try {
			Dictionary dictionary = new DictionaryImplementation(keyValuePairsJsonString);
			assertTrue(dictionary.delete("1"));
			
		} catch(Exception e) {
			
		}
	}

	@Test
	public void testGetValueMethod() {
		
		try {
			Dictionary dictionary = new DictionaryImplementation(keyValuePairsJsonString);
			assertEquals("apple",dictionary.getValue("1"));
			
		} catch(Exception e) {
			
		}
		
	}

	@Test
	public void testGetSortedKeyValuePairs() {
		
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		
		try {
			Dictionary dictionary = new DictionaryImplementation(keyValuePairsJsonString);
			assertTrue(dictionary.add(key1, value1));
			assertTrue(dictionary.add(key2, value2));
			assertTrue(dictionary.add(key3, value3));
			
			String expectedKeyValuePairs[][] = new String[][]{{"1","apple"},{"2","banana"},{"3","orange"},{"4","water melon"}};
			assertArrayEquals(expectedKeyValuePairs,dictionary.getSortedKeyValuePairs());
			
		} catch(Exception e) {
		
		}
	}

	@Test
	public void testGetSortedKeyValuePairsBetweenTwoKeys() {
		
		String key1 = "2";
		String key2 = "3";
		String key3 = "4";
		String value1 = "banana";
		String value2 = "orange";
		String value3 = "water melon";
		
		try {
			Dictionary dictionary = new DictionaryImplementation(keyValuePairsJsonString);
			assertTrue(dictionary.add(key1, value1));
			assertTrue(dictionary.add(key2, value2));
			assertTrue(dictionary.add(key3, value3));
			
			String expectedKeyValuePairs[][] = new String[][]{{"2","banana"},{"3","orange"}};
			assertArrayEquals(expectedKeyValuePairs,dictionary.getSortedKeyValuePairs("2","3"));
			
		} catch(Exception e) {

		}
	}
}
