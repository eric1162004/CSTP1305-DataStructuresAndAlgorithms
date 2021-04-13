package Sorting;

public class MergeSort {

    public void sort(int[] array){
        if(array.length < 2)
            return;

        int middleIndex = array.length / 2;

        int[] left = new int[middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middleIndex];
        for (int i = middleIndex; i < array.length; i++) {
            right[i - middleIndex] = array[i];
        }

        sort(left);
        sort(right);

        // merge
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] array) {
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex])
                array[arrayIndex++] = left[leftIndex++];
            else
                array[arrayIndex++] = right[rightIndex++];
        }

        while (leftIndex < left.length)
            array[arrayIndex++] = left[leftIndex++];

        while (rightIndex < right.length)
            array[arrayIndex++] = right[rightIndex++];

    }
}
