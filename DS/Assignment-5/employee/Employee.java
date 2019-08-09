package employee;

/**
 * @author Surender
 * This class represents employee
 */
public class Employee {

	private int empId;
	private String name;
	private String address;
	private double salary;
	private double age;

	/**
	 * Constructor used to initialize employee id, name, address, salary amd age
	 * @param empId is integer value representing unique id for employee
	 * @param name is String value representing employee name
	 * @param Address is String value representing employee address
	 * @param salary is double value representing employee salary
	 * @param age is double value representing employee age
	 */
	public Employee(int empId, String name, String address, double salary, double age) {

		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.age = age;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String Address) {
		this.address = Address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}
}
