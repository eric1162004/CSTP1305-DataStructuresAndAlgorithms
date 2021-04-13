package Sorting;

public class QuickSort {

    public void sort(int[] array){
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int start, int end){
        if(start >= end)
            return;

        //  Partition
        var boundary = partition(array, start, end);
        // Sort left
        sort(array, start, boundary - 1);
        // Sort right
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end){
        var pivot = array[end];
        var boundary = start - 1;
        for (int i = start; i <= end; i++)
            if(array[i] <= pivot)
                swap(array, i, ++boundary);

        return boundary;
    }

    private void swap(int[] array, int j, int i) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
