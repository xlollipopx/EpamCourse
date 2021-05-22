package com.epam.web.logic;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.BeatDao;
import com.epam.web.dao.BeatDaoImpl;
import com.epam.web.exception.DaoException;
import com.epam.web.model.Account;
import com.epam.web.model.Beat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AddBeatCommand implements Command{

    private static final BeatDao beatDao = new BeatDaoImpl(ConnectionPool.getInstance().getConnection());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws DaoException {

        try {
            String beatName = request.getParameter("beatName");

            Part partOne = request.getPart("fileImage");
            Part partTwo = request.getPart("fileBeat");
            String fileImageName = partOne.getSubmittedFileName();
            String fileBeatName = partTwo.getSubmittedFileName();

            String shortPathForImage = "images/" + fileImageName;
            String imagePathForImage = request.getServletContext().getRealPath("/")
                    +  shortPathForImage;
            InputStream inputStreamOne = partOne.getInputStream();
            uploadFile(inputStreamOne, imagePathForImage);

            String shortPathForBeat = "audio/" + fileBeatName;
            String pathForBeat = request.getServletContext().getRealPath("/")
                    +  shortPathForBeat;
           InputStream inputStreamTwo = partTwo.getInputStream();
           uploadFile(inputStreamTwo, pathForBeat);


            HttpSession session = request.getSession();
            Account account =  (Account)session.getAttribute("account");
            int accountId = account.getId();
            Beat beat = new Beat(beatName, shortPathForBeat, shortPathForImage, 0, accountId);
            beatDao.save(beat);
            CatalogCommand catalogCommand = new CatalogCommand();
            CatalogService service = new CatalogService();
            service.paginate(request, response, beatDao);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

        return "WEB-INF/admin-catalog.jsp";
    }

    private boolean uploadFile(InputStream inputStream, String path) {
        boolean test = false;
        try {
            byte [] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
            test = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return test;
    }

}
