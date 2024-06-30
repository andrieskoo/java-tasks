package task1;


import java.util.Objects;

public class MyArrayList <T>{
        private int size;

        private static final int DEFAULT_CAPACITY = 10;

        private Object[] elements;

        public MyArrayList(int capacity){
                if (capacity <= 0){
                        throw new IllegalArgumentException();
                }
            elements = new Object[capacity];
        }

        public MyArrayList(){
                this(DEFAULT_CAPACITY);
        }

        public boolean add(T value){
                resizeIfNeed();
                elements[size] = value;
                size++;
        return true;
        }

        private void resizeIfNeed() {
                if(elements.length == size){
                        Object[] newArr = new Object[size*2];
                        System.arraycopy(elements, 0, newArr, 0, size);
                        elements = newArr;
                }
        }


        @SuppressWarnings("unchecked")
        public T remove(int index){
                Objects.checkIndex(index, size);
                Object elementToRemove = elements[index];
                System.arraycopy(elements, index+1, elements, index, size-index-1);
                elements[size] = null;
                size--;
        return (T) elementToRemove;
        }

        public void clear(){
                elements = new Object[DEFAULT_CAPACITY];
                size = 0;
        }

        public int size(){
        return size;
        }

        @SuppressWarnings("unchecked")
        public T get(int index){
        return (T) elements[index];
        }

}
