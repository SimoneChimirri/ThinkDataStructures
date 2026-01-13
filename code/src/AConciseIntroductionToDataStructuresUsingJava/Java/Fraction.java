package AConciseIntroductionToDataStructuresUsingJava.Java;

// Listing 1.5
public class Fraction implements Comparable<Fraction> {
   private int num;
   private int den;
   
   public Fraction(int num, int den) {
      if (den == 0) {
         throw new IllegalArgumentException("Denominator cannot be zero.");
      }
      if (den < 0) {
         num = -num;
         den = -den;
      }
      this.num = num;
      this.den = den;
   }
   
   public Fraction(int n) {
      this(n, 1);
   }
   
   public void addOn(Fraction f) {
      num = num * f.den + den * f.num;
      den *= f.den;
   }
   
   public static Fraction add(Fraction f1, Fraction f2) {
      int n = f1.num * f2.den + f1.den * f2.num;
      int d = f1.den * f2.den;
      return new Fraction(n, d);
   }

   public void subtractOff(Fraction f) {
      num = num * f.den - den * f.num;
      den *= f.den;
   }

   public void multiplyBy(Fraction f) {
      num = num * f.num;
      den = den * f.den;
   }

   public void divideBy(Fraction f) {
      num = num * f.den;
      den = den * f.num;
   }

   public void addOn(int n) {
      num = num + den * n;
   }

   public static Fraction subtract(Fraction f1, Fraction f2) {
      int n = f1.num * f2.den - f1.den * f2.num;
      int d = f1.den * f2.den;
      return new Fraction(n, d);
   }

   public static Fraction multiply(Fraction f1, Fraction f2) {
      int n = f1.num * f2.num;
      int d = f1.den * f2.den;
      return new Fraction(n, d);
   }

   public static Fraction divide(Fraction f1, Fraction f2) {
      int n = f1.num * f2.den;
      int d = f1.den * f2.num;
      return new Fraction(n, d);
   }

   public void reduce() {
      int gcd = NumericFunctions.gcd(num, den);
      num /= gcd;
      den /= gcd;
   }

   @Override
   public String toString() {
      return num + "/" + den;
   }

    @Override
    public int compareTo(Fraction other) {
        return Double.compare((double) num / (double) den, (double) other.num / (double) other.den);
    }
   
   public static void main(String[] args) {
      Fraction f1 = new Fraction(3, 4);
      Fraction f2 = new Fraction(1, 3);
      System.out.print(f1 + " + " + f2 + " = ");
      System.out.println(add(f1, f2));
      f1.addOn(f2);
      System.out.println("Using addOn() changes f1 to " + f1);
      Fraction f = new Fraction(5, 8);
      System.out.println("Fraction f is " + f);
      Fraction g = new Fraction(17, 3);
      System.out.println("Fraction g is " + g);
      Fraction h = add(f, g);
      System.out.println("Fraction h is " + h);
      Fraction j = new Fraction(5);
      System.out.println("Fraction j is " + j);
      g.addOn(new Fraction(5));
      System.out.println("Using addOn() changes g to " + g);
      g.subtractOff(f);
      System.out.println("Using subtractOff() changes g to " + g);
      g.multiplyBy(f);
      System.out.println("Using multiplyBy() changes g to " + g);
      g.divideBy(f);
      System.out.println("Using divideBy() changes g to " + g);
      System.out.print(f1 + " - " + f2 + " = ");
      System.out.println(subtract(f1, f2));
      System.out.print(f1 + " * " + f2 + " = ");
      System.out.println(multiply(f1, f2));
      System.out.print(f1 + " / " + f2 + " = ");
      System.out.println(divide(f1, f2));
   }

}