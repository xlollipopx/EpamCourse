package com.epam.task.seven.data;

import java.util.List;

public interface DataReader {
    List<String> read() throws DataException;

}
