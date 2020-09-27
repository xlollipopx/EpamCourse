package model;

public class Blade extends Weapon{
    private int length;

    public Blade() {}

    public Blade(String weaponType, int cost, int length) {
        super(weaponType, cost);
        this.length = length;
    }

    public Blade(Blade blade) {
        this(blade.getWeaponType(), blade.getCost(), blade.getLength());
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return super.toString() + " " +  Integer.toString(length);
    }
}
