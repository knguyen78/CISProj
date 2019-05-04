package bLogic;

public class Admin extends Customer {

	private boolean adminCheck;
	
	
	public Admin(boolean adminCheck, String firstName, String lastName, String address, int zip, String state, String username,
			String password, String email, int ssn, String securityQuestion, String securityAnswer) {
		
		super(securityAnswer, securityAnswer, securityAnswer, ssn, securityAnswer, securityAnswer, securityAnswer, securityAnswer, ssn, securityAnswer, securityAnswer);
		this.adminCheck = adminCheck;
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
