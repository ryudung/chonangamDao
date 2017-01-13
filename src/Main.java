import dao.UserDao;
import domain.User;
import factory.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("UserDao", UserDao.class);
        System.out.println(userDao.change(1));
       /* UserDao userDao = new DaoFactory().UserDao();*/
        User user = userDao.get("ryudung");
        System.out.println(user.toString());

        UserDao userDao2 = context.getBean("UserDao", UserDao.class);
        System.out.println(userDao.change(1));
    }
}
