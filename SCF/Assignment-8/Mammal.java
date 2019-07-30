/**
 * @author Surender
 * this class extends the Animal class
 */
public abstract class Mammal extends Animal {

	/**
	 * Constructor
	 * @param id is the animal-id
	 * @param name is the name of the animal
	 * @param type is the type of animal
	 * @param weight is the weight of the animal
	 * @param age is the age of the animal
	 */
	public Mammal(int id, String name, String type, double weight, int age) {
		super(id, name, type, weight, age);
	}

	/**
	 * Abstract Method to return Sound of the animal
	 */
	abstract public String getSound();
	
	/**
	 * Method to return physical traits of the animal
	 */
	public String physicalTraits() {
		return ("Mammals walks on their legs");
	}

	/**
	 * Method to return their Birth Process
	 */
	public String giveBirth() {
		return ("Mammals gives birth");
	}

}
