package daicent_csdl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class UserDAO implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";


    private static final String SELECT_USER_BY_ID = "select id, password,username from userz where id =?";
    private static final String INSERT_USERS_SQL = "INSERT INTO userz (password,username) VALUES (?, ?);";
    private static final String SELECT_ALL_USERS = "select * from userz";
    private static final String UPDATE_USERS_SQL = "update userz set password = ?,set username = ? where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertUser(Userz user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, user.getPass());
            preparedStatement.setString(2, user.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Userz selectUser(int id) {
        Userz user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int pass= rs.getInt("password");
                String name = rs.getString("username");
                user = new Userz(pass,name);
            }
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public List<Userz> selectAllUsers() {
        List<Userz> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int pass= rs.getInt("password");
                String name = rs.getString("username");
                users.add(new Userz(id,pass,name));
            }
        } catch (SQLException e) {

        }
        return users;
    }

    @Override
    public boolean updateUser(Userz user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setInt(1,user.getPass());
            statement.setString(2, user.getName());
            statement.setInt(3, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
