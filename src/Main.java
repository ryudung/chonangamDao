import dao.NUserDao;
import dao.UserDao;
import dao.ZUserDao;
import domain.User;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();

        User user = dao.get("ryudung");
        System.out.println(user.toString());

      /*  UserDao dao2 = new NUserDao();//객체를 생성을 결정하는 것이 클라이언트 쪽으로 넘어옴

        User user2 = dao2.get("ryudung");
        System.out.println(user2.toString());*/

    }
}
