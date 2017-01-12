package connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * *
 * * Created by ryudung on 2017-01-12.
 * *
 **/
public interface ConnectionMaker {
    public Connection makeConnection() throws SQLException, ClassNotFoundException;
}
