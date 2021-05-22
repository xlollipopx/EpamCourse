package com.epam.web.extractor;

import java.sql.PreparedStatement;

public interface FieldsExtractor <T> {
    public void extract(T item, PreparedStatement statement);
}
