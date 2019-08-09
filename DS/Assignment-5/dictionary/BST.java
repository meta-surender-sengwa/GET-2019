package dictionary;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * This class represent binary search tree data structure
 * @author Surender Sengwa
 *
 */
public class BST {

	public Node rootNode;

	public BST() {
		this.rootNode = null;
	}
	
	/**
	 * This method adds key value-pair to binary search tree
	 * @param Node is object of node class which needs to be added
	 * @return true if node is added else return false
	 * @throws Exception if node key is already present
	 */
	public boolean add(Node node) throws Exception {
		this.rootNode = add(this.rootNode, node);
		return true;
	}

	private Node add(Node rootNode, Node node) throws Exception {

		if (rootNode == null) {
			rootNode = node;
			return rootNode;
		}
		
		if (node.getKey().compareTo(rootNode.getKey()) < 0) {
			rootNode.leftChildNode = this.add(rootNode.leftChildNode, node);
			
		} else if (node.getKey().compareTo(rootNode.getKey()) > 0) {
			rootNode.rightChildNode = this.add(rootNode.rightChildNode, node);
			
		} else {
			throw new Exception("Node already Present");
		}
		
		return rootNode;
	}

	/**
	 * This method deletes the node for given key 
	 * @param key is String type key for which node need to be deleted
	 * @return true if node is deleted else return false
	 * @throws Exception if binary search tree is empty or key not found
	 */
	public boolean delete(String key)throws Exception {
		
		if (this.rootNode == null) {
			throw new Exception("BST is empty");
		}
		
		this.rootNode = delete(this.rootNode, key);
		return true;
	}

	private Node delete(Node rootNode, String key) throws Exception {
		
        if (rootNode == null){
        	throw new Exception("Key not found");
        }

        if (rootNode.getKey().compareTo(key) > 0){
        	rootNode.leftChildNode = delete(rootNode.leftChildNode, key); 
        	
        }	else if (rootNode.getKey().compareTo(key) < 0){ 
        	rootNode.rightChildNode = delete(rootNode.rightChildNode, key);
        	
        } else { 
            // if our node has only one child or no child 
            if (rootNode.leftChildNode == null){  return rootNode.rightChildNode; }  
            else if (rootNode.rightChildNode == null){
            	return rootNode.leftChildNode; 
            }
            
            //	if our node has two children get the inorder successor ie, smallest node in the right subtree
            Node minNode = getInOrderSuccessorNode(rootNode.rightChildNode); 
  
            //	Delete the inorder successor 
            rootNode.rightChildNode = delete(rootNode.rightChildNode, minNode.getKey()); 
            
            //	changing left and right node references 
            minNode.leftChildNode = rootNode.leftChildNode;
            minNode.rightChildNode = rootNode.rightChildNode;
            rootNode = minNode;
        } 
        
        return rootNode; 
	}
	
	/**
	 * This method returns the in-order successor
	 * @param node starting node in binary search tree
	 * @return the node with minimum key value
	 */
	private Node getInOrderSuccessorNode(Node node) {
		
		Node minNode = node;
        while (minNode.leftChildNode != null) { 
            minNode = minNode.leftChildNode; 
        } 
        return minNode; 
	}
	
	/**
	 * This method returns the node for given key
	 * @param key is String type key for which node needs to be found
	 * @return node for the given key
	 * @throws Exception if key not found
	 */
	public Node getValue(String key) throws Exception {
		return getValue(this.rootNode, key);
	}

	private Node getValue(Node rootNode, String key) throws Exception {

		if (rootNode == null) {
			throw new Exception("Node not available");
		}

		if (rootNode.getKey().compareTo(key) > 0) {
			return this.getValue(rootNode.getLeftChildNode(), key);

		} else if (rootNode.getKey().compareTo(key) < 0) {
			return this.getValue(rootNode.getRightChildNode(), key);

		}
		return rootNode;
	}

