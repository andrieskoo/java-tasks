package task3;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyQueue<T> {
    private int tail;
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException();
        }
        elements = new Object[capacity];
    }

    public MyQueue(){
        this(DEFAULT_CAPACITY);
    }

    public boolean add(T element){
        resizeIfNeed();
        elements[tail] = element;
        tail++;
        return true;
    }
    private void resizeIfNeed() {
        if(elements.length == tail){
            Object[] newArr = new Object[tail*2];
            System.arraycopy(elements, 0, newArr, 0, tail);
            elements = newArr;
        }
    }
    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public int size(){
        return tail;
    }
    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) elements[0];
    }
    @SuppressWarnings("unchecked")
    public T poll(){
        if (elements.length == 0){
            return null;
        }
        T returnedElement = (T)elements[0];
        System.arraycopy(elements, 1, elements, 0, tail-1);
        elements[tail] = null;
        tail--;
        return (T) returnedElement;
    }

}
