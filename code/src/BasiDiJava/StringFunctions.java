package BasiDiJava;

public class StringFunctions {
    public static void main(String[] args){
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
     * @param s a given word
     * @param target a given phrase
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
     * @param s a given word
     * @param target a given phrase
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
     * @param s a given string
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
