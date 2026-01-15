import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateAndInsertStudents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            // Create Table
            String createTable =
                "CREATE TABLE IF NOT EXISTS Students (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50), " +
                "branch VARCHAR(10), " +
                "semester INT, " +
                "percentage DOUBLE, " +
                "year_of_passing INT)";

            st.executeUpdate(createTable);

            // Insert Records
            String insert1 = "INSERT INTO Students(name, branch, semester, percentage, year_of_passing) " +
                             "VALUES('Amit', 'CSE', 7, 78, 2025)";
            String insert2 = "INSERT INTO Students(name, branch, semester, percentage, year_of_passing) " +
                             "VALUES('Neha', 'EC', 7, 74, 2024)";
            String insert3 = "INSERT INTO Students(name, branch, semester, percentage, year_of_passing) " +
                             "VALUES('Ravi', 'Civil', 6, 69, 2024)";

            st.executeUpdate(insert1);
            st.executeUpdate(insert2);
            st.executeUpdate(insert3);

            System.out.println("Table created and records inserted successfully.");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

