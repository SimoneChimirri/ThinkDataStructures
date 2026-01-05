public class ArrayStack<E> implements Stack<E> {
   private E[] data;
   private int top = -1;
   private int size;
   private static final int DEFAULT_CAPACITY = 10;
    
   @SuppressWarnings("unchecked")
   public ArrayStack() {
      data = (E[]) new Object[DEFAULT_CAPACITY];
   }
   
   @Override
   public E pop() {
      E result = data[top];
      data[top--] = null;
      return result;
   }

   @Override
    public boolean isEmpty() {
      return top == -1;
    }

    @Override
    public E peek() {
      return data[top];
    }

    @Override
    public void push(E item) {
      if (size == data.length) resize(2 * data.length);
      size = size + 1;
      data[size - 1] = item;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
      E[] newData = (E[]) new Object[newCapacity];
      System.arraycopy(data, 0, newData, 0, size);
      System.out.println("The array has been resized to capacity: " + newCapacity);
      data = newData;
    }

    public static void main(String[] args) {
        
        Stack<String> operators = new ArrayStack<>();
        Stack<Integer> operands = new ArrayStack<>();
        Stack<Integer> s = new ArrayStack<>();
        for (int i = 0; i < 9; i++) {
            s.push(i);
        }
    }

}