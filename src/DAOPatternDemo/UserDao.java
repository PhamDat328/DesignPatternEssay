package DAOPatternDemo;

import java.sql.SQLException;

public interface UserDao {
    public void createUser(User user) throws SQLException;
    public User getUserById(int id) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;

}
