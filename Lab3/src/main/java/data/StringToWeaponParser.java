package data;

import model.Weapon;

public class StringToWeaponParser {
    static Weapon parse(String line) {
        String[] data = line.split(" ");
        data[0] = data[0].toUpperCase();
        WeaponFactory weaponFactory = new WeaponFactory();
        switch(data[0]) {
            case "BLADE": return weaponFactory.create(WeaponType.BLADE,
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]));
            case "GRENADE":return  weaponFactory.create(WeaponType.GRENADE,
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]));
            case "MACHINEGUN":return weaponFactory.create(WeaponType.MACHINEGUN,
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]));
            default:
                throw new IllegalArgumentException("wrong argument!");
        }
    }
}
