import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.dao.UserDao;
import com.epam.web.dao.UserDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

//        String host = "jdbc:mysql://localhost/mydb?useUnicode=true&serverTimezone=UTC";
//        String login = "root";
//        String pass = "notna2001";
//
//        try {
//            Connection con = DriverManager.getConnection(host, login, pass);
//            Statement stat = con.createStatement();
//            String sql = "select * from accounts";
//            ResultSet rs = stat.executeQuery(sql);
//            while( rs.next()) {
//                int id_col = rs.getInt("account_id");
//                String lgn = rs.getString("user_name");
//                String psw = rs.getString("password");
//                int role_id = rs.getInt("role_id");
//                System.out.println(id_col + " " + lgn + " " + psw + " " + role_id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    //   BeatDao dao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());
       UserDao dao = new UserDaoImpl(ConnectionPool.getInstance().getConnection());

        try {

            System.out.println(dao.findUserByLoginAndPassword("Anto", "1234"));
            System.out.println(dao.getAll());

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
