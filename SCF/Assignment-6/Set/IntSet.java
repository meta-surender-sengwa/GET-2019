/**
 * @author Surender
 * @class IntSet Have following methods for sets- isMember, sizeOfSet, isSubSet, getComplement, getUnion
 * 		class is Immutable 
 */
public final class IntSet {
	private int set[];
	
	/**
	 * Constructor  to initialize the set array
	 * @param setArray is one dimensional array
	 */
	IntSet(int setArray[]){
		this.set = setArray;
	}
	
	/**
	 * @return set array
	 */
	public int[] getSet() {
		return set;
	}
	
	/**
	 * function find if a number is present in the set or not
	 * @param number is the key which needs to be searched
	 * @return true if found else false
	 */
	public boolean isMemberOfSet(int number) {
		for (int index = 0; index < this.getSet().length; index++) {
			if(number  == this.getSet()[index]){
				return true;
			}
		}
		return  false;
	}
	
	/**
	 * this function is used to get the size of array
	 * @return size of the set
	 */
	public int sizeOfSet() {
		int size = 0;
		for (int index = 0; index < set.length; index++) {
			size = size + 1;
		}
		return size-1;
	}

	/**
	 * this function checks if  the parameter array is subset of set
	 * @param subSet is the sunSet array which needs to be checked
	 * @return true if it is subset else false
	 */
	public boolean isSubSetOfSet(int[] subSet) {
		if (subSet.length == 0) {
			return true;
		} else {
			int selector = 0;
			int counter = this.getSet().length - 1;
			while (selector != subSet.length) {
				if (subSet[selector] != this.getSet()[counter]) {
					if (counter != 0) { 
						counter = counter - 1;
					} else {
						break; 
					}
				} else {
					counter =  this.getSet().length - 1;
					selector = selector + 1;
				}
			}
			if (selector == subSet.length) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * 
	 * @param subSet give the subset element array in function which give complement of the set
	 * the element present in the subset are remain and not present are return
	 * @return int array is return int this
	 */
	public int[] complementOfSet(int[] subSet) {

		int complementSet[] = new int[this.getSet().length - subSet.length];
		if (subSet.length == 0) {
			return this.getSet();
		} else {
			int selector = 0; 
			int counter = set.length - 1;
			while (selector != subSet.length) {
				if (subSet[selector] != set[counter]) {
					if (counter != -1) { 
						counter = counter - 1;

					}
				} else {
					set[counter] = -1;
					counter = set.length - 1; 
					selector = selector + 1;
				}
			}
			int counter1 = 0;
			for (int i = 0; i < set.length; i++) {

				if (set[i] != -1) {
					complementSet[counter1] = set[i];
					counter1 = counter1 + 1;
				}
			}
		}
		
		return complementSet;
	}

	public int[] unionOfSets(int set1[] , int[] set2) {
		int selector = 0;
		int nonZeroNumbers = 0;
		
		int unionSet[] = new int[set1.length + set2.length];
		for (int index = 0; index < set1.length; index++) {
			unionSet[index] = set1[index];
		}
		
		int count = 0;
		while (set2.length != count) {
			if (unionSet[selector] != set2[count]) {
				selector = selector + 1;
				if (selector == unionSet.length - 1) {
					unionSet[set1.length + count] = set2[count];
					count = count + 1;
					selector = 0;
				}
			} else {
				count = count + 1;
				selector = 0;
			}
		}
		for (int i = 0; i < unionSet.length; i++) {
			if (unionSet[i] != 0) {
				nonZeroNumbers = nonZeroNumbers + 1;
			}
		}
		int unionSet1[] = new int[nonZeroNumbers];
		int count2 = 0;
		for (int index = 0; index < unionSet.length; index++) {
			if (unionSet[index] != 0) {
				unionSet1[count2] = unionSet[index];
				count2++;
			}
		}
		return unionSet1;
	}

}
