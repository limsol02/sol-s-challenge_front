package frontweb.vo;

public class Employee {
	private int employee_id;
	private String first_name;
	private String email;
	private double salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int employee_id, String first_name, String email, double salary) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.email = email;
		this.salary = salary;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
