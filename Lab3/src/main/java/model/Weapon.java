package model;

public abstract class Weapon {
    private String weaponType;
    private int cost;

    public Weapon(){}

    public Weapon(String weaponType, int cost) {
        this.weaponType = weaponType;
        this.cost = cost;
    }

    public Weapon(Weapon weapon) {
        this(weapon.getWeaponType(), weapon.getCost());
    }

    public String getWeaponType() {
        return weaponType;
    }

    public int getCost() {
        return cost;
    }

    public String toString() {
        return weaponType + " " + " " + Integer.toString(cost);
    }
}
