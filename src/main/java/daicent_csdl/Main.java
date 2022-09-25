package daicent_csdl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO=new UserDAO();
        userDAO.insertUser(new Userz(1,"thuan"));
        userDAO.insertUser(new Userz(123,"âsas"));
        System.out.println(userDAO.selectUser(3));
        System.out.println(userDAO.selectAllUsers());
    }
}
