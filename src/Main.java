import dao.UserDao;
import domain.User;

import java.sql.SQLException;
import java.util.UUID;

/*
*
* */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();
        User user = dao.get("ryudung");
        System.out.println(user.toString());


        User user2 = new User(UUID.randomUUID().toString().substring(0,5),"테스트","1");
        dao.insert(user2);


        dao.get(user2.getId());
        System.out.println(user2.toString());

    }
}
