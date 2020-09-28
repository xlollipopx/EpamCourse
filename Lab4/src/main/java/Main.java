import logic.ArrayProcessor;
import model.Array;
import view.ArrayConsoleViewer;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(1, 5, 3, 2);
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        arrayProcessor.SortArray(array);
        ArrayConsoleViewer arrayConsoleViewer = new ArrayConsoleViewer();
        arrayConsoleViewer.view(array);
    }
}
