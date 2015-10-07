package classes;

public class Employees {
	String firstName;
	String lastName;
	String title;
	String speciality;
	Double salary;
	
	//Default Constructor....
	public Employees() {
		super();
	}
	
	//Constructor using fields....
	public Employees(String firstName, String lastName, String title,
			String speciality, Double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.speciality = speciality;
		this.salary = salary;
	}
	
	//Here are the getter and setters....
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName
				+ ", title=" + title + ", speciality=" + speciality
				+ ", salary=" + salary + "]";
	}
	
}
