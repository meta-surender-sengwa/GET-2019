package employee;

import java.util.LinkedList;

/**
 * @author Surender
 * This class contains methods to perform operations on employees
 */
public class EmployeeOperation {

	LinkedList<Employee> employeeList = new LinkedList<Employee>();

	
	/**
	 * This method is used to add employee to employee list
	 * @param employee is an object of Employee class containing details of employee
	 * @return true if employee is added successfully else return false
	 */
	public boolean addEmployee(Employee employee) {
		employeeList.add(employee);
		return true;
	}

	/**
	 * This method is used to sort employee according to their salary in descending order
	 * @return LinkedList<Employee> contains all employee's details
	 * @throws Exception when employee list is empty
	 */
	public LinkedList<Employee> getSortedList() throws Exception {

		if (employeeList.size() == 0) {
			throw new Exception("Employee list is empty");
		}

		int employeeIndex;
		for (int index = 1; index < employeeList.size(); index++) {
			
			employeeIndex = 0;
			while (employeeIndex <= index) {
			
				if (employeeList.get(employeeIndex).getSalary() < employeeList.get(index).getSalary()) {
					reArrangeEmployee(employeeIndex, index);
				
				} else if (employeeList.get(employeeIndex).getSalary() == employeeList.get(index).getSalary()) {
					
					if (employeeList.get(employeeIndex).getAge() > employeeList.get(index).getAge()) {
						reArrangeEmployee(employeeIndex, index);
					}
				}
				employeeIndex++;
			}
		}
		return employeeList;
	}

	/**
	 * This method is used to rearrange two employee's position in the list
	 * @param employeeIndex is the new index where employee needs to be added
	 * @param index is the old index where employee currently is
	 */
	private void reArrangeEmployee(int employeeIndex, int index) {

		Employee employee = employeeList.get(index);
		employeeList.remove(index);
		employeeList.add(employeeIndex, employee);
	}
}
