package BasiDiJava;

public class ArrayFunctions {
    public static void main(String[] args){
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
}
