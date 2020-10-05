package com.epam.task.five.data;

import com.epam.task.five.exception.DataException;

public interface StringAcquirer {

    String readString() throws DataException;
}
