package list;

public interface List<E> {

  void add(E item);

  void add(int index, E item);

  E get(int index);

  int indexOf(E item);

  boolean isEmpty();

  E remove(E item);

  E remove(int index);

  E set(int index, E item);

  int size();
}