package dao;

import domain.User;

import java.sql.*;

/**
 * *
 * * Created by ryudung on 2017-01-11.
 * *
 **/
public class UserDao {
    public void insert(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex","ryudung","1234");
        PreparedStatement ps = con.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        con.close();

    }
    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex?useSSL=false&SSL=false&?characterEncoding=UTF-8", "ryudung","1234");
        PreparedStatement ps = con.prepareStatement("select * from users where id=?");
        ps.setString(1,id);
        ResultSet rs =ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        con.close();

        return user;
    }
}
