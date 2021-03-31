import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        var maxRunSize = 10000;

        Thread t1 = new Thread(() -> benchMark(selectionSort::sort, "Selection Sort", maxRunSize));
        Thread t2 = new Thread(() -> benchMark(heapSort::sort, "Heap Sort", maxRunSize));
        Thread t3 = new Thread(() -> benchMark(insertionSort::sort, "Insertion Sort", maxRunSize));
        Thread t4 = new Thread(()->benchMark(mergeSort::sort, "Merge Sort",maxRunSize));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    public static void benchMark(ISortArray method, String methodName, int maxRunSize)
    {
        var results = new Long[maxRunSize];
        long startTime;
        long endTime;

        for (int i = 0; i < maxRunSize; i++) {
            var array = generateRandomNumbers(i, 1000);

            // System.out.println("unsorted" + Arrays.toString(array));

            startTime = System.nanoTime();
            method.sort(array);
            endTime = System.nanoTime();

            // System.out.println("sorted" + Arrays.toString(array));

            results[i] = endTime - startTime;
        }

        // var average = Arrays.stream(results).average().getAsDouble();
        var total = Arrays.stream(results).reduce((a, b) -> a + b );
        System.out.println(methodName + " total execution time: " + total + " ns");

        saveData(methodName+".txt", results);
        //print(results);
    }

    public static int[] generateRandomNumbers(int size, int upperRange){
        Random rd = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(rd.nextInt() % upperRange);
        }

        return arr;
    }

    public static void saveData(String fileName, Long[] results){
        BufferedWriter outputWriter = null;

        try {
            outputWriter = new BufferedWriter(new FileWriter(fileName));

            for (int i = 0; i < results.length; i++) {
                outputWriter.write(Long.toString(results[i]));
                outputWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(outputWriter != null) {
                try {
                    outputWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static <T> void print(T[] array){
        for (T i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

}
