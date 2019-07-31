/**
 * @author Surender
 *	this is an abstract class
 */
public abstract class Animal {
	private int id;
	private String name;
	private String type;
	private double weight;
	private int age;

	/**
	 * Constructor
	 * @param id is the animal-id
	 * @param name is the name of the animal
	 * @param type is the type of animal
	 * @param weight is the weight of the animal
	 * @param age is the age of the animal
	 */
	public Animal(int id, String name, String type, double weight, int age) {
		this.id = id;
        this.name = name;
		this.type = type;
		this.weight = weight;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	/**
	 * Abstract Method to return Sound of the animal
	 */
	abstract public String getSound();
	
	/**
	 * Method to return physical traits of the birds
	 */
	public String physicalTraits() {
		return ("Animals have some unique physial traits");
	}
	
	/**
	 * Method to return the food of the animal
	 */
	public String eat() {
		return ("Animals Eats");
	}
	
	/**
	 * Method to return their Birth Process
	 */
	public String giveBirth() {
		return ("Animals give birth");
	}
}
