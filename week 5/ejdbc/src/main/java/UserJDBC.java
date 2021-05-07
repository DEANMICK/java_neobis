import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserJDBC {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String[] arrays = {"#", "Name", "Email", "Password", "Role"};
    private static final int enable = 1;
    private static final String role = "USER";

    public static void addUser(Statement statement) throws SQLException {
        System.out.print("Введите имя: ");
        String name = SCANNER.nextLine();

        System.out.print("Введите пароль: ");
        String pass = SCANNER.nextLine();

        System.out.print("Введите email: ");
        String email = SCANNER.nextLine();

        String insert = "INSERT INTO `testschema`.`users` " + "(`name`, `password`, `email`, `enabled`, `role`) " +
                "VALUES ('" + name + "', '" + pass + "', '" + email + "', '" + enable + "', '" + role + "')";
        statement.executeUpdate(insert);
        System.out.println("Пользователь успешно добавлен!");
    }

    public static void deleteUser(Statement statement) throws SQLException {
        System.out.print("Введите номер пользователя: ");
        int id = SCANNER.nextInt();
        statement.executeUpdate("DELETE FROM `testschema`.`users`" + "WHERE id=" + id);
        System.out.println("Пользователь удален");
    }

    public static void changeUserInfo(Statement statement) throws SQLException {
        System.out.print("Введите имя пользователя которого надо найти: ");
        String nameSearch = SCANNER.nextLine();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        table();
        System.out.printf("|%-4s|%-14s|%-34s|%-34s|%-9s|\n", arrays[0], arrays[1], arrays[2], arrays[3], arrays[4]);
        table();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            if (name.equals(nameSearch)) {
                System.out.format("|%-4s|%-14s|%-34s|%-34s|%-9s|\n", id, name, email, password, role);
                table();
            }
        }
        updateUserInfo(statement, nameSearch);
    }

    private static void updateUserInfo(Statement statement, String nameSearch) throws SQLException {
        System.out.print("Хотите перезаписать данные?\n[1] Yes\t\t[2] No\n>>> ");
        String newName = "", newEmail = "", newPassword = "";
        ResultSet resultSet = statement.executeQuery("SELECT id FROM users WHERE name=" + nameSearch);
        int choice = SCANNER.nextInt();
        switch (choice){
            case 1:
                System.out.print("Что хотите перезаписать?");
                System.out.printf("\n\t[1]%s\n\t[2]%s\n\t[3]%s\n>>> ", arrays[1], arrays[2], arrays[3]);
                int vybor = SCANNER.nextInt();
                switch (vybor) {
                    case 1:
                        System.out.print("Введите новое имя: ");
                        SCANNER.nextLine();
                        newName = SCANNER.nextLine();
                        String query = "UPDATE users SET name=" + newName + "WHERE id=" + resultSet.getString("id");
                        statement.executeUpdate(query);
                        changeUserInfo(statement);
                        break;
                }

            case 2:
                changeUserInfo(statement);
                break;
        }
    }

    public static void printUser(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        table();
        System.out.printf("|%-4s|%-14s|%-34s|%-34s|%-9s|\n", arrays[0], arrays[1], arrays[2], arrays[3], arrays[4]);
        table();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            System.out.format("|%-4s|%-14s|%-34s|%-34s|%-9s|\n", id, name, email, password, role);
            table();
        }
    }

    private static void table() {
        for (int i = 0; i <= 100; i++) {
            if (i == 0 || i == 5 || i == 20 || i == 55 || i == 90 || i == 100) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
