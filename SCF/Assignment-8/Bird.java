/**
 * @author Surender
 * this class extends the Animal class
 */
public abstract class Bird extends Animal {

	/**
	 * Constructor
	 * @param id is the animal-id
	 * @param name is the name of the animal
	 * @param type is the type of animal
	 * @param weight is the weight of the animal
	 * @param age is the age of the animal
	 */
	public Bird(int id, String name, String type, double weight, int age) {
		super(id, name, type, weight, age);
	}

	/**
	 * Abstract Method to return Sound of the birds
	 */
	abstract public String getSound();
	
	/**
	 * Method to return physical traits of the birds
	 */
	public String physicalTraits() {
		return ("Birds have feathers");
	}

	/**
	 * Method to return their Birth Process
	 */
	public String giveBirth() {
		return ("Birds lays eggs");
	}
}
