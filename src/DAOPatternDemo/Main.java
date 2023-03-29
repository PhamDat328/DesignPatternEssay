package DAOPatternDemo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserJdbcDao();
        User user = new User();
        user.setName("Phat Dat");
        user.setEmail("phatdat@gmail.com");
        userDao.createUser(user);
    }
}
