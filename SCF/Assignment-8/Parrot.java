/**
 * @author Surender
 * this class extends the Bird class  
 */
public class Parrot extends Bird {

	/**
	 * Constructor
	 * @param id is the Animal-id of the parrot
	 * @param name is the Name of the parrot
	 * @param type is the type of the parrot
	 * @param weight is the weight of the parrot  
	 * @param age is the age of the parrot
	 */
	public Parrot(int id, String name, String type, double weight, int age) {
		super(id, name, type, weight, age);
	}

	/**
	 * this Method returns the sound of parrot 
	 */
	@Override
	public String getSound() {
		return ("Talks/Screech");
	}

	/**
	 * this Method returns the food of parrot
	 */
	public String eat() {
		return ("Raw Veggies");
	}
}

