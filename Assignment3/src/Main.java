import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var selectionSort = new SelectionSort();
        var heapSort = new HeapSort();
        var insertionSort = new InsertionSort();
        var mergeSort = new MergeSort();

        var numberOfRuns = 1000;

        Thread t1 = new Thread(() -> benchMark(selectionSort::sort, "Selection Sort", numberOfRuns));
        Thread t2 = new Thread(() -> benchMark(heapSort::sort, "Heap Sort", numberOfRuns));
        Thread t3 = new Thread(() -> benchMark(insertionSort::sort, "Insertion Sort", numberOfRuns));
        Thread t4 = new Thread(()->benchMark(mergeSort::sort, "Merge Sort",numberOfRuns));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    public static void benchMark(ISortArray method, String methodName, int numberOfRuns)
    {
        var results = new long[numberOfRuns];
        long startTime;
        long endTime;

        for (int i = 0; i < numberOfRuns; i++) {
            var array = generateRandomNumbers(10000, 1000);

            // System.out.println("unsorted" + Arrays.toString(array));

            startTime = System.currentTimeMillis();
            method.sort(array);
            endTime = System.currentTimeMillis();

            // System.out.println("sorted" + Arrays.toString(array));

            results[i] = endTime-startTime;
        }

        var average = Arrays.stream(results).average().getAsDouble();
        var total = Arrays.stream(results).sum();

/*        System.out.println(methodName + " execution stats:");
        System.out.println("=================================");
        System.out.println("Number of Runs: " + numberOfRuns);
        System.out.println("Average execution time: " + average + "ms");*/
        System.out.println(methodName + " total execution time: " + total + "ms");
    }

    public static int[] generateRandomNumbers(int size, int upperRange){
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(rd.nextInt() % upperRange);
        }
        return arr;
    }

    private static void print(int[] array){
        for (var i :
                array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
