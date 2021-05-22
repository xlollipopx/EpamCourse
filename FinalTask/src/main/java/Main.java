import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.*;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;
import com.epam.web.model.Comment;

import java.io.File;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {


       // BeatDaoImpl dao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());
        UserDao dao = new UserDaoImpl(ConnectionPool.getInstance().getConnection());
        CommentsDaoImpl d  = new CommentsDaoImpl(ConnectionPool.getInstance().getConnection());



          //  dao.save(new Beat(3, "se", "1:44", "cskdkcs", 0 ,2));
            //dao.getAll();
        Date date = new Date(2020, 12,2);
        //System.out.println(d.save(new Comment(1,"cool",date, 2, 1)));
       // List<Comment> comment = d.findCommentsForCurrentBeat(1);
       // System.out.println(comment.size());
        try {
            System.out.println((dao.getById(2)).isPresent());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        //System.out.println(dao.getAll());



    }
}
