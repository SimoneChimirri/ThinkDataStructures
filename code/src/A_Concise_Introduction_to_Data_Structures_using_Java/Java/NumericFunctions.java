public class NumericFunctions {
   // Listing 1.1
   public static int factorial(int n) {
      int result = 1;
      for (int i = 2; i <= n; i++) {
         result *= i;
      }
      return result;
   }

   /**
     * Calculates the power of m elevated to n.
     * @param m the base of the power
     * @param n the exponent of the power
     * @return the value of the power
     */
    public static int pow(int m, int n){
        for(int i=0; i < n; i++){
            m *= m;
        }
        return m;
    }

    /**
     * Returns the gcd of two int.
     * @param m a given int
     * @param n a given int
     * @return the value of gcd
     */
    public static int gcd(int m, int n){
        while(n>0){
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
   
   public static void main(String[] args) {
      for (int n = 1; n <= 10; n++) {
         System.out.print(n);
         System.out.print(" ");
         System.out.println(factorial(n));
      }

      for(int m=1; m < 10; m++){
            for(int n=1; n < 10; n++){
                System.out.println(pow(m,n));
            }
        }
        for(int m=2; m <= 10; m++){
            for(int n=2; n <= 10; n++){
                System.out.println(gcd(m,n));
            }
        }
   }
}