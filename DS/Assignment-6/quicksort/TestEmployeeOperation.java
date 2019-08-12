package quicksort;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

public class TestEmployeeOperation {

	@Test
	public void test() {
		try {
			
			Employee emp1 = new Employee(1, "surender", "nagaur", 30000, 21);
			Employee emp2 = new Employee(2, "vinay", "kota", 20000, 22);
			Employee emp3 = new Employee(3, "bhupendra", "jaipur", 25000, 22);
			Employee emp4 = new Employee(4, "rivak", "ahemdabad", 30000, 22);
			Employee emp5 = new Employee(5, "vinod", "jaipur", 25000, 23);

			EmployeeOperation empOperation = new EmployeeOperation();
			empOperation.addEmployee(emp1);
			empOperation.addEmployee(emp2);
			empOperation.addEmployee(emp3);
			empOperation.addEmployee(emp4);
			empOperation.addEmployee(emp5);

			LinkedList<Employee> expectedList = new LinkedList<Employee>();
			expectedList.add(emp1);
			expectedList.add(emp4);
			expectedList.add(emp3);
			expectedList.add(emp5);
			expectedList.add(emp2);

			LinkedList<Employee> actualList = empOperation .getSortedEmployeeList();

			for (int empIndex = 0; empIndex < expectedList.size(); empIndex++) {
				assertTrue(expectedList.get(0).getEmpName().equalsIgnoreCase(actualList.get(0).getEmpName()));
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
