import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateCSEPercentage {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            String updateQuery =
                "UPDATE Students SET percentage = percentage + 5 WHERE branch = 'CSE'";

            int rows = st.executeUpdate(updateQuery);

            System.out.println(rows + " CSE students updated with +5%.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
