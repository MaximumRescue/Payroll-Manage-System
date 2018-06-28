import java.util.*;
/**
 * 描述部门信息的类
 * @version 1.11 2018-06-28
 * @author Jiamin Pan
 */
public class Department {
    private String departID;
    private String departName;
    private ArrayList<Employee> employeeList;

    /** 
	 * constructor 
	 * @param departID department's id
	 * @param departName department's name
	 */
    public Department(String departID, String departName) {
        this.departID = departID;
        this.setDepartName(departName);
        this.employeeList = new ArrayList<>();
    }

    /**
	 * @return the department's ID
	 */
	public String getDepartID() {
		return departID;
	}

	/**
	 * @return the departName
	 */
	public String getDepartName() {
		return departName;
	}

	/**
	 * @param departName the departName to set
	 */
	public void setDepartName(String departName) {
		this.departName = departName;
	}

	/**
	 * @return the employee list
	 */
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * add the employee to the list
	 * @param e the employee to add
	 */
    public void addEmployee(Employee e) {
		e.setDepartName(this.departName);
		this.employeeList.add(e);
    }

	/**
	 * remove the employee from the list
	 * @param e the employee to remove
	 */
    public void delEmployee(Employee e) {
        this.employeeList.remove(e);
    }
}