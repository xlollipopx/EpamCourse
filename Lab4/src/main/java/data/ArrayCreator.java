package data;

import model.Array;

public class ArrayCreator {

    public Array create(int[] data) {
        return new Array(data);
    }

    public Array create(Array array) {
        return new Array(array);
    }

}
