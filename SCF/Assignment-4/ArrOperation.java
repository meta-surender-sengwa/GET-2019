/**
 * @author Surender
 * 	class ArrOperation implements operations on an array like finding largest Mirror Section,
 * 	number of Clumps, index splitting the array into equal Sums, and solving fixXY problem.
 */
public class ArrOperation {
	
	/**
	 * @param array is the input int array in which we have to find the size of the largest Mirror section
	 * @return the size of the largest Mirror section
	 */
	int getSizeOfLargestMirrorSection(int[] array) {
		final int size = array.length;
		if (size == 0) {
			throw new AssertionError("Array is Empty");
		}
		

		int maxCount = 1;
		boolean flag = false;

		for (int i = 0; i < size; i++) {
			int tempCount = 1;
			int count = i;

			for (int j = size - 1; j >= 0 && (count < size); j--) {
				if ((array[count] == array[j]) && !(flag)) {
					flag = true;
					count++;
					continue;
				}
				if ((array[count] == array[j]) && (flag)) {
					tempCount++;
					count++;
					maxCount = (tempCount > maxCount) ? tempCount : maxCount;
					continue;
				}
				if (!(array[i] == array[j]) && (flag)) {
					flag = false;
					count = i;
					tempCount = 1;
					continue;
				}
				if ((j == count) || (j - count) == 1) {
					flag = false;
					break;
				}
			}
		}
		return maxCount;
	}
	
	/**
	 * @param array is the input int array in which we have to find the number of Clumps
	 * @return the number of Clumps
	 */
	int getNumberOfClumps(int[] array) {

		int lengthOfArray = array.length;
		if (lengthOfArray == 0) {
			throw new AssertionError("The array is empty");
		}
		
		int count = 0;

		for (int i = 0; i < lengthOfArray; i++) {
			int j = i + 1;
			if (array[i] == array[j]) {
				count++;
				while ((array[i] == array[j])) {
					if (j == lengthOfArray - 1) {
						break;
					}
					j++;
				}
			}
			i = j - 1;
			if (i == lengthOfArray - 2)
				break;
		}
		return count;
	}
	
	/**
	 * @param array is the input int array in which we have to solve the fixXY problem
	 * @param x is the value of x which is always fixed in the array
	 * @param y is the value of y which should be placed after every occurance of y
	 * @return the array after solving the fixXY problem
	 */
	public int[] solveFixXYProblem(int array[], int X, int Y) {
		int len = array.length;
		if (len == 0) {
			throw new AssertionError("The array is empty");
		}

		boolean flag = false;
		for (int i = 0; i < len - 1; i++) {
			if (array[i] == X && array[i + 1] == X) {
				flag = true;
				break;
			}
		}
		if (flag) {
			throw new AssertionError("The array has two adjacents X values");
		}
		if (array[len - 1] == X) {
			throw new AssertionError(" X occurs at the last index of array");
		}

		int countX = 0, countY = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] == X) {
				countX++;
			}
			if (array[i] == Y) {
				countY++;
			}
		}
		if (countX != countY) {
			throw new AssertionError(
					"there are unequal numbers of X and Y in input array");
		}

		for (int i = 1; i < array.length - 1; i++) {
			if (array[i - 1] == X && array[i] == Y) {
				i++;
				continue;
			}
			if (array[i] == X && array[i - 1] == Y && array[i + 1] != Y) {
				int temp = array[i - 1];
				array[i - 1] = array[i + 1];
				array[i + 1] = temp;
				i += 2;
				continue;

			}
			if (array[i - 1] == X) {
				for (int j = i; j < array.length; j++) {
					if (array[j] == Y) {
						int temp = array[j];
						array[j] = array[i];
						array[i] = temp;
						break;
					}

				}
			}

		}
		return array;
	}
	

	/**
	 * @param array is the input int array in which we have to find the index which splits the array into two equal sums
	 * @return the index which splits the array into two equal sums
	 */
	int getArraySplittingIndex(int array[]) {
		int lengthOfArray = array.length;
		if (lengthOfArray == 0) {
			throw new AssertionError("The array is empty");
		}

		int leftSum = 0;
		for (int i = 0; i < lengthOfArray; i++) {
			leftSum += array[i];

			int rightSum = 0;
			for (int j = i + 1; j < lengthOfArray; j++) {
				rightSum += array[j];
			}

			if (leftSum == rightSum) {
				return i + 1;
			}
		}

		return -1;
	}
	
}


