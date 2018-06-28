import java.util.*;
/**
 * 用于描述管理员信息的类
 * @version 1.00 2018-06-28
 * @author Jiamin Pan
 */
public class Administrator {
	private int adminID;
	private String password;
	private String username;
	private String phoneNumber;
	private String emailAddress;

    /** 
     * constructor 
	 * @param adminID administrator's ID
     * @param password administrator's password
    */
    public Administrator(int adminID, String password) {
		this.adminID = adminID;
        this.setPassword(password);
    }

	/**
	 * @return the adminID
	 */
	public int getAdminID() {
		return adminID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}