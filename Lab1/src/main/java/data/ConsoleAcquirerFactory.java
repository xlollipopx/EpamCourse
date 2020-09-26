package data;

public class ConsoleAcquirerFactory implements AcquirerFactory{
    public DataAcquirer createDataAcquirer(){
       return new ConsoleDataAcquirer();
    }

}
