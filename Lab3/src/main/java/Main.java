import data.FileDataAcquirer;
import data.SquadCreator;
import model.Squad;
import view.SquadCharacteristicsViewer;

public class Main {
    public static void main(String[] args) {
        String FILE_NAME = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\main\\java\\data\\resources\\input.txt";
        FileDataAcquirer fileDataAcquirer = new FileDataAcquirer();
        SquadCreator squadCreator = new SquadCreator();
        Squad squad = squadCreator.create(fileDataAcquirer.readWeaponList(FILE_NAME));
        SquadCharacteristicsViewer squadCharacteristicsViewer = new SquadCharacteristicsViewer();
        squadCharacteristicsViewer.view(squad);
        squadCharacteristicsViewer.viewArmingCost(squad);
    }
}
