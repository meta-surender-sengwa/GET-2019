package employee;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.LinkedList;

public class TestEmployeeOperation {

	@Test
	public void getSortedList() {

		try {
			Employee emp1 = new Employee(1, "bhpendra", "jaipur", 20000, 22);
			Employee emp2 = new Employee(2, "sabir", "chittorgarh", 20000, 21);
			Employee emp3 = new Employee(3, "rivak", "surat", 25000, 20);
			Employee emp4 = new Employee(4, "vinay", "kota", 30000, 22);
			Employee emp5 = new Employee(5, "vinod", "jaipur", 40000, 23);

			EmployeeOperation empOperation = new EmployeeOperation();
			
			empOperation.addEmployee(emp1);
			empOperation.addEmployee(emp2);
			empOperation.addEmployee(emp3);
			empOperation.addEmployee(emp4);
			empOperation.addEmployee(emp5);

			LinkedList<Employee> actualList = empOperation.getSortedList();
			LinkedList<Employee> expectedList = new LinkedList<Employee>();
			
			expectedList.add(emp5);
			expectedList.add(emp4);
			expectedList.add(emp3);
			expectedList.add(emp1);
			expectedList.add(emp2);

			for (int index = 0; index < expectedList.size(); index++) {
				assertTrue(expectedList.get(0).getName().equalsIgnoreCase(actualList.get(0).getName()));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
