package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * *
 * * Created by ryudung on 2017-01-11.
 * *
 **/
public class SimpleConnectionMaker {

    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex?useSSL=false&characterEncoding=UTF-8", "ryudung","1234");
        return con;
    }
}
