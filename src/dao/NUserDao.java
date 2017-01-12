package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * *
 * * Created by ryudung on 2017-01-11.
 * *
 **/
public class NUserDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver"); //N사의 DB 예) oradle, mysql, maria..
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex?useSSL=false&characterEncoding=UTF-8", "ryudung","1234");
        //N사만의 커넥션 주소/ 아이디, 비번

        System.out.println("N사 입니다.");
        /**
         * Z사만의 로직 코드
                .
                .
         * */
        return con;
    }
}
