package quicksort;

import java.util.LinkedList;

public class EmployeeOperation {

	LinkedList<Employee> list = new LinkedList<Employee>();

	/**
	 * This method is use to add employee to employee-list
	 * @param employee is the object of Employee class containing details of employee to be added
	 * @return true if added successfully else return false
	 */
	public boolean addEmployee(Employee employee) {
		
		list.add(employee);
		return true;
	}

	/**
	 * This method is use to sort employee according to their salary in descending order
	 * @return LinkedList<Employee> containing all employee details
	 * @throws Exception when employee list is empty
	 */
	public LinkedList<Employee> getSortedEmployeeList() throws Exception {
		
		if (list.isEmpty()) {
			throw new Exception("Employee list empty");
		}
		return quickSort(list, 0, list.size()-1);
	}
	
	/**
	 * This method is use to sort the employee list using quick sort on their salary
	 * @param list LinkedList<Employee> containing all employee details
	 * @param startIndex start index of list
	 * @param endIndex end index of list
	 * @return LinkedList<Employee> containing sorted employee according to salary
	 */
	private LinkedList<Employee> quickSort(LinkedList<Employee> list,int startIndex, int endIndex) {
	
		if (startIndex >= endIndex) {
			return list;
		}
		
		int pivotIndex = endIndex;
		int currentIndex = endIndex - 1;

		while (currentIndex >= startIndex) {

			if (list.get(currentIndex).getEmpSalary() < list .get(pivotIndex).getEmpSalary()) {
				arrangeEmployeePosition(currentIndex, pivotIndex);
				pivotIndex = currentIndex;

			} else if (list.get(currentIndex).getEmpSalary() == list.get(pivotIndex).getEmpSalary()) {

				if (list.get(currentIndex).getEmpAge() > list.get(pivotIndex).getEmpAge()) {
					arrangeEmployeePosition(currentIndex, pivotIndex);
					pivotIndex = currentIndex;
				}
			}
			currentIndex--;
		}

		list = quickSort(list, startIndex, pivotIndex - 1);
		list = quickSort(list, pivotIndex + 1, endIndex);
		
		return list;

	}

	/**
	 * Method to rearrange employee position in the employee-list
	 * @param firstIndex is the new index of employee
	 * @param secondIndex is the old index of employee
	 */
	private void arrangeEmployeePosition(int firstIndex, int secondIndex) {

		Employee employee = list.get(secondIndex);
		list.remove(secondIndex);
		list.add(firstIndex, employee);
	}
}
