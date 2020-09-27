package data;

import model.Weapon;

import java.util.List;

public interface DataAcquirer {
    public List<Weapon> read();
}
