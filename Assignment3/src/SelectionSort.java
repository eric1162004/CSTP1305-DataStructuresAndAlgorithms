public class SelectionSort implements ISortArray{

    @Override
    public void sort(int[] array) {

        // traverse the array from left to right
        for (int i = 0; i < array.length - 1; i++) {

            // search for the index of the smallest value
            int minIndex = getMinIndex(array, i);

            // swap it with the minIndex with the currentIndex
            swap(array, i, minIndex);
        }
    }

    private static int getMinIndex(int[] array, int startIndex) {
        // assume the startIndex has the minIndex
        var minIndex = startIndex;

        // traverse from the currentIndex to the right
        for (int j = startIndex; j < array.length; j++) {

            // replace the minIndex if a smaller value is found
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
