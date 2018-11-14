package by.iba.professor.common;

public class Professor {
	
	private String id;
	
	private String firstName;
	
	private String secondName;
	
	private String fatherName;
	
	private String birthDate;
	
	private double averegeMark;

	public Professor() {
		super();
	}

	public Professor(String firstName, String secondName, String fatherName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.fatherName = fatherName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	

}
