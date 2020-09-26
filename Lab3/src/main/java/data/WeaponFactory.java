package data;

import model.Blade;
import model.Grenade;
import model.MachineGun;
import model.Weapon;


public class WeaponFactory {
    public Weapon create(WeaponType weaponType, int cost, int param) {
        switch (weaponType) {
            case BLADE: return new Blade(weaponType.toString(), cost, param);
            case GRENADE: return new Grenade(weaponType.toString(), cost, param);
            case MACHINEGUN: return new MachineGun(weaponType.toString(), cost, param);
            default: return null;
        }
    }

}
