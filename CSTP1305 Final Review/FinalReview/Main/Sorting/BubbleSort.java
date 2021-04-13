package Sorting;

public class BubbleSort {
    public void sort(int[] array){
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = i; j < array.length - i; j++)
                if(array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }

            if(isSorted)
                return;
        }
    }
    private void swap(int[] array, int j, int i) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
