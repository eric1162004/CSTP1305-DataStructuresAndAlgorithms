public class MergeSort implements ISortArray{

    @Override
    public void sort(int[] array) {
        // Base Case: the array only has one item
        if(array.length < 2)
            return;

        // Divide the array into half
        var middleIndex = array.length / 2;

        // Create the left array
        int[] left = new int[middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            // copy value to the left array
            left[i] = array[i];
        }

        // Create the right array
        int[] right = new int[array.length - middleIndex];
        for (int i = middleIndex; i < array.length; i++) {
            right[i - middleIndex] = array[i];
        }

        // Sort each half recursive
        // Until each array has one item left
        sort(left);
        sort(right);

        // Merge the left and right array back into one
        merge(left, right, array);
    }

    private static int[] merge(int[] left, int[] right, int[] result){
        // create iterator counter
        // for the left(i), right(j) and result(k) arrays
        int i = 0, j = 0, k = 0;

        // This is where the sorting happens
        // If both left and right arrays have items
        // compare the first item of the left array
        // to the first item of the right array
        // Add the smaller value to the result array
        // then increment the iterator counters
        while (i < left.length && j < right.length){
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        // In case the left array has left over
        // Add the items to the results
        while (i < left.length)
            result[k++] = left[i++];

        // same logic applies to the right array
        while(j < right.length)
            result[k++] = right[j++];

        // Return the merged result
        return result;
    }
}
