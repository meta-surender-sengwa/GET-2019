package dictionary;

import com.google.gson.Gson;

/**
 * This class represent dictionary data structure
 * @author Surender Sengwa
 *
 */
public class DictionaryImplementation implements Dictionary {

	private BST bst;
	
	public DictionaryImplementation(String initialPairs) throws Exception{
		
		if (initialPairs.length() == 0) {
			throw new Exception("Invalid JSON String");
		}
		
		bst = new BST();
		
		// creating object of Gson class which use to parse JSON string and extract data
		Gson gson = new Gson();
		
		// getting data from JSON string to object of data class
		Data data = gson.fromJson(initialPairs, Data.class);
		
		// filling initial values in dictionary
		fillDictionary(data);
		
	}
	
	/**
	 * This method fills initial key value pairs in dictionary
	 * @param data object of Data class containing the key value String arrays
	 * @throws Exception if number of keys and values is not equal
	 */
	private void fillDictionary(Data data) throws Exception{
		
		if (data.getKeys().length == data.getValues().length) {
			
			String[] keys = data.getKeys();
			String[] values = data.getValues();
			
			for (int index = 0; index < keys.length; index++) {
				this.add(keys[index], values[index]);
			}
			
		} else {
			throw new Exception("Missing key value pairs");
		}
		
	}
	
	/**
	 * This method adds key value-pair to dictionary
	 * @param key is String type key of element
	 * @param value is String type value of element
	 * @return true if key value pair is added else return false
	 * @throws Exception if key is already present
	 */
	@Override
	public boolean add(String key, String value) throws Exception{
		
		Node node = new Node(key, value);
		return bst.add(node);
	}

	/**
	 * This method deletes key value-pair for given key
	 * @param key is String type key for which data need to be deleted
	 * @return true if key value pair is deleted else return false
	 * @throws Exception if dictionary is empty or key not found
	 */
	@Override
	public boolean delete(String key) throws Exception {
	
		try {
			return bst.delete(key);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			if(e.getMessage().equalsIgnoreCase("BST is empty")){
				throw new Exception("Dictionary is empty");
			} else {
				throw e;
			}
		}
	}

	/**
	 * This method returns value for given key
	 * @param key is String type key for which value need to be find
	 * @return String type value for the given key
	 * @throws Exception if key not found
	 */
	@Override
	public String getValue(String key) throws Exception{
		
			return bst.getValue(key).getValue();
	}

	/**
	 * This method returns sorted list of key value pairs in dictionary
	 * @return sorted 2d array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	@Override
	public String[][] getSortedKeyValuePairs() throws Exception{
	
			Node[] sortedNodes = bst.getSortedNode();
			String[][] sortedKeyValuePairs = new String[sortedNodes.length][2];
			
			int index =0;
			for(Node node : sortedNodes) {
				sortedKeyValuePairs[index][0] = node.getKey();
				sortedKeyValuePairs[index][1] = node.getValue();
				index++;
			}
			return sortedKeyValuePairs;
	}

	/**
	 * This method returns sorted list of key value pairs in dictionary between given two keys
	 * @param firstKey is String type key from which all key should be greater or equal
	 * @param secondKey is String type key form which all key should be smaller or equal
	 * @return sorted 2d array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	@Override
	public String[][] getSortedKeyValuePairs(String firstKey, String secondKey) throws Exception {
	
			Node[]  sortedNodes = this.bst.getSortedNode(firstKey,secondKey);
			String[][] sortedKeyValuePairs = new String[sortedNodes.length][2];
			
			int index = 0;
			for(Node node : sortedNodes){
				sortedKeyValuePairs[index][0] = node.getKey();
				sortedKeyValuePairs[index][1] = node.getValue();
				index++;
			}
			return sortedKeyValuePairs;
	}
}