import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteCivil2024Students {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            String deleteQuery =
                "DELETE FROM Students WHERE year_of_passing = 2024 AND branch = 'Civil'";

            int rows = st.executeUpdate(deleteQuery);

            System.out.println(rows + " Civil students of 2024 deleted.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
