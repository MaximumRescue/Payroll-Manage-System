import java.util.*;
/**
 * 描述部门信息的类
 * @version 1.10 2018-06-27
 * @author Jiamin Pan
 */
public class Department {
    private String Did;
    private String Dname;
    private ArrayList<Employee> employeeList;

    // constructor
    public Department(String Did, String Dname) {
        this.setDid(Did);
        this.setDname(Dname);
        this.employeeList = new ArrayList<>();
    }

    /**
	 * @return the did
	 */
	public String getDid() {
		return Did;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return Dname;
	}

	/**
	 * @param dname the dname to set
	 */
	public void setDname(String dname) {
		this.Dname = dname;
	}

	/**
	 * @return the employee list
	 */
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	// 下面的这些方法需要重新编写加上异常处理的部分
    public void addEmployee(Employee e) {
		e.setDname(this.Dname);
		this.employeeList.add(e);
    }

    public void delEmployee(Employee e) {
        this.employeeList.remove(e);
    }
}