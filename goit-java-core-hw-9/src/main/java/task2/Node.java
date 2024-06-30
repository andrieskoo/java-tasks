package task2;

public class Node <T>{
    private Node prev;
    private Node next;
    private T value;

    private Node(){}

    public Node(Node prev, Node next, T value){
        this.prev = prev;
        this.next = prev;
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node<T> getNexNode(){
        return next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node<T> getPrevNode(){
        return prev;
    }

    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        this.value=value;
    }
}
