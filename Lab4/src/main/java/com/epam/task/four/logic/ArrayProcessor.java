package com.epam.task.four.logic;

import com.epam.task.four.model.Array;
import java.util.Arrays;

public class ArrayProcessor {

    public void sortArray(Array array) {
        int[] data = new int[array.getSize()];
        for(int i = 0; i < array.getSize(); i++) {
            data[i] = array.getElementByIndex(i);
        }
        mergeSort(data, 0, array.getSize() - 1);
        for(int i = 0; i < array.getSize(); i++) {
            array.setElementByIndex(i, data[i]);
        }

    }

    public int findMaxElement(Array array) {
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < array.getSize(); i++) {
            maxNumber = Math.max(maxNumber, array.getElementByIndex(i));
        }
        return maxNumber;
    }

    public int findMinElement(Array array) {
        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < array.getSize(); i++) {
            minNumber = Math.min(minNumber, array.getElementByIndex(i));
        }
        return minNumber;
    }

    private void mergeSort(int[] a, int lower, int high) {

        if (high <= lower) {
            return;
        }
        int mid = lower + (high - lower) / 2;
        mergeSort(a, lower, mid);
        mergeSort(a, mid + 1, high);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lower; k <= high; k++) {
            buf[k] = a[k];
        }

        int i = lower, j = mid + 1;
        for (int k = lower; k <= high; k++) {
            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > high) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }
}
