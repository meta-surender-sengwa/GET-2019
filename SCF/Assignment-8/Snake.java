/**
 * @author Surender
 * this class extends the Raptile class  
 */
public class Snake extends Raptile {

	/**
	 * Constructor
	 * @param id is the Animal-id of the snake
	 * @param name is the Name of the snake
	 * @param type is the type of the snake
	 * @param weight is the weight of the snake  
	 * @param age is the age of the snake
	 */
	public Snake(int id, String name, String type, double weight, int age) {
		super(id, name, type, weight, age);
	}

	/**
	 * this Method returns the sound of snake 
	 */
	@Override
	public String getSound() {
		return ("Hhhhhisssssss");
	}
	
	/**
	 * this Method returns the food of snake
	 */
	public String eat() {
		return ("Rats an insects");
	}
}
