import java.util.ArrayList;
import java.util.List;

/**
 * @author Surender
 * class for managing the zone
 */
public class Zone {
	private String category;
	private int limitOfCages;
	public List<Cage> cageList = new ArrayList<Cage>();
	
	/**
	 * Constructor
	 * @param category is the category of the animals that can be allocated to the cage in a zone
	 * @param limitOfCages is the maximum number of cages that can be there in a zone
	 */
	public Zone(String category, int limitOfCages) {
		super();
		this.category = category;
		this.limitOfCages = limitOfCages;
	}
	
	/**
	 * Method to get the category of the animals that can be allocated to the cage in a zone 
	 * @return the category of the animals that can be allocated to the cage in a zone 
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Method to get the maximum number of cages that can be there in a zone
	 * @return the maximum number of cages that can be there in a zone
	 */
	public int getLimitOfCages() {
		return limitOfCages;
	}
	
	/**
	 * Method to check if the zone has a park
	 * @return
	 */
	public boolean hasPark() {
		return true;
	}
	
	/**
	 * Method to check if the zone has a canteen
	 * @return
	 */
	public boolean hasCanteen() {
		return true;
	}
}
