package Heap;

public class MaxHeap {
    public static void heapify(int[] array){
        int lastParentIndex = array.length / 2 - 1;

        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index){
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if(leftIndex < array.length
                && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if(rightIndex < array.length
            && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if(index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public static int getKthLargest(int[] array, int k){
        var heap = new Heap();
        for(var number : array)
            heap.insert(number);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

    private static void swap(int[] array, int first, int last){
        int temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }
}
