public class SelectionSort implements ISortArray{

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = getMinIndex(array, i);
            swap(array, i, minIndex);
        }
    }

    private static int getMinIndex(int[] array, int startIndex) {
        var minIndex = startIndex;
        for (int j = startIndex; j < array.length; j++) {
            if(array[minIndex] > array[j])
                minIndex = j;
        }
        return minIndex;
    }

    private static void swap(int[] array, int first, int last){
        var temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }

}
