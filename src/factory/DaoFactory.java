package factory;

import connection.ConnectionMaker;
import connection.NConnectionMaker;
import connection.ZConnectionMaker;
import dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * *
 * * Created by ryudung on 2017-01-12.
 * *
 *      UserDao객체를 생성해주는 팩토리 클래스(IoC)
 *      기존에 클라이언트에서 오브젝트를 생성해주었다.
 *      생성해주는 책임을 분리하여, 다른 오브젝트 팩토리에서 생성하여 클라이언트에서 넘겨 받아 클라이언트는 사용만한다.
 *      IoC를 함으로써 생성의 책임(관심사)을 분리할 수 있게 되었다.
 **/
//@Configuration
public class DaoFactory { //이 역할을 스프링이 해주게 된다.
    //@Bean
    public UserDao UserDao() {

        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }
    //@Bean
    public UserDao NUserDao() {

        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }
   // @Bean
    public ConnectionMaker connectionMaker(){
        return new ZConnectionMaker();
    }
}
