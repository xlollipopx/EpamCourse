package model;

public class Grenade extends Weapon{
    private int power;

    public Grenade() {}

    public Grenade(String weaponType, int cost, int power) {
        super(weaponType, cost);
        this.power = power;
    }

    public Grenade(Grenade grenade) {
        this(grenade.getWeaponType(), grenade.getCost(), grenade.getPower());
    }

    public int getPower() {
        return power;
    }
}
