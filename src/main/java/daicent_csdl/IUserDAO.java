package daicent_csdl;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(Userz user) throws SQLException;

    public Userz selectUser(int id);
    public List<Userz> selectAllUsers();


    public boolean updateUser(Userz user) throws SQLException;
}
