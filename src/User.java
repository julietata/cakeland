
public class User {

	private String userID;
	private String userName;
	private String userEmail;
	private String userPass;
	private String userGender;
	private String userDOB;
	private String phoneNumber;
	private String userAddress;
	private String userRole;
	
	public User(String userID, String userName, String userEmail, String userPass, String userGender, String userDOB,
			String phoneNumber, String userAddress, String userRole) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPass = userPass;
		this.userGender = userGender;
		this.userDOB = userDOB;
		this.phoneNumber = phoneNumber;
		this.userAddress = userAddress;
		this.userRole = userRole;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(String userDOB) {
		this.userDOB = userDOB;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
