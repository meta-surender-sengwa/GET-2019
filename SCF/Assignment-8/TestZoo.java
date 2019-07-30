import static org.junit.Assert.*;
import org.junit.Test;

/** 
 * @author Surender
 *	class TestZoo for testing the zoo management system
 */
public class TestZoo {
	Zoo zoo=new Zoo();
	
	@Test
	public void addAnimalWhenZooIsNotFull() {
		zoo.addZone("Bird");
		assertTrue(zoo.addAnimal("mithu", "Parrot", 1, 2));
		assertTrue(zoo.addAnimal("moti", "Parrot", 1, 3));
	}
	
	@Test(expected = AssertionError.class)
	public void addAnimalWhenZooIsFull() {
		zoo.addZone("Bird");
		assertFalse(zoo.addAnimal("moti", "Parrot", 1, 2));
	}
	
	@Test
	public void removeAnimalTest(){
		zoo.addZone("Mammal");
		zoo.addAnimal("SherKhan", "Tiger", 122, 5);
		
		assertTrue(zoo.removeAnimal("SherKhan", "Tiger"));
		assertFalse(zoo.removeAnimal("Bahadur", "Tiger"));
	}
}
