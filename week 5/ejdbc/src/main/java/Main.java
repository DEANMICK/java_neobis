import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/database";
    private static final String username = "username";
    private static final String password = "password";
    private static final String[] arrays = {"Печать", "Добавить", "Удалить", "Обновить", "Выход"};
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        connect();
    }

    private static void connect() {
        try {
            Connection connection;
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Подключено...");
            Statement statement = connection.createStatement();
            choiceAction(statement);
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }

    private static void choiceAction(Statement statement) throws SQLException {
        System.out.println("Выберите действие: ");
        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("\t%d. %s\n", i, arrays[i]);
        }
        System.out.print(">>> ");
        int choice = SCANNER.nextInt();
        switch (choice) {
            case 0:
                UserJDBC.printUser(statement);
                choiceAction(statement);
                break;

            case 1:
                UserJDBC.addUser(statement);
                choiceAction(statement);
                break;

            case 2:
                UserJDBC.deleteUser(statement);
                choiceAction(statement);
                break;

            case 3:
                UserJDBC.changeUserInfo(statement);
                choiceAction(statement);
                break;

            case 4:
                System.out.println("Disconnect...");
                statement.close();
                break;
        }
    }
}
