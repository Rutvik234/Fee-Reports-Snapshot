package FeeReports;

class Accountant {
	private int id;
	private String fiestName;
	private String lastName;
	private String password;
	private String email;
	private Long contactNumber;

	public Accountant(int id, String fiestName, String lastName, String password, String email, Long contactNumber) {
		super();
		this.id = id;
		this.fiestName = fiestName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFiestName() {
		return fiestName;
	}

	public void setFiestName(String fiestName) {
		this.fiestName = fiestName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Accountant [id=" + id + ", fiestName=" + fiestName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", contactNumber=" + contactNumber + "]";
	}
}