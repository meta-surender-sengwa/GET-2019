package dictionary;

/**
 * @author Surender
 * This class is data container for JSON String parsing
 */
public class Data {

	public String[] keys;
	public String[] values;
	
	public Data(String[] keys,String[] values){
		this.keys = keys;
		this.values = values;
	}

	public String[] getKeys() {
		return keys;
	}

	public String[] getValues() {
		return values;
	}
}
