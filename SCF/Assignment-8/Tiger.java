/**
 * @author Surender
 * this class extends the Mammal class  
 */
public class Tiger extends Mammal {

	/**
	 * Constructor
	 * @param id is the Animal-id of the tiger
	 * @param name is the Name of the tiger
	 * @param type is the type of the tiger
	 * @param weight is the weight of the tiger  
	 * @param age is the age of the tiger
	 */
	public Tiger(int id, String name, String type, double weight, int age) {
		super(id, name, type, weight, age);
	}

	/**
	 * this Method returns the sound of tiger 
	 */
	@Override
	public String getSound() {
		return "RoarSs";
	}
	
	/**
	 * this Method returns the food of tiger
	 */
	public String eat() {
		return ("Animals and Meat");
	}
}
