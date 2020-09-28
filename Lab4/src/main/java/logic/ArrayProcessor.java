package logic;

import model.Array;

import java.util.Arrays;

public class ArrayProcessor {

    public void SortArray(Array array) {
        int[] data = new int[array.getSize()];
        for(int i = 0; i < array.getSize(); i++) {
            data[i] = array.getElementByIndex(i);
        }
        MergeSort(data, 0, array.getSize() - 1);
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

    private void MergeSort(int[] a, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        MergeSort(a, lo, mid);
        MergeSort(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++) {
            buf[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
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
