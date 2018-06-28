import java.util.*;
/**
 * 用于描述管理员信息的类
 * @version 1.01 2018-06-28
 * @author Jiamin Pan
 */
public class Administrator {
	private int adminID;
	private String password;
	private String username;

    /** 
     * constructor 
	 * @param adminID administrator's ID
     * @param password administrator's password
    */
    public Administrator(int adminID, String password) {
		this.setAdminID(adminID);
		this.setPassword(password);
		this.username = null;
    }	

	/**
	 * @return the adminID
	 */
	public int getAdminID() {
		return adminID;
	}


	/**
	 * @param adminID the adminID to set
	 */
	private void setAdminID(int adminID) {
		this.adminID = adminID;
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
}