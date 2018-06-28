import java.util.*;
import java.sql.*;
/**
 * 用于保存费用信息的类
 * 假设数据库中的表为Fee(heatSubsidy, feeOfSick, feeOfBusy, feeOfLate, feeOfOver)
 * @version 1.00 2018-06-28
 * @author Jiamin Pan
 */
public class Fee {
    private static int heatSubsidy;
    private static int moneyOfSick;
    private static int moneyOfBusy;
    private static int moneyOfLate;
    private static int moneyOfOver;

    /**
     * construction
     */
    public Fee() {
        ResultSet Rs = getInfo();
        this.heatSubsidy = Rs.getString(1);
        this.moneyOfSick = Rs.getString(2);
        this.moneyOfBusy = Rs.getString(3);
        this.moneyOfLate = Rs.getString(4);
        this.moneyOfOver = Rs.getString(5);
    }

    /**
     * get connection with database
     * @return the connection
     */
    private static Connection getConnection() throws SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Fee";
        // 自己填好数据库的用户名和密码
        String username = null;
        String password = null;
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * close the connection to database
     */
    private static void closeConnection() throws SQLException {
        conn.close();
    }

    /**
     * get all the fees' information
     * @return the ResultSet of finding
     */
    private static ResultSet getInfo() throws SQLException {
        Connection conn = getConnection();
        Statement stat = conn.createStatement();
        String sql = "select * from Fee";
        ResultSet rs = stat.executeQuery(sql);
        rs.close(); stat.close(); closeConnection();
        return rs;
    }
}