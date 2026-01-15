import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";

        try {
            // Load Driver (optional in new versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Unable to connect");
            }

        } catch (Exception e) {
            System.out.println("Unable to connect");
            e.printStackTrace();
        }
    }
}
