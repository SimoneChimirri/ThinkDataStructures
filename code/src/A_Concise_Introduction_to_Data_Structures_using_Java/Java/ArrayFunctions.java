import java.util.Random;

public class ArrayFunctions {
   // Listing 1.3
   public static int linearSearch(int[] data, int target) {
      for (int i = 0; i < data.length; i++) {
         if (target == data[i]) return i;
      }
      return -1;
   }
   
   // Listing 2.1
   public static void insertionSort(int[] data) {
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
   
   // Listing 2.3
   public static int binarySearch(int[] data, int target) {
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
     * @param data an int array
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
     * @param data an int array
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
     * @param data an int array
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
     * @param data an int array
     */
    public static void display(int[] data){
        for(int n : data){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    /**
     * Searches a target string in a String array and returns its index.
     * @param target a target string
     * @param strings a String array
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
   
   public static void main(String[] args) {
      int[] data = {3, 14, 7, 22, 45, 12, 19, 42, 6};
      System.out.println("Search for 7: " +
            linearSearch(data, 7));
      System.out.println("Search for 100: " +
            linearSearch(data, 100));

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
   }
}