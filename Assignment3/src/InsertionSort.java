public class InsertionSort implements ISortArray{

    @Override
    public void sort(int[] array) {

        // traverse the array from the second index to the end
        for (int i = 1; i < array.length; i++) {

            // save the value at i
            var current = array[i];
            // j is the index prior the i index
            var j = i - 1;

            // do a pairwise comparison
            // if value at j is larger, shift the value to the right
            // the loop stops when j < 0 or current value is greater the value at j
            while (j >= 0 && array[j] > current){
                array[j + 1] = array[j];
                j--;
            }

            // The correct position would be at j + 1
            array[j + 1] = current;
        }
    }

}
