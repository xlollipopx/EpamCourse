package data;

import model.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileDataAcquirer {
    private final String FILE_NAME = "C:\\Users\\USER\\Documents\\GitHub\\EPAM_JAVA\\Lab3\\src\\main\\java\\data\\resources\\input.txt";

    public List<Weapon> read() {
        List<Weapon> weapons = new LinkedList<Weapon>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                weapons.add(StringToWeaponParser.parse(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return weapons;
    }
}
