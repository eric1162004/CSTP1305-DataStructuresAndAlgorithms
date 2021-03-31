public class MergeSort implements ISortArray{

    @Override
    public void sort(int[] array) {
        // Base Case
        if(array.length < 2)
            return;

        // Divide the array into half
        var middleIndex = array.length / 2;

        int[] left = new int[middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middleIndex];
        for (int i = middleIndex; i < array.length; i++) {
            right[i - middleIndex] = array[i];
        }

        // Sort each half recursive
        sort(left);
        sort(right);

        // Merge the result
        merge(left, right, array);
    }

    private static int[] merge(int[] left, int[] right, int[] result){
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while(j < right.length)
            result[k++] = right[j++];

        return result;
    }
}
