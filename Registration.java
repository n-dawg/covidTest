package covidTest;

public class Registration {

	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private boolean hasCOVID;
	private int idNumber;
	
	public Registration(String fn, String ln, String email, long num, boolean hasCOVID, int id) {
		firstName = fn;
		lastName = ln;
		this.email = email;
		phoneNumber = num;
		this.hasCOVID = hasCOVID;
		idNumber = id;

	}
	
	public String getFN() {
		return firstName;
	}
	
	public String getLN() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public long getNum() {
		return phoneNumber;
	}
	
	public boolean hasCOVID() {
		return hasCOVID;
	}
	
	public int getID() {
		return idNumber;
	}
}