	/**
	 * This method returns sorted-list of nodes in binary search tree
	 * @return sorted array containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	public Node[] getSortedNode() throws Exception{

		if(this.rootNode == null){
			throw new Exception("Empty BST");
		}
		
		ArrayList<Node> sortedNodesList = new ArrayList<Node>();
		sortedNodesList = getSortedNode(this.rootNode, sortedNodesList);
		Object objArr[] = sortedNodesList.toArray();
		Node[] sortedNodes = Arrays.copyOf(objArr, objArr.length, Node[].class);
		
		return sortedNodes;
	}

	private ArrayList<Node> getSortedNode(Node rootNode, ArrayList<Node> sortedNodesList) {

		if (rootNode.leftChildNode == null && rootNode.rightChildNode == null) {
			sortedNodesList.add(rootNode);
			
		} else if(rootNode.leftChildNode != null && rootNode.rightChildNode == null) {
			getSortedNode(rootNode.leftChildNode, sortedNodesList);
			sortedNodesList.add(rootNode);
			
		} else if(rootNode.rightChildNode != null && rootNode.leftChildNode == null) {
			sortedNodesList.add(rootNode);
			getSortedNode(rootNode.rightChildNode, sortedNodesList);
			
		} else {
			getSortedNode(rootNode.leftChildNode, sortedNodesList);
			sortedNodesList.add(rootNode);
			getSortedNode(rootNode.rightChildNode, sortedNodesList);
		}
		
		return sortedNodesList;
	}

	/**
	 * This method returns sorted-list of nodes in binary search tree between given two keys
	 * @param firstKey is String type key from which all key should be greater
	 * @param secondKey is String type key form which all key should be smaller
	 * @return sorted array containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	public Node[] getSortedNode(String firstKey, String secondKey) throws Exception{

		if(this.rootNode == null){
			throw new Exception("Empty BST");
		}
		
		ArrayList<Node> sortedNodesList = new ArrayList<Node>();
		sortedNodesList = getSortedNode(this.rootNode, firstKey, secondKey, sortedNodesList);
		Object objArr[] = sortedNodesList.toArray();
		Node[] sortedNodes = Arrays.copyOf(objArr, objArr.length, Node[].class);
		return sortedNodes;
	}

	private ArrayList<Node> getSortedNode(Node rootNode, String firstKey, String secondKey, ArrayList<Node> sortedNodesList) {

		if (rootNode.leftChildNode == null && rootNode.rightChildNode == null) {
			if ((rootNode.getKey().compareTo(firstKey) >= 0) && (rootNode.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(rootNode);
			}

		} else if(rootNode.leftChildNode != null && rootNode.rightChildNode == null){
			getSortedNode(rootNode.leftChildNode, firstKey, secondKey, sortedNodesList);
			if (compareWithKeys(rootNode.getKey(), firstKey, secondKey)) {
				sortedNodesList.add(rootNode);
			}
			
		} else if(rootNode.rightChildNode != null && rootNode.leftChildNode == null){
			if (compareWithKeys(rootNode.getKey(), firstKey, secondKey)) {
				sortedNodesList.add(rootNode);
			}
			getSortedNode(rootNode.rightChildNode, firstKey, secondKey, sortedNodesList);
			
		} else {
			getSortedNode(rootNode.leftChildNode, firstKey, secondKey, sortedNodesList);
			if (compareWithKeys(rootNode.getKey(), firstKey, secondKey)) {
				sortedNodesList.add(rootNode);
			}
			getSortedNode(rootNode.rightChildNode, firstKey, secondKey, sortedNodesList);
			
		}
		
		return sortedNodesList;
	}
	
	/**
	 * Helper Method to check if the node.key is greater than the first key and smaller than the second key
	 * @param key is the String type key from which all key should be greater
	 * @param firstKey is the String type key which needs to be checked
	 * @param secondKey is the String type key from which all key should be smaller
	 * @return true if condition is valid else return false
	 */
	private boolean compareWithKeys(String key, String firstKey, String secondKey) {
		if ((key.compareTo(firstKey) >= 0) && (key.compareTo(secondKey) <= 0)) {
			return true;
		} else {
			return false;
		}
	}
}
