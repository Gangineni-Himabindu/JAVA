import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaToMysql { // Class name should match the filename

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bindu"; // URL of the database
        String user = "root"; // MySQL username
        String password = "Bindu@410"; // MySQL password

        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the database!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
