package com.epam.task.seven;


import com.epam.task.seven.data.*;
import com.epam.task.seven.logic.comparator.PyramidIdComparator;
import com.epam.task.seven.logic.comparator.PyramidVolumeComparator;
import com.epam.task.seven.model.Pyramid;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;


public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);
    private final static String FILE_NAME = "input.txt";

    public static void main(String[] args) {

        try {
            run();
        } catch (DataException e) {
            LOGGER.error(e.getMessage(),e);
        }
    }



    public static void run() throws DataException {
        FileDataReader fileDataReader = new FileDataReader(FILE_NAME);
        PyramidCreator pyramidCreator = new PyramidCreator();
        List<Pyramid> pyramids = pyramidCreator.create(fileDataReader.read());
        System.out.println(pyramids);
        System.out.println(pyramids.get(2).getVolume());
        Comparator<Pyramid> comparator = new PyramidVolumeComparator();
        PyramidRepository repository = new PyramidRepository();
        repository.add(pyramids);
        System.out.println(repository.sort(comparator));

    }


}
