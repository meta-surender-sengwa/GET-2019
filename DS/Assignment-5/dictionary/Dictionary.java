package dictionary;

/**
 * This interface represents dictionary
 * @author Surender Sengwa
 *
 */
public interface Dictionary {

	/**
	 * This method adds key-value pair to dictionary
	 * @param key is String type key of element
	 * @param value is String type value of element
	 * @return true if key value-pair is added else return false
	 * @throws Exception if key is already present
	 */
	public boolean add(String key, String value) throws Exception;

	/**
	 * This method deletes key-value pair for given key
	 * @param key is String type key for which data need to be deleted
	 * @return true if key value-pair is deleted else return false
	 * @throws Exception if dictionary is empty or key to be deleted not found
	 */
	public boolean delete(String key) throws Exception;

	/**
	 * This method returns value for given key
	 * @param key is String type key for which value need to be find
	 * @return String type value for the given key
	 * @throws Exception if key is not present
	 */
	public String getValue(String key) throws Exception;

	/**
	 * This method returns sorted list of key-value pairs in dictionary
	 * @return sorted 2d array containing keys and values 
	 * @throws Exception if dictionary is empty
	 */
	public String[][] getSortedKeyValuePairs() throws Exception;

	/**
	 * This method returns sorted list of key value pairs in dictionary between given two keys
	 * @param firstKey is String type key from which all key should be greater
	 * @param secondKey is String type key form which all key should be smaller
	 * @return sorted 2d array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	public String[][] getSortedKeyValuePairs(String firstKey, String secondKey) throws Exception;
}
