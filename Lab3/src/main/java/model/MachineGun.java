package model;

public class MachineGun extends Weapon {
    private int calibre;

    public MachineGun() {}

    public MachineGun(String weaponType, int cost, int calibre) {
          super(weaponType,cost);
          this.calibre = calibre;
    }

    public MachineGun(MachineGun machineGun) {
        this(machineGun.getWeaponType(), machineGun.getCost(), machineGun.getCalibre());
    }

    public int getCalibre() {
        return calibre;
    }

}
