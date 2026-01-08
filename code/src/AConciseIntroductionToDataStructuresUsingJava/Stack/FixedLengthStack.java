package AConciseIntroductionToDataStructuresUsingJava.Stack;

public class FixedLengthStack<E> extends ArrayStack<E>{

    private int drops;

    public FixedLengthStack(int capacity) {
        super(capacity);
    }

    @Override
    public void push(E item) {
        if(size == capacity){
            drops++;
        } else {
            super.push(item);
        }
    }

    public int drops(){
        return this.drops;
    }

    public static void main(String[] args){

        Stack<String> operators = new FixedLengthStack<>(50);
        Stack<Integer> s = new FixedLengthStack<>(50);
        for (int i = 0; i < 9; i++) {
            s.push(i);
        }
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        Stack<Double> d = new FixedLengthStack<>(50);
        for (int i = 0; i < 25; i++) {
            d.push((double) i);
        }
        System.out.println(d.size());
        System.out.println(d.pop());
        System.out.println(d.size());
        System.out.println(d.peek());
        for (int i = 0; i < 22; i++) {
            operators.push("Java"+i);
        }
        System.out.println(operators.size());
        System.out.println(operators.pop());
        System.out.println(operators.size());
        System.out.println(operators.peek());


        FixedLengthStack<Integer> st = new FixedLengthStack<>(50); //Type Queue1 doesn't compile; Queue1 is not
        for (int i = 0; i < 100; i++) {                                   //the superclass of FixedLengthQueue
            st.push(i);
        }
        System.out.println(st.drops());
    }
}
