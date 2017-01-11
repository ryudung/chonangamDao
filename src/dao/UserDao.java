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
 *
 *          진행할 작업 : 상속을 통한 확장.
 * */
public abstract class UserDao {
    /*
    변경한 코드
    * */
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
    /**
         '템플릿 메소드 패턴'
        : 슈퍼클래스에서 기본적인 로직흐름을 만들어 놓고 하위 클래스에서 로직에 따라서 각기 구현하게 만든 패턴
         변하지 않는 공통 부분은 슈퍼클래스에 남겨두고, 각기 다른 로직을 하위 클래스에서 구현(overriding하여) 하는 패턴

         '팩토리 메소드 패턴'
        : 서브클래스에서 구체적인 오브젝트 생성방법을 결정하게 하는 방식.
     */

    /*
    이전코드
    private Connection getConnection() throws ClassNotFoundException, SQLException {// 1. 중복 메소드 제거 -> 메소드 추출
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex?useSSL=false&characterEncoding=UTF-8", "ryudung","1234");
        return con;
    }*/

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
