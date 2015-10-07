package classes;

public class Patient {
	String firstName;
	String lastName;
	String dateOfVist;
	String complaint;
	String disease;
	
	//Default constructor.
	public Patient() {
		super();
	}
	
	//Constructor without disease. Not every patient has a disease.
	public Patient(String firstName, String lastName, String dateOfVist,
			String complaint) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfVist = dateOfVist;
		this.complaint = complaint;
	}
	
	//Constructor with disease. If you know they have a disease then use this constructor.
	public Patient(String firstName, String lastName, String dateOfVist,
			String complaint, String disease) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfVist = dateOfVist;
		this.complaint = complaint;
		this.disease = disease;
	}
	
	//Here are the getters and setters for patient.
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

	public String getDateOfVist() {
		return dateOfVist;
	}

	public void setDateOfVist(String dateOfVist) {
		this.dateOfVist = dateOfVist;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "[firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfVist=" + dateOfVist + ", complaint=" + complaint
				+ ", disease=" + disease + "]";
	}
	  
}
