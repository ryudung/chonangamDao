package factory;

import connection.ConnectionMaker;
import connection.ZConnectionMaker;
import dao.UserDao;

/**
 * *
 * * Created by ryudung on 2017-01-12.
 * *
 *      UserDao객체를 생성해주는 팩토리 클래스
 **/
public class DaoFactory {
    public UserDao getUserDao() {
        ConnectionMaker connectionMaker = new ZConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

/*    public UserDao getZUserDao() {  //문제점 : 생성해야할 종류가 많아 질수록 코드가 늘어난다.
        ConnectionMaker connectionMaker = new ZConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    public UserDao getNUserDao() {
        ConnectionMaker connectionMaker = new ZConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }*/
}
