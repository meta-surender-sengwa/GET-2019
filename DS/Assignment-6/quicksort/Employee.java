package quicksort;

public class Employee {

	private int empId;
	private String empName;
	private String empAdress;
	private double empSalary;
	private double empAge;

	/**
	 * Parameterized constructor used to initialize employee id, name, address, salary and age
	 * @param empId is integer value used to represent unique id for employee
	 * @param empName is String value used to represent employee name
	 * @param empAdress is String value used to represent employee address
	 * @param empSalary is double value used to represent employee salary
	 * @param empAge is double value used to represent employee age
	 */
	public Employee(int empId, String empName, String empAdress, double empSalary, double empAge) {

		this.empId = empId;
		this.empName = empName;
		this.empAdress = empAdress;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAdress() {
		return empAdress;
	}

	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public double getEmpAge() {
		return empAge;
	}

	public void setEmpAge(double empAge) {
		this.empAge = empAge;
	}
}
