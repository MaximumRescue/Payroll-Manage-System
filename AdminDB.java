import java.util.*;
import java.sql.*;
/**
 * 用于描述管理员与数据库内信息关系的类
 * 假定保存管理员信息的表为adminTable(AdminID, Username, Password)
 * @version 1.00 2018-06-28
 * @author Jiamin Pan
 */
public class AdminDB {
    static Connection conn;
    static Statement stat;

    /**
     * get connection with database
     * @return the connection
     */
    private static Connection getConnection() throws SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/adminTable";
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
     * find whether there exists this admin
     * @param username the username from input
     * @param password the password from input
     */
    public static boolean findAdmin(String username, String password) 
        throws SQLException {
        String sql = "select * from adminTable where username = '" 
            + username + "' and password = '" + password + "'";
        ResultSet rs = stat.executeQuery(sql);
        boolean result = rs.next();
        rs.close();
        return result;
    }

    /**
     * add a new admin to table
     * @param newAdmin the admin to be added
     */
    public static void addAdmin(Administrator newAdmin) throws SQLException {
        // get infomation about new admin
        String adminID = newAdmin.getAdminID();
        String adminName = newAdmin.getUsername();
        String adminPW = newAdmin.getPassword();

        String sql = "insert * into adminTable (AdminID, Username, Password) " 
            + "values ('" + adminID + "','" + adminName + "','" 
            + adminPW + "')";
        if (!findAdmin(adminName, adminPW)) {
            int result = stat.executeUpdate(sql);
        }
        else {
            System.out.println("This admin exists!!!");
        }
    }

    /**
     * delete an admin to table
     * @param oldAdmin the admin to be deleted
     */
    public static void delAdmin(Administrator oldAdmin) throws SQLException {
        String adminID = oldAdmin.getAdminID();
        String sql = "delete from adminTable where AdminID = '" 
            + adminID + "'";
        int result = stat.executeUpdate(sql);
    }

    /**
     * update an admin's information
     * @param admin the admin to be updated
     */
    public static void updateAdmin(Administrator admin) throws SQLException {
        // get infomation about new admin
        String adminID = admin.getAdminID();
        String adminName = admin.getUsername();
        String adminPW = admin.getPassword();

        String sql = "update adminTable set AdminID = '" + adminID 
            + "', Username = '" + adminName + "', Password = '" 
            + adminPW + "'";
        int result = stat.executeUpdate(sql);
    }
}