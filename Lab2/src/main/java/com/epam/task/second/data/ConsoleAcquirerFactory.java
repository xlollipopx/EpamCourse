package com.epam.task.second.data;

public class ConsoleAcquirerFactory implements AcquirerFactory{

    public DataAcquirer createDataAcquirer(){
        return new ConsoleDataAcquirer();
    }

}
