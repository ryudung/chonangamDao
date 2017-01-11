package dao;

import domain.User;

import java.sql.*;

/**
 * *
 * * Created by ryudung on 2017-01-11.
 * *
            * 관심사 3가지
            * 1. DB와 연결된 connection 연결
            * 2. 파라미터 바인딩과 어떤 SQL을 사용
            * 3. connection을 닫아주는 작업
 * */
public class UserDao {

    private Connection getConnection() throws ClassNotFoundException, SQLException {// 1. 중복 메소드 제거 -> 메소드 추출
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex?useSSL=false&characterEncoding=UTF-8", "ryudung","1234");
        return con;
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        con.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
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
