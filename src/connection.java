import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class connection {
    public static void main(String[] args) {
        String connectionURL = "jdbc:sqlserver://127.0.0.1;databaseName=sysdyn;user=sys_connect";
        try (Connection connection = DriverManager.getConnection(connectionURL); Statement statement = connection.createStatement();) {
            String SQL = "SELECT * FROM sysdyn.dbo.Companies";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "|" + resultSet.getString(2));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
