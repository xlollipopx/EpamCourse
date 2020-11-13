package data;

import data.exception.DataException;

public interface Reader {
    String read(String fileName) throws DataException;
}
