/**
 * 用于保存税率信息的类
 * 假设数据库中的表为Rate(PensionByE, PensionByC, MedicalByE, MedicalByC, 
 * UnemploymentByE, UnemploymentByC, InjuryByC, 
 * FertilityByC, ProFundByE, ProFundByC)
 * @version 1.00 2018-06-28
 * @author Jiamin Pan
 */
public class Rate {
    private static double pensionRateByE;
    private static double pensionRateByC;
    private static double medicRateByE;
    private static double medicRateByC;
    private static double unempRateByE;
    private static double unempRateByC;
    private static double injuryRateByC;
    private static double fertiRateByC;
    private static double proFundRateByE;
    private static double proFundRateByC;

    /**
     * construction
     */
    public Fee() {
        ResultSet Rs = getInfo();
        this.pensionRateByE = Rs.getString(1);
        this.pensionRateByC = Rs.getString(2);
        this.medicRateByE = Rs.getString(3);
        this.medicRateByC = Rs.getString(4);
        this.unempRateByE = Rs.getString(5);
        this.unempRateByC = Rs.getString(6);
        this.injuryRateByC = Rs.getString(7);
        this.fertiRateByC = Rs.getString(8);
        this.proFundRateByE = Rs.getString(9);
        this.proFundRateByC = Rs.getString(10);
    }

    /**
     * get connection with database
     * @return the connection
     */
    private static Connection getConnection() throws SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Rate";
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
        String sql = "select * from Rate";
        ResultSet rs = stat.executeQuery(sql);
        rs.close(); stat.close(); closeConnection();
        return rs;
    }
}