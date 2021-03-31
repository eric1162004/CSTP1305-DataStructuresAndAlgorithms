public class HeapSort {

    public void sort(int[] array) {
        // Find the last parent node = find the parent of the last node
        int lastParentIndex = array.length / 2 - 1;

        // Build a heap by calling the sort method recursive - see below
        for (int i = lastParentIndex; i >= 0; i--)
            sort(array, i, array.length);

        // The heap is built
        // Now order the array
        for (int i = array.length - 1 ; i > 0; i--) {
            // The first item of the heap has the largest value
            // So we swap it to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Then we rebuild the heap again for the n - 1 items
            // the cycle until the entire array has been sorted
            sort(array, 0, i);
        }

    }

    private static void sort(int[] array, int index, int heapSize){
        var largerIndex  = index;

        // find the leftChild index
        var leftIndex = index * 2 + 1;
        // if the leftIndex inside the bound of the heap &&
        // the value of leftIndex is > then the current Value
        // set the largerIndex to this leftIndex
        if(leftIndex < heapSize &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        // Same logic applies to the right child
        var rightIndex = index * 2 + 2;
        if(rightIndex < heapSize &&
                array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        // If the current is already the largerIndex
        // no further comparison is needed
        if(index == largerIndex)
            return;

        // swap the value
        swap(array, index, largerIndex);

        // Call the sort() again
        // Starting at the upper level of the heap
        sort(array, largerIndex, heapSize);

    }

    private static void swap(int[] array, int first, int last){
        var temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }
}
