package dao;

import connection.ConnectionMaker;
import connection.SimpleConnectionMaker;
import connection.ZConnectionMaker;
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
 * <p>
 * 진행할 작업 : 스프링 Ioc (제어의역전)
 *
 * 주의: 계속해서 변하는 데이터는 읽기 전용 데이터가 아니면, 인스턴스 필드로 선언하면 안된다
 *      단, 에플리케이션컨텍스트에서 주입 받는 객체는 괜찮다.
 *      - 변화하는 데이터를 공유하게 되면, 심각한 문제를 발생시킬 수 있다.
 */
public class UserDao {

    /*
    변경한 코드
    * */
    private ConnectionMaker ConnectionMaker;
    private int a;

    public int change(int b){
        a= a+b;
        return a;
    }

    public UserDao(ConnectionMaker ConnectionMaker) {
        this.ConnectionMaker = ConnectionMaker;
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {

        Connection con = ConnectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        con.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection con = ConnectionMaker.makeConnection();

        PreparedStatement ps = con.prepareStatement("select * from users where id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
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

        /*
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
    /**
         '템플릿 메소드 패턴'
        : 슈퍼클래스에서 기본적인 로직흐름을 만들어 놓고 하위 클래스에서 로직에 따라서 각기 구현하게 만든 패턴
         변하지 않는 공통 부분은 슈퍼클래스에 남겨두고, 각기 다른 로직을 하위 클래스에서 구현(overriding하여) 하는 패턴

         '팩토리 메소드 패턴'
        : 서브클래스에서 구체적인 오브젝트 생성방법을 결정하게 하는 방식.

    이전코드
    private Connection getConnection() throws ClassNotFoundException, SQLException {// 1. 중복 메소드 제거 -> 메소드 추출
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test_ex?useSSL=false&characterEncoding=UTF-8", "ryudung","1234");
        return con;
    }*/
}
