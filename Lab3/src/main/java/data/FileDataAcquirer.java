package data;

import model.Weapon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileDataAcquirer implements DataAcquirer{

    public List<Weapon> readWeaponList(String fileName) {
        List<Weapon> weapons = new LinkedList<Weapon>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
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

    public String read(String fileName) {
        BufferedReader bufferedReader = null;
        String result = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                result+= line;
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
        return result;
    }
}
