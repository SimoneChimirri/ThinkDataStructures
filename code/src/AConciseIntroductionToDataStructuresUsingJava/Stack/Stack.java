package AConciseIntroductionToDataStructuresUsingJava.Stack;

import AConciseIntroductionToDataStructuresUsingJava.Tree.Collection;

public interface Stack<E> extends Collection<E> {
   boolean isEmpty();
   E peek();
   E pop();
   void push(E item);
   int size();
   int size = 0;
}
