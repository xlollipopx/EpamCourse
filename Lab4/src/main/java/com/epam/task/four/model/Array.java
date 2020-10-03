package com.epam.task.four.model;

import java.util.Arrays;

public class Array {
    private int[] data;
    private int size;

    public Array() {}

    public Array(int... data){
        this.data = data.clone();
        this.size = data.length;
    }

    public Array(Array arrayObject) {
        this.data = arrayObject.data.clone();
        this.size = arrayObject.size;
    }

    public int getSize() {
        return size;
    }

    public int getElementByIndex(int index){
        return data[index];
    }

    public void setElementByIndex(int index, int value) {
        data[index] = value;
    }

    public int[] getData() {
        return data.clone();
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("");
        for(int i = 0; i < size; i++) {
            string.append(Integer.toString(data[i]));
            string.append(" ");
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Array array = (Array) obj;
        return size == (array).size && Arrays.equals(data, (array).data);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

}
