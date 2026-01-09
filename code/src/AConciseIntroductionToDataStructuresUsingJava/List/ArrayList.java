package AConciseIntroductionToDataStructuresUsingJava.List;

// For ArrayList class, Listing 6.1
public class ArrayList<E> implements List1<E> {

    private int size = 0;
    private E[] data;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (size == data.length) resize(2 * data.length);
        // shift right to make space
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = item;
        size++;
    }

    @Override
    public void add(E item){
        if (size == data.length) resize(2 * data.length);
        data[size] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        System.out.println("The array has been resized to capacity: " + newCapacity);
        data = newData;
    }

    @Override
    public E removeAt(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if(data.length >= 20 && size < data.length/4) resize(data.length / 2);
        E removedElement = data[index];
        // shift left to avoid space
        for (int i = index; i < size()- 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        return removedElement;
    }

    @Override
    public E set(int index, E item){
        E oldValue = data[index];
        data[index] = item;
        return oldValue;
    }

    @Override
    public E get(int index){
        return data[index];
    }

    @Override
    public int indexOf(E item){
        for(int i=0; i < size; i++){
            if(data[i] != null && data[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>(50);
        items.add(5);
        items.add(8);
        items.add(3);
        System.out.println(items.removeAt(1));
        items.add(10);
        items.add(4);
        System.out.println(items.removeAt(3));
        System.out.println(items.removeAt(1));

        ArrayList<Integer> items1 = new ArrayList<>(50);
        items1.add(1);
        System.out.println(items1.set(0, 2));
        items1.add(3);
        System.out.println(items1.set(0,4));
        System.out.println(items1.set(1,5));
        items1.add(6);
        System.out.println(items1.removeAt(1));
        System.out.println(items1.get(1));

        ArrayList<Integer> items2 = new ArrayList<>(50);
        items2.add(10);
        items2.add(0,20);
        items2.add(1,30);
        items2.add(0,40);
        items2.add(2,50);
        System.out.println(items2.indexOf(10));
        System.out.println(items2.indexOf(20));
        System.out.println(items2.indexOf(30));

        ArrayList<Integer> items3 = new ArrayList<>(20);
        items3.data = new Integer[]{1, 7, 2, 4, 1, 8, 9, 7};
        items3.size = 8;
        System.out.println(items3.size());
        System.out.println(items3.get(3));
        System.out.println(items3.indexOf(7));
        System.out.println(items3.removeAt(5));
        items3.add(0,3);
        items3.add(2,5);
        System.out.println(items3.removeAt(1));

        ArrayList<Integer> a = new ArrayList<>(10);
        for (int i=0; i < 10; i++){
            a.add(i);
        }

        ArrayList<Integer> b = new ArrayList<>(10);
        for (int i=9; i >= 0; i--){
            b.add(i);
        }
    }
}
