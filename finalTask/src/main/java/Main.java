import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.dao.UserDao;
import com.epam.web.dao.UserDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;

import java.sql.*;

public class Main {
    public static void main(String[] args) {



      BeatDao dao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());
     // UserDao dao = new UserDaoImpl(ConnectionPool.getInstance().getConnection());

        try {

            dao.save(new Beat(3, "se", "1:44", "cskdkcs", 0 ,2));
            dao.getAll();
            System.out.println(dao.getAll());

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
