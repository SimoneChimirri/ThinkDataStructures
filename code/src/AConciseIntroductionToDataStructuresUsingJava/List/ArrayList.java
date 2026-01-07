package AConciseIntroductionToDataStructuresUsingJava.List;
/**
// For ArrayList class, Listing 6.1
public class ArrayList {
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

    public static void main(String[] args) {
    }
}
 */