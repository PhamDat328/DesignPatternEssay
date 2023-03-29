package DAOPatternDemo;

import java.sql.*;

public class UserJdbcDao implements UserDao {
    private static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static String USER_NAME = "root";
    private static String PASSWORD = "1234567890";
    private Connection connection = getConnection(DB_URL, USER_NAME, PASSWORD);

    public static Connection getConnection(String dbURL, String userName,
                                           String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    // constructor, initialize connection, etc.

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.executeUpdate();
        statement.close();

    }
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        User user = null;
        if (result.next()) {
            user = new User();
            user.setId(result.getInt("id"));
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
        }
        result.close();
        statement.close();
        return user;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        PreparedStatement statement =
                connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setInt(3, user.getId());
        statement.executeUpdate();
        statement.close();
    }

    public void deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, user.getId());
        statement.executeUpdate();
        statement.close();
    }


}

