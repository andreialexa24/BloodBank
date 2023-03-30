import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Donor extends User {
    public Donor(String username, String password) {
        super(username, password, "Donor");
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your blood group:");
        String bloodGroup = scanner.nextLine();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_bank", "root", "pass123");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO donators (name, email, blood_group) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, bloodGroup);
            statement.executeUpdate();
            System.out.println("Registration successful!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}