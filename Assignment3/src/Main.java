public class Main {
    public static void main(String[] args) {
        int [] array = {4,5,6,3,54,5,8,3,1};
        int [] array1 = {4,5,6,3,54,5,8,3,1};
        int [] array2 = {4,5,6,3,54,5,8,3,1};
        int [] array3 = {4,5,6,3,54,5,8,3,1};

        var selectionSort = new SelectionSort();
        selectionSort.sort(array);
        print(array);
        print(null);

        var heapSort = new HeapSort();
        heapSort.sort(array1);
        print(array1);
        print(null);

        var insertionSort = new InsertionSort();
        insertionSort.sort(array2);
        print(array2);
        print(null);

        var mergeSort = new MergeSort();
        mergeSort.sort(array3);
        print(array3);

    }

    private static void print(int[] array){
        if(array == null) {
            System.out.println();
            return;
        }

        for (var i :
                array) {
            System.out.print(i + " ");
        }
    }

}
