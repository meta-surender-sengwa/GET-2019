package dictionary;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Surender
 * This class represent binary search tree data structure
 */
public class BinarySearchTree {

	public Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	/**
	 * Method to add key-value pair to binary search tree
	 * @param Node is an object of node class which need to be added
	 * @return true if node is added else return false
	 * @throws Exception if node key is already present
	 */
	public boolean add(Node node) throws Exception {
		this.root = add(this.root, node);
		return true;
	}

	/**
	 * Method to add key value pair to binary search tree
	 * @param root root node of binary search tree
	 * @param node object of Node class which need to be added
	 * @return root after addition
	 * @throws Exception if node is already present
	 */
	private Node add(Node root, Node node) throws Exception {
		
		if (root == null) {
			root = node;
			return root;
		}

		if (node.getKey().compareTo(root.getKey()) < 0) {
			root.leftChild = this.add(root.leftChild, node);
			
		} else if (node.getKey().compareTo(root.getKey()) > 0) {
			root.rightChild = this.add(root.rightChild, node);
			
		} else {
			throw new Exception("Node already Present");
		}
		
		return root;
	}

	/**
	 * Method to delete node for given key 
	 * @param key is key for which node needs to be deleted
	 * @return true if node is deleted else return false
	 * @throws Exception if binary search tree is empty or key not found
	 */
	public boolean delete(String key)throws Exception {

		if (this.root == null) {
			throw new Exception("BinarySearchTree is empty");
		}
		this.root = delete(this.root, key);

		return true;
	}

	/**
	 * Method to delete node for given key 
	 * @param root is the root node of binary search tree
	 * @param key is key for which node needs to be deleted
	 * @return root of binary search tree
	 * @throws Exception if binary search tree is empty or key not found
	 */
	private Node delete(Node root,String key) throws Exception {
		
        if (root == null){
        	throw new Exception("Key not found");
        }

        if (root.getKey().compareTo(key) > 0) {
        	root.leftChild = delete(root.leftChild, key); 
        } else if (root.getKey().compareTo(key) < 0) { 
        	root.rightChild = delete(root.rightChild, key); 
        } else { 
            // node with only one child or no child 
            if (root.leftChild == null){  return root.rightChild; }  
            else if (root.rightChild == null){ return root.leftChild; }
               
            //node with two children get the in-order successor (smallest in the right subtree) 
            Node minNode = getMinimumNode(root.rightChild); 
  
            //Delete the in-order successor 
            root.rightChild = delete(root.rightChild, minNode.getKey()); 
            //changing left and right node references 
            minNode.leftChild = root.leftChild;
            minNode.rightChild = root.rightChild;
            root = minNode;
        } 
        return root; 
	}
	
	/**
	 * Method to return the node with minimum key value
	 * @param node is the starting node in binary search tree
	 * @return the node with minimum key value
	 */
	private Node getMinimumNode(Node node){
		
		Node minNode = node;
        while (minNode.leftChild != null) { 
            minNode = minNode.leftChild; 
        } 
        return minNode; 
	}
	
	/**
	 * Method to return node for given key
	 * @param key String type key for which node need to be find
	 * @return node for the given key
	 * @throws Exception if key not found
	 */
	public Node get(String key) throws Exception {
		return get(this.root, key);
	}

	/**
	 * This method return node for given key
	 * @param key String type key for which node need to be find
	 * @return node for the given key
	 * @throws Exception if key not found
	 */
	private Node get(Node root, String key) throws Exception {
		if (root == null) {
			throw new Exception("Node not available");
		}
		
		if (root.getKey().compareTo(key) > 0) {
			return this.get(root.getLeftChild(), key);
			
		} else if (root.getKey().compareTo(key) < 0) {
			return this.get(root.getRightChild(), key);
		}
		return root;
	}

	/**
	 * Method to return sorted list of nodes in binary search tree
	 * @return sorted array containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	public Node[] getSortedNode() throws Exception {

		if(this.root == null){
			throw new Exception("Empty BinarySearchTree");
		}
		
		ArrayList<Node> sortedNodesList = new ArrayList<Node>();
		sortedNodesList = getSortedNode(this.root, sortedNodesList);
		
		Object objArr[] = sortedNodesList.toArray();
		Node[] sortedNodes = Arrays.copyOf(objArr, objArr.length, Node[].class);
		
		return sortedNodes;
	}

	/**
	 * Method to return sorted list of nodes in binary search tree
	 * @return sorted ArrayList<Node> containing node
	 */
	private ArrayList<Node> getSortedNode(Node root, ArrayList<Node> sortedNodesList) {

		if (root.leftChild == null && root.rightChild == null) {
			sortedNodesList.add(root);
			
		} else if(root.leftChild != null && root.rightChild == null) {
			getSortedNode(root.leftChild, sortedNodesList);
			sortedNodesList.add(root);
			
		} else if(root.rightChild != null && root.leftChild == null) {
			sortedNodesList.add(root);
			getSortedNode(root.rightChild, sortedNodesList);
			
		} else {
			getSortedNode(root.leftChild, sortedNodesList);
			sortedNodesList.add(root);
			getSortedNode(root.rightChild, sortedNodesList);
			
		}
		return sortedNodesList;
	}

	/**
	 * Method to return sorted list of nodes in binary search tree between given two keys
	 * @param firstKey String type key from which all key should be greater or equal
	 * @param secondKey String type key form which all key should be smaller or equal
	 * @return sorted array containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	public Node[] getSortedNode(String firstKey, String secondKey) throws Exception{

		if(this.root == null){
			throw new Exception("Empty BinarySearchTree");
		}
		
		ArrayList<Node> sortedNodesList = new ArrayList<Node>();
		sortedNodesList = getSortedNode(this.root, firstKey, secondKey, sortedNodesList);
		
		Object objArr[] = sortedNodesList.toArray();
		Node[] sortedNodes = Arrays.copyOf(objArr, objArr.length, Node[].class);
		
		return sortedNodes;
	}

	/**
	 * Method to return sorted list of nodes in binary search tree between given two keys
	 * @param firstKey String type key from which all key should be greater or equal
	 * @param secondKey String type key form which all key should be smaller or equal
	 * @return sorted ArrayList<Node> containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	private ArrayList<Node> getSortedNode(Node root, String firstKey, String secondKey,
			ArrayList<Node> sortedNodesList) {

		if (root.leftChild == null && root.rightChild == null) {
			if ((root.getKey().compareTo(firstKey) >= 0) && (root.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(root);
			}

		} else if(root.leftChild != null && root.rightChild == null){
			getSortedNode(root.leftChild, firstKey, secondKey, sortedNodesList);
			if ((root.getKey().compareTo(firstKey) >= 0) && (root.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(root);
			}
			
		} else if(root.rightChild != null && root.leftChild == null){
			if ((root.getKey().compareTo(firstKey) >= 0) && (root.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(root);
			}
			getSortedNode(root.rightChild, firstKey, secondKey, sortedNodesList);
			
		} else {
			getSortedNode(root.leftChild, firstKey, secondKey, sortedNodesList);
			if ((root.getKey().compareTo(firstKey) >= 0) && (root.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(root);
			}
			getSortedNode(root.rightChild, firstKey, secondKey, sortedNodesList);
			
		}
		return sortedNodesList;
	}
}
