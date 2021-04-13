package Sorting;

public class SelectionSort {
    public void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[smallest] > array[j])
                    smallest = j;
            }
            swap(array, i, smallest);
        }
    }

    private void swap(int[] array, int j, int i) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
