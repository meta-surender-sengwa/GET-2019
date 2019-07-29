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
	 * @param array[] is the array on which the binary search is to be implemented
	 * @param numberToSearch is the key which needs to be searched in the array array[] 
	 * @param leftIndex is the left index of the array being used for searching
	 * @param right Index is the right index of the array being used for searching
	 * @return the index where the key is found else it returns -1 
	 */
	public int binarySearch(int[] array, int numberToSearch) {
		int leftIndex = 0;
		int rightIndex = array.length;
		return calculation(array, numberToSearch, leftIndex, rightIndex);
	}
	
	private int calculation(int[] array, int numberToSearch, int leftIndex, int rightIndex) {
		int mid;
		if (leftIndex < rightIndex) {
			mid = (rightIndex + leftIndex) / 2;
			if (array[mid] == numberToSearch) {
				return mid;
			}
			
			if (array[mid] > numberToSearch) {
				return calculation(array, numberToSearch, leftIndex, mid);
			}

			if (array[mid] < numberToSearch) {
				return calculation(array, numberToSearch, mid + 1, rightIndex);
			}
		}
		return -1;
	}
	
	
	/*
	private int flag2 = 0;
	private int leftIndex, rightIndex, mid;
	public int binarySearch(int[] array, int numberToSearch) {
		if(flag2 == 0) {
			leftIndex = 0;
			rightIndex = array.length;
			flag2 ++;
		}
		
		if (leftIndex < rightIndex) {
			mid = (rightIndex + leftIndex) / 2;
			if (array[mid] == numberToSearch) {
				return mid;
			}
			
			if (array[mid] > numberToSearch) {
				int[] newArray = new int[mid];
				for(int index = 0; index < mid; index++) {
					newArray[index] = array[index];
				}
				return binarySearch(newArray, numberToSearch);
			}
		
			if (array[mid] < numberToSearch) {
				int[] newArray = new int[(rightIndex - mid)];
				int counter = 0;  
				for(int index = 0 ; index <= (rightIndex - mid) ; index++) {
					newArray[index] = array[index+mid+1];
					counter ++;
				}
				return binarySearch(newArray, numberToSearch);
			}
		}
		return -1;
	}
	*/
}


