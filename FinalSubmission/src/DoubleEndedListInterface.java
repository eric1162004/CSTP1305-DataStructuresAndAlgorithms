public interface DoubleEndedListInterface <T>{

    public void addFirst(T value);

    public void addLast(T value);

    public T removeFirst();

    public T removeLast();

    public T getFirst();

    public T getLast();

    public void moveToEnd();
}
