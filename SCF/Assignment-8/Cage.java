import java.util.ArrayList;
import java.util.List;

/**
 * @author Surender
 * class for managing the cage
 */
public class Cage {
	private int capacity;
	String typeOfAnimal;
	public List<Animal> animal = new ArrayList<Animal>();

	/**
	 * Constructor
	 * @param typeOfAnimal is the type of the animal that can be there in the cage
	 * @param capacity is the total capacity of the cage
	 */
	public Cage(String typeOfAnimal, int capacity) {
		this.capacity = capacity;
		this.typeOfAnimal = typeOfAnimal;
	}

	/**
	 * Getter Method to get the capacity of the cage
	 * @return the capacity of the cage
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Setter Method to change the capacity of the cage
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Getter Method to get the type of animal in the cage
	 * @return the type of animals in the cage
	 */
	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	/**
	 * Setter Method to change the type of animals in the cage
	 */
	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}

}
