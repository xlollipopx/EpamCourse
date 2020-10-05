package com.epam.task.five.data.factories;

import com.epam.task.five.data.StringAcquirer;

public interface StringAcquirerFactory {
    public StringAcquirer create(StringFactoryType stringFactoryType);
}
