package task2;


public class MyLinkedList <T>{
        private Node<T> first;
        private Node<T> last;
        private int size = 0;

    /**
     * додає елемент в кінець
     * @param value
     * @return true if element added
     */
        public boolean add(T value){
            if(first == null){
                first = new Node<>(null, null, value);
                size++;
            } else if (last == null) {
                last = new Node<>(first, null, value);
                first.setNext(last);
                size++;
            }
            else {
                Node<T> newNode = new Node<>(last, null, value);
                last.setNext(newNode);
                last = newNode;
                size++;
            }
            return true;
        }

        public boolean remove(int index){
            Node<T> nodeToDelete = getNode(index);
            Node<T> prev = nodeToDelete.getPrevNode();
            Node<T> next = nodeToDelete.getNexNode();
            prev.setNext(next);
            next.setPrev(prev);
            nodeToDelete = null;
            size--;
            return true;
        }

        public boolean clear(){
            Node<T> current = first;
            for (int i=0; i<size; i++){
                Node<T> next = current.getNexNode();
                current.setValue(null);
                current.setPrev(null);
                current.setNext(null);
                current = next;
            }
            first = null;
            last = null;
            size = 0;
            return true;
        }

        public int size(){
            return size;
        }

        public T get(int index){
            return getNode(index).getValue();
        }

    public Node<T> getNode(int index){
        Node<T> currentNode = first;
        if (index>size){
            throw new IndexOutOfBoundsException();
        }
        for (int i=0; i<index; i++){
            currentNode = currentNode.getNexNode();
        }
        return currentNode;
    }

}
