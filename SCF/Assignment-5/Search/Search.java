/**
 * @author Surender
 *  	class Search implements linear search and binary search of any number
 *  	on an array of positive integers 
 */
public class Search {
	private int flag = 0;
	private int sizeOfArray = 0;

	/**
	 * @param array[] is the array on which the linear search is to be implemented
	 * @param numberToSearch is the key which needs to be searched in the array array[] 
	 * @return the index where the key is found else it returns -1 
	 */
	int linearSearch(int array[], int numberToSearch) {
		if (flag == 0) {
			sizeOfArray = array.length - 1;
			flag = 1;
		}
		if (sizeOfArray == -1) {
			return -1;
		} else if (array[sizeOfArray] == numberToSearch) {
			return sizeOfArray;
		} else {
			sizeOfArray = sizeOfArray - 1;
		return linearSearch(array, numberToSearch);
		}
	}

	/**
	 * @param array[] is the array on which the linear search is to be implemented
	 * @param numberToSearch is the key which needs to be searched in the array array[] 
	 * @return the index where the key is found else it returns -1  
	 * 		(by calling another function binarySearch providing the left and right index used for searching)
	 */
	public int setBoundayIndex(int array[], int numberToSearch) {
		int leftIndex = 0;
		int rightIndex = array.length;
		return binarySearch(array, numberToSearch, leftIndex, rightIndex);
	}

	/**
	 * @param array[] is the array on which the binary search is to be implemented
	 * @param numberToSearch is the key which needs to be searched in the array array[] 
	 * @param leftIndex is the left index of the array being used for searching
	 * @param right Index is the right index of the array being used for searching
	 * @return the index where the key is found else it returns -1 
	 */
	private int binarySearch(int[] array, int numberToSearch, int leftIndex, int rightIndex) {
		
		if (leftIndex < rightIndex) {
			int mid = (rightIndex + leftIndex) / 2;
			if (array[mid] == numberToSearch) {
				return mid;
			}

			if (array[mid] > numberToSearch) {
				return binarySearch(array, numberToSearch, leftIndex, rightIndex - 1);
			}

			if (array[mid] < numberToSearch) {
				return binarySearch(array, numberToSearch, leftIndex + 1, rightIndex);
			}
		}
		return -1;
	}

}


