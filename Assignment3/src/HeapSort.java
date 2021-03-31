public class HeapSort {

    public void sort(int[] array) {
        int lastParentIndex = array.length / 2 - 1;

        for (int i = lastParentIndex; i >= 0; i--)
            sort(array, i, array.length);

        for (int i = array.length - 1 ; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            sort(array, 0, i);
        }

    }

    private static void sort(int[] array, int index, int heapSize){
        var smallerIndex  = index;

        var leftIndex = index * 2 + 1;
        if(leftIndex < heapSize &&
                array[leftIndex] > array[smallerIndex])
            smallerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if(rightIndex < heapSize &&
                array[rightIndex] > array[smallerIndex])
            smallerIndex = rightIndex;

        if(index == smallerIndex)
            return;

        swap(array, index, smallerIndex);
        sort(array, smallerIndex, heapSize);

    }

    private static void swap(int[] array, int first, int last){
        var temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }
}
