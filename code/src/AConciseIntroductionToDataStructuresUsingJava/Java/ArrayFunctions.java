package AConciseIntroductionToDataStructuresUsingJava.Java;

import java.util.Random;

public class ArrayFunctions {
    // Listing 1.3 - complexity-time is linear - O(n)
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (target == data[i]) return i;
        }
        return -1;
    }

    // Listing 2.1
    public static void insertionSort(int[] data) { // O(n^2) - complexity-time is quadratic
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && key < data[j]) {
            data[j + 1] = data[j];
            j--;
            }
            data[j + 1] = key;
        }
    }

    // Listing 2.2
    public static void randomFill(int[] data, int max) {
        Random gen = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = gen.nextInt(max);
        }
    }

    // Listing 2.3 - complexity-time is logarithmic - O(log n)
    public static int binarySearch(int[] data, int target) {//data must be sorted - non-decreasing order
        int left = 0;
        int right = data.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == data[mid]) {
            return mid;
            } else if (target < data[mid]) {
            right = mid - 1;
            } else {
            left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Calculates the sum of the elements of a given int array.
     * @param data - an int array
     * @return the value of the sum
     */
    public static int sum(int[] data){
    int sum = 0;
    for(int n : data){
        sum += n;
    }
    return sum;
    }

    /**
     * Finds out the max value of the elements of a given int array.
     * @param data - an int array
     * @return the max value
     */
    public static int max(int[] data){
    int max = Integer.MIN_VALUE;
    for(int n : data){
        if(n > max) max = n;
    }
    return max;
    }

    /**
     * Finds out the min value of the elements of a given int array.
     * @param data - an int array
     * @return the min value
     */
    public static int min(int[] data){
    int min = Integer.MAX_VALUE;
    for(int n : data){
        if(n < min) min = n;
    }
    return min;
    }

    /**
     * Prints the elements of a given int array on a single line.
     * @param data - an int array
     */
    public static void display(int[] data){
    for(int n : data){
        System.out.print(n + " ");
    }
    System.out.println();
    }

    /**
     * Searches a target string in a String array and returns its index.
     * @param target - a target string
     * @param strings - a String array
     * @return the index of the first target string if present,
     *         -1 otherwise
     */
    public static int linearSearch(String target, String[] strings){
    int index = -1;
    for(int i=0; i < strings.length; i++){
        if(strings[i].equals(target)) return i;
    }
    return index;
    }

    /**
     * Checks if the elements of a given int array are sorted in
     * non-decreasing order.
     * @param data - an int array
     * @return true if the array is sorted, false otherwise
     */
    public static boolean isSorted(int[] data){
    for(int i=1; i < data.length; i++){
        if(data[i] < data[i-1]) return false;
    }
    return true;
    }

    /**
     * Fills a given int array with random int values.
     * @param data - an int array
     */
    public static void randomFill(int[] data) {
    Random gen = new Random();
    for (int i = 0; i < data.length; i++) {
        data[i] = gen.nextInt();
    }
    }

    public static void selectionSort(int[] data) {// complexity-time is quadratic - O(n^2)
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the first element
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {3, 14, 7, 22, 45, 12, 19, 42, 6};
        System.out.println("Search for 7: " +
            linearSearch(data, 7));
        System.out.println("Search for 100: " +
            linearSearch(data, 100));
        for(int n : data){
            System.out.println(n);
        }

        int[] counts = {18, 3, 9, 22, 11, 4};
        double[] times = {1.52, 1.98, 1.44, 1.63, 1.67};
        boolean[] visible = {true, false, false, true, false};
        String[] names = {"Alice", "Bob", "Carol", "Dave"};
        for(int i  : counts){
            System.out.println(i);
        }
        for(double time : times){
            System.out.println(time);
        }
        for(boolean isVisible : visible){
            System.out.println(isVisible);
        }
        for(String name : names){
            System.out.println(name);
        }

        System.out.println(sum(counts));
        System.out.println(max(counts));
        System.out.println(min(counts));
        display(counts);
        System.out.println(linearSearch("Carol",names));
        insertionSort(data);
        display(data);
        int [] data2 = new int[100];
        randomFill(data2,Integer.MAX_VALUE);
        display(data2);
        System.out.println(isSorted(data2));
        System.out.println(isSorted(data));
        int [] data3 = new int[100];
        randomFill(data3);
        display(data3);
        for(int i=100; i <= 200000; i*=2){//complexity-time is constant -> O(n)
            int[] arr = new int[i];
            long start = System.currentTimeMillis();
            randomFill(arr);
            long elapsed = System.currentTimeMillis() - start;
            System.out.printf("Time to fill an array of %d elements: %d ms\n",
                i, elapsed);
        }
        System.out.println(sum(data3));
        System.out.println(max(data3));
        System.out.println(min(data3));
        display(data3);
        for(int i=100; i <= 200000; i*=2){//complexity-time is quadratic -> O(n^2)
            int[] arr = new int[i];
            randomFill(arr);
            long start = System.currentTimeMillis();
            selectionSort(arr);
            long elapsed = System.currentTimeMillis() - start;
            System.out.printf("Time to sort by selection an array of %d elements: %d ms\n",
                i, elapsed);
        }
        for(int i=100; i <= 200000; i*=2){//complexity-time is quadratic -> O(n^2)
            int[] arr = new int[i];
            randomFill(arr);
            long start = System.currentTimeMillis();
            insertionSort(arr);
            long elapsed = System.currentTimeMillis() - start;
            System.out.printf("Time to sort by insertion an array of %d elements: %d ms\n",
                i, elapsed);//insertion sort is faster than selection sort
        }
        int[] array = {2, 5, 7, 10, 22, 31, 34, 40};
        System.out.println("Binary search for 31: " +
            binarySearch(array, 31));
        System.out.println("Binary search for 2: " +
            binarySearch(array, 2));
        System.out.println("Binary search for 17: " +
            binarySearch(array, 17));
        System.out.println("Binary search for 50: " +
            binarySearch(array, 50));
        System.out.println("Binary search for 1: " +
            binarySearch(array, 1));
        System.out.println("Binary search for 34: " +
            binarySearch(array, 34));
        int[] arr1 = {10, 13, 24, 36, 37, 41, 44, 66, 86, 100};
        System.out.println("Binary search for 25: " +
            binarySearch(arr1, 25));
        System.out.println("Binary search for 24: " +
            binarySearch(arr1, 24));
        System.out.println("Binary search for 86: " +
            binarySearch(arr1, 86));
        System.out.println("Binary search for 99: " +
            binarySearch(arr1, 99));
        System.out.println("Binary search for 100: " +
            binarySearch(arr1, 100));
        System.out.println("Binary search for 8: " +
            binarySearch(arr1, 8));
        System.out.println("Binary search for 10: " +
            binarySearch(data, 10));
    }
}