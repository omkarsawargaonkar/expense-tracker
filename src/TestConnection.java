import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/expense_tracker";
        String username = "root";
        String password = "Baba@1947";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected Successfully!");

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}