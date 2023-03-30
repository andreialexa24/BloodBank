import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/blood_bank";
            String username = "root";
            String password = "pass123";
            Connection connection = DriverManager.getConnection(url, username, password);

            UserDAO userDAO = new UserDAO(connection);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username:");
            String usernameInput = scanner.nextLine();
            System.out.println("Enter your password:");
            String passwordInput = scanner.nextLine();
            User user = userDAO.getUser(usernameInput, passwordInput);

            if (user != null) {
                System.out.println("Welcome, " + user.getRole() + " " + user.getUsername() + "!");

                if (user instanceof Donor) {
                    System.out.println("Would you like to register as a new Donor? (y/n)");
                    String registerInput = scanner.nextLine();

                    if (registerInput.equals("y")) {
                        ((Donor) user).register();
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }

            scanner.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: U dont have an account");
        }
    }
}