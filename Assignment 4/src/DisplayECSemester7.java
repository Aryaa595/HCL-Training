import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayECSemester7 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            String selectQuery =
                "SELECT * FROM Students WHERE semester = 7 AND branch = 'EC'";

            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("ID  Name   Branch  Sem  %   Year");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "  " +
                    rs.getString("name") + "  " +
                    rs.getString("branch") + "  " +
                    rs.getInt("semester") + "  " +
                    rs.getDouble("percentage") + "  " +
                    rs.getInt("year_of_passing")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

