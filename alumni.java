import java.sql.*;

public class alumni {
    public static void main(String args[]) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "system";
        String password = "manage";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * From Alumni ")) {

            while (resultSet.next()) {
                
                String a_id = resultSet.getString("A_ID");
                String a_name = resultSet.getString("A_NAME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");
                int phone_no = resultSet.getInt("PHONE_NO");
                int graduate_year = resultSet.getInt("GRADUATE_YEAR");
                String batchid = resultSet.getString("BATCHID");

                System.out.println("Alumni_Id: " + a_id + ", Alumni_Name: " + a_name + ", Email: " + email +
                                   ", Address " + address + ", Phone_No: " + phone_no + ", Graduate_Year: " + graduate_year +
                                   ", Batch_Id: " + batchid);
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
