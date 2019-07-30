import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Surender
 * this class is for zoo managements system
 */
public class Zoo {

	private final int zooCapacity;
	List<Zone> zone;
	private static int id = 0;
	Map<String, Integer> capacityOfCage = new HashMap<String, Integer>();
	Map<String, Integer> capacityOfZone = new HashMap<String, Integer>();

	/**
	 * Constructor
	 */
	public Zoo() {
		zooCapacity = 3;
		zone = new ArrayList<Zone>();
		
		capacityOfCage.put("Tiger", 1);
		capacityOfCage.put("Snake", 10);
		capacityOfCage.put("Parrot", 12);
		
		capacityOfZone.put("Mammal", 1);
		capacityOfZone.put("Reptile", 1);
		capacityOfZone.put("Bird", 1);
	}

	/**
	 * @param typeis the typeof animal that can be put in that cage 
	 * @return the capacity of that animal in the cage
	 */
	public int getCapacityOfCage(String type) {
		return capacityOfCage.get(type);
	}

	/**
	 * @param category is category of the animal that can be put in the zone 
	 * @return the number of cages allocated to that specific category
	 */
	public int getCapacityOfZone(String category) {	
		return capacityOfZone.get(category);
	}

	/**
	 * @param typeOfAnimal e.g Tiger,deer,snake etc..
	 * @return superclass's name of that type of animal
	 */
	public String getCategory(String typeOfAnimal) {
		String category = "";
		
		switch (typeOfAnimal) {
			case "Tiger" :
				category = Tiger.class.getSuperclass().getSimpleName();
				break;
		
			case "Snake" :
				category = Snake.class.getSuperclass().getSimpleName();
				break;
			
			case "Parrot" :
				category = Parrot.class.getSuperclass().getSimpleName();
				break;
			
			default :
				break;
		}
		return category;
	}

	/**
	 * @param category is the category of the animal that can be put in the zone
	 * @param limitOfCages is the number of cages allowed in that zone
	 * @return the index of last zone added
	 */
	public int addZone(String category) {
		zone.add(new Zone(category, getCapacityOfZone(category) ));
		return zone.size() - 1;
	}

	/**
	 * @param name is the name of the animal
	 * @param type is the category of animal
	 * @param weight is the weight of the animal
	 * @param age is the age of the animal
	 * @return true if animal is added else return false
	 */
	public boolean addAnimal( String name, String type, double weight, int age) {
		int[] index = indexForAnimal(type);
		
		switch (type) {
			case "Tiger" :
				zone.get(index[0]).cageList.get(index[1]).animal.add(new Tiger(++id, name, type, weight, age));
				break;
			
			case "Snake" :
				zone.get(index[0]).cageList.get(index[1]).animal.add(new Snake(++id, name, type, weight, age));
				break;
				
			case "Parrot" :
				zone.get(index[0]).cageList.get(index[1]).animal.add(new Parrot(++id, name, type, weight, age));
				break;
				
			default :
				break;
		}
		return true;
	}

	/**
	 * @param type is the type of animals allowed in the zone
	 * @return index of zone
	 */
	public int indexOfZone(String type) {
		
		String category = getCategory(type);
		for (int i = 0; i < zone.size(); i++) {
			if (zone.get(i).getCategory().equals(category)) {
				if (zone.get(i).cageList.contains(type)) {
					int cageIndex = zone.get(i).cageList.indexOf(type);
					if (zone.get(i).cageList.get(cageIndex).animal.size() < zone.get(i).cageList.get(cageIndex).getCapacity()) {
						return i;
					}		
				} else if (zone.get(i).cageList.size() < zone.get(i).getLimitOfCages()) {
					return i;
				}
			}
		}
		
		if (zone.size() < zooCapacity) {
			return addZone(category);
		}else {
			throw new AssertionError("Zoo is full");
		}
	}

	/**
	 * @param type is the 
	 * @return index of zone and cage
	 */
	public int[] indexForAnimal(String type) {
		int zoneIndex = indexOfZone(type);
		int[] index = new int[2];
		if (zone.get(zoneIndex).cageList.contains(type)) {
			index[0] = zoneIndex;
			index[1] = zone.get(zoneIndex).cageList.indexOf(type);
			return index;
		} 
		else {
			zone.get(zoneIndex).cageList.add(new Cage(type, getCapacityOfCage(type)));
			index[0] = zoneIndex;
			index[1] = zone.get(zoneIndex).cageList.size() - 1;
			return index;
		}
	}

	/**
	 * @param name is the name of the animal
	 * @param type is the type of the animal
	 * @return true if animal is removed else return false
	 */
	public boolean removeAnimal(String name, String type) {
		int i;
		for (i = 0; i < zone.size(); i++) {
			if (zone.get(i).getCategory().equals(getCategory(type))) {
				for (int j = 0; j < zone.get(i).cageList.size(); j++) {
					if (zone.get(i).cageList.get(j).getTypeOfAnimal().equals(type)) {
						for (int k = 0; k < zone.get(i).cageList.get(j).animal.size(); k++) {
							if (zone.get(i).cageList.get(j).animal.get(k).getName().equals(name)){
								zone.get(i).cageList.get(j).animal.remove(name);
								return true;
							}
						}
						return false;
					}
				}
			}
		}
		return false;
	}

}