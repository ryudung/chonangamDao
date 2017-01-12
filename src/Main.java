import dao.UserDao;
import domain.User;
import factory.DaoFactory;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      UserDao userDao = new DaoFactory().getUserDao();
      User user=userDao.get("ryudung");
        System.out.println(user.toString());
    }
}
