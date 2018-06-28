import java.util.*;
import java.sql.*;
/**
 * 描述员工和数据库中每一列之间的对应关系的类
 * 假定数据库中的表为employeeTable(EmployeeID, EmployeeName, EmployeePW, 
 * DepartName, BasicSalary, ExtraSalary, 
 * SickoffDays, BusiOffDays, LateDays, OvertimeDays)
 * @version 1.00 2018-06-28
 * @author Jiamin Pan
 */
public class EmployeeDB {
    static Connection conn;
    static Statement stat;

    /**
     * get connection with database
     * @return the connection
     */
    private static Connection getConnection() throws SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/employeeTable";
        // 自己填好数据库的用户名和密码
        String username = null;
        String password = null;
        conn = DriverManager.getConnection(url, username, password);
        stat = conn.createStatement();
        return conn;
    }

    /**
     * close the connection to database
     */
    private static void closeConnection() throws SQLException {
        stat.close();
        conn.close();
    }

    /**
     * find whether there exists this admin then login
     * @param username the username from input
     * @param password the password from input
     * @return result whether we find the admin
     */
    public static boolean isExisted(String username, String password) 
        throws SQLException {
        String sql = "select * from adminTable where username = '" 
            + username + "' and password = '" + password + "'";
        ResultSet rs = stat.executeQuery(sql);
        boolean result = rs.next();
        rs.close();
        return result;
    }

    /**
     * find whether there exists this admin
     * @param username the username from input
     * @return result whether we find the admin
     */
    public static Employee findAdmin(String username) throws SQLException {
        String sql = "select * from adminTable where username = '" 
            + username + "'";
        ResultSet rs = stat.executeQuery(sql);
        boolean result = rs.next();
        if (result) {
            String employeeID = rs.getString(1);
            String employeeName = rs.getString(2);
            String employeePW = rs.getString(3);
            Employee e = new Employee(employeeID, employeeName, employeePW);
            e.setDepartName(rs.getString(4));
            e.setBasicSalary(rs.getInt(5));
            e.setExtraSalary(rs.getInt(6));
            e.setSickOffDays(rs.getInt(7));
            e.setBusyOffDays(rs.getInt(8));
            e.setLateDays(rs.getInt(9));
            e.setOvertimeDays(rs.getInt(10));
            rs.close();
            return e;
        }
        else {
            System.out.println("不存在该员工！");
            return null;
        }
    }

    /**
     * add a new employee to table
     * @param newEmployee the employee to be added
     */
    public static void addEmployee(Employee newEmployee) throws SQLException {
        // get infomation about new employee
        String employeeID = newEmployee.getEmployeeID();
        String employeeName = newEmployee.getEmployeeName();
        String employeePW = newEmployee.getEmployeePW();
        String departmentName = newEmployee.getDepartName();
        String basicSalary = String.valueOf(newEmployee.getBasicSalary());
        String extraSalary = String.valueOf(newEmployee.getExtraSalary());
        String sickoffDays = String.valueOf(newEmployee.getSickOffDays());
        String busyoffDays = String.valueOf(newEmployee.getBusyOffDays());
        String lateDays = String.valueOf(newEmployee.getLateDays());
        String overtimeDays = String.valueOf(newEmployee.getOvertimeDays());

        String sql = "insert * into employeeTable (EmployeeID, EmployeeName, " 
            + "EmployeePW, DepartName, BasicSalary, ExtraSalary, " 
            + "SickoffDays, BusiOffDays, LateDays, OvertimeDays) " 
            + "values ('" + employeeID + "','" + employeeName + "','" 
            + employeePW + "'," + departmentName + "," + basicSalary + ","
            + extraSalary + "," + sickoffDays + "," + busyoffDays + ","
            + lateDays + "," + overtimeDays + "')";
        if (!isExisted(employeeName, employeePW)) {
            int result = stat.executeUpdate(sql);
        }
        else {
            System.out.println("This employee exists!!!");
        }
    }

    /**
     * delete an employee to table
     * @param oldEmployee the employee to be deleted
     */
    public static void delEmployee(Employee oldEmployee) 
        throws SQLException {
        String employeeID = oldEmployee.getEmployeeID();
        String sql = "delete from employeeTable where EmployeeID = '" 
            + employeeID + "'";
        int result = stat.executeUpdate(sql);
    }

    /**
     * update an employee's information
     * @param employee the employee to be updated
     */
    public static void updateEmployee(Employee employee) throws SQLException {
        // get infomation about new employee
        String employeeID = employee.getEmployeeID();
        String employeeName = employee.getEmployeeName();
        String employeePW = employee.getEmployeePW();
        String departmentName = employee.getDepartName();
        String basicSalary = String.valueOf(employee.getBasicSalary());
        String extraSalary = String.valueOf(employee.getExtraSalary());
        String sickoffDays = String.valueOf(employee.getSickOffDays());
        String busyoffDays = String.valueOf(employee.getBusyOffDays());
        String lateDays = String.valueOf(employee.getLateDays());
        String overtimeDays = String.valueOf(employee.getOvertimeDays());

        String sql = "update employeeTable set EmployeeID = '" + employeeID 
            + "', EmployeeName = '" + employeeName + "', EmployeePW = '" 
            + employeePW + "', DepartName = '" + departmentName 
            + "', BasicSalary = " + basicSalary + ", ExtraSalary = " 
            + extraSalary + ", SickoffDays = " + sickoffDays 
            + ", BusyoffDays = " + busyoffDays + ", LateDays = " 
            + lateDays + ", OvertimeDays = " + overtimeDays;
        int result = stat.executeUpdate(sql);
    }
}