package bLogic;

public class Admin extends Customer {

	private boolean adminCheck;
	
	
	public Admin(boolean adminCheck, String firstName, String lastName, String address, int zip, String state, String username,
			String password, String email, int ssn, String securityQuestion, String securityAnswer) {
		
		super(ssn, securityAnswer, securityAnswer, securityAnswer, ssn, securityAnswer, securityAnswer, securityAnswer, securityAnswer, ssn, securityAnswer, securityAnswer);
		this.adminCheck = adminCheck;
	}
	
	
	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return super.getCity();
	}


	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		super.setCity(city);
	}


	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return super.getID();
	}


	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}


	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}


	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}


	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}


	@Override
	public String getStreet() {
		// TODO Auto-generated method stub
		return super.getStreet();
	}


	@Override
	public void setStreet(String address) {
		// TODO Auto-generated method stub
		super.setStreet(address);
	}


	@Override
	public int getZip() {
		// TODO Auto-generated method stub
		return super.getZip();
	}


	@Override
	public void setZip(int zip) {
		// TODO Auto-generated method stub
		super.setZip(zip);
	}


	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return super.getState();
	}


	@Override
	public void setState(String state) {
		// TODO Auto-generated method stub
		super.setState(state);
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}


	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}


	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}


	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}


	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}


	@Override
	public int getSsn() {
		// TODO Auto-generated method stub
		return super.getSsn();
	}


	@Override
	public void setSsn(int ssn) {
		// TODO Auto-generated method stub
		super.setSsn(ssn);
	}


	@Override
	public String getSecurityQuestion() {
		// TODO Auto-generated method stub
		return super.getSecurityQuestion();
	}


	@Override
	public void setSecurityQuestion(String securityQuestion) {
		// TODO Auto-generated method stub
		super.setSecurityQuestion(securityQuestion);
	}


	@Override
	public String getSecurityAnswer() {
		// TODO Auto-generated method stub
		return super.getSecurityAnswer();
	}


	@Override
	public void setSecurityAnswer(String securityAnswer) {
		// TODO Auto-generated method stub
		super.setSecurityAnswer(securityAnswer);
	}


	@Override
	public int getCustomerID() {
		// TODO Auto-generated method stub
		return super.getCustomerID();
	}


	@Override
	public void setCustomerID(int customerID) {
		// TODO Auto-generated method stub
		super.setCustomerID(customerID);
	}


	public boolean isAdminCheck() {
		return adminCheck;
	}

	public void setAdminCheck(boolean adminCheck) {
		this.adminCheck = adminCheck;
	}
	
	
	public boolean isAdmin(boolean adminCheck) {
		
		if (adminCheck) {
			return true;
		}
		
		else {
			return false;
		}
		
	}

}
