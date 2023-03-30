import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/blood_bank";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pass123";

    public static void registerDonator(String name, String email, String bloodType) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO donators (name, email, blood_type) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, bloodType);
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}