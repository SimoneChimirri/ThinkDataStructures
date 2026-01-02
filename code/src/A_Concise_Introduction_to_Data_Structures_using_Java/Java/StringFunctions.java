public class StringFunctions {
   // Listing 1.2
   public static int count(String s, String target) {
      int count = 0;
      int n = target.length();
      for (int i = 0; i <= s.length() - n; i++) {
         String piece = s.substring(i, i + n);
         if (piece.equals(target)) count++;
      }
      return count;
   }
   
   // Listing 1.4
   public static String acronym(String phrase) {
      StringBuilder result = new StringBuilder();
      for (String token : phrase.split("\\s+")) {
         result.append(token.toUpperCase().charAt(0));
      }
      return result.toString();
   }

   /**
    * Generates the acronym of a given phrase.
    * @param phrase - the given phrase
    * @return the acronym
    */
   public static String acronym2(String phrase) {
      StringBuilder result = new StringBuilder();
      for (int i =0; i < phrase.split("\\s+").length; i++) {
         result.append(phrase.split("\\s+")[i].toUpperCase().charAt(0));
      }
      return result.toString();
   }

   /**
    * Counts the occurrences of a target string
    * in a given string, ignoring case.
    * @param s - the given string
    * @param target - the target string
    * @return the number of occurrences
    */
   public static int countIgnoreCase(String s, String target) {
      int count = 0;
      int n = target.length();
      for (int i = 0; i <= s.length() - n; i++) {
         String piece = s.substring(i, i + n);
         if (piece.equalsIgnoreCase(target)) count++;
      }
      return count;
   }

   /**
    * Counts the occurrences of a target string
    * in a given string using a while loop and 
    * string method indexOf.
    * @param s - the given string
    * @param target - the target string
    * @return the number of occurrences
    */
   public static int count2(String s, String target) {
      int count = 0;
      int i = 0;
      int n = target.length();
      while(n <= s.length()) {
         int index = s.indexOf(target, i);
         if (index == -1) break;
         count++;
         s = s.substring(index + n);
         i = index + n;
      }
      return count;
   }
   
   public static void main(String[] args) {
      System.out.println("Number of this's: " +
         count("this and this and that and this", "this"));
      System.out.println("Number of this's: " +
         countIgnoreCase("This and this and that and This", "this"));
      System.out.println("Number of this's: " +
         count2("this and this and that and this", "this"));

      System.out.println("Acronym of 'As Soon As Possible': " +
         acronym("As Soon As Possible"));
         System.out.println("Acronym of 'As Soon As Possible': " +
         acronym2("As Soon As Possible"));

      String s = "Java programming language";
        System.out.println(s.length());
        System.out.println(s.charAt(2));
        System.out.println(s.substring(2,5));
        System.out.println(s.substring(3));
        String t = "abcd";
        if(s.equals(t)) System.out.printf("%s and %s are equals\n", s, t);
        if(!s.equals(t)) System.out.printf("%s and %s are not equals\n", s, t);
        if(s.compareToIgnoreCase(t) < 0) System.out.printf("%s comes before %s in alphabetical order\n", s, t);
        System.out.println(countWord(s,"java"));
        System.out.println(countWordIgnoreCase(s,"java"));
        System.out.println(reverse(s));
   }

   /**
     * Counts the occurrences of a given word in a phrase.
     * @param s - a given word
     * @param target - a given phrase
     * @return the number of occurrences
     */
    public static int countWord(String s, String target){
        int counter = 0;
        for(String token : s.split("\\s+")){
            if(token.equals(target)) counter ++;
        }
        return counter;
    }

    /**
     * Counts the occurrences of a given word in a phrase, ignoring case.
     * @param s - a given word
     * @param target - a given phrase
     * @return the number of occurrences
     */
    public static int countWordIgnoreCase(String s, String target){
        int counter = 0;
        for(String token : s.split("\\s+")){
            if(token.equalsIgnoreCase(target)) counter ++;
        }
        return counter;
    }

    /**
     * Reverses the order of characters in a given string.
     * @param s - a given string
     * @return the string reversed
     */
    public static String reverse(String s){
        StringBuilder builder = new StringBuilder();
        for(int i=s.length() - 1; i >= 0; i--){
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}