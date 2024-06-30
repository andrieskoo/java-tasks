package task4;

import java.util.Objects;

public class MyStack<T> {
    private int head;
    private int tail;
    private Object[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity){
        if (capacity <= 0){
            throw new IllegalArgumentException();
        }
        elements = new Object[capacity];
    }

    public MyStack(){
        this(DEFAULT_CAPACITY);
    }

    public boolean push(T element){
        resizeIfNeed();
        elements[tail] = element;
        tail++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index){
        Objects.checkIndex(index, tail);
        Object elementToRemove = elements[index];
        System.arraycopy(elements, index+1, elements, index, tail-index-1);
        elements[tail] = null;
        tail--;
        return (T) elementToRemove;
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
        return (T) elements[tail-1];
    }
    @SuppressWarnings("unchecked")
    public T pop(){
        if (elements.length == 0){
            return null;
        }
        T returnedElement = (T)elements[tail-1];
        System.arraycopy(elements, 0, elements, 0, tail-1);
        elements[tail-1] = null;
        tail--;
        return (T) returnedElement;
    }
}
