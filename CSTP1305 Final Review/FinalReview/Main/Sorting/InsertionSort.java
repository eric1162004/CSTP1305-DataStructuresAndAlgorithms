package Sorting;

public class InsertionSort {
    public void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int current = i;
            while(current > 0 && array[current] < array[current - 1]){
                swap(array, current , current - 1);
                current--;
            }
        }
    }

    private void swap(int[] array, int j, int i) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
