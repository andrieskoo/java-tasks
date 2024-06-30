import task1.MyArrayList;
import task2.MyLinkedList;
import task3.MyQueue;
import task4.MyStack;
import task5.MyHashMap;

public class Main {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("ms1");
        myStack.push("ms2");
        myStack.push("ms3");
        myStack.push("ms4");
        myStack.push("ms5");
        myStack.push("ms6");
        myStack.push("ms7");
        myStack.push("ms8");
        myStack.push("ms9");
        myStack.push("ms10");
        myStack.push("ms11");
        myStack.push("ms12");

        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack.size() = " + myStack.size());
        System.out.println("myStack.peek() = " + myStack.peek());



        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("mq1");
        myQueue.add("mq2");
        myQueue.add("mq3");
        myQueue.add("mq4");
        myQueue.add("mq5");
        myQueue.add("mq6");
        myQueue.add("mq7");
        myQueue.add("mq8");
        myQueue.add("mq9");
        myQueue.add("mq10");
        myQueue.add("mq11");
        myQueue.add("mq12");
        myQueue.add("mq13");
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println("myQueue.poll() = " + myQueue.poll());


        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("MHM1", 1);
        myHashMap.put("MHM2", 2);
        myHashMap.put("MHM3", 3);
        myHashMap.put("MHM4", 4);
        myHashMap.put("MHM5", 5);
        myHashMap.put("MHM6", 6);
        myHashMap.put("MHM7", 7);
        myHashMap.put("MHM8", 8);
        myHashMap.put("MHM9", 9);
        myHashMap.put("MHM10", 10);
        myHashMap.put("MHM11", 11);
        myHashMap.put("MHM12", 12);
        myHashMap.put("MHM13", 13);
        myHashMap.put("MHM14", 14);

        System.out.println("myHashMap.get(\"MHM1\") = " + myHashMap.get("MHM1"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.remove("MHM14");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.remove("MHM4");
        System.out.println("myHashMap.size() = " + myHashMap.size());


        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("One");
        myLinkedList.add("Two");
        myLinkedList.add("Three");
        myLinkedList.add("Four");
        System.out.println(myLinkedList);
        System.out.println("myLinkedList.get(2) = " + myLinkedList.get(2));
        myLinkedList.remove(1);
        System.out.println("myLinkedList = " + myLinkedList.get(2));


        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("jeden");
        myArrayList.add("dwa");
        myArrayList.add("trzy");
        myArrayList.add("cztery");

        System.out.println("myArrayList.size() = " + myArrayList.size());
        System.out.println("myArrayList.get(2) = " + myArrayList.get(2));

        System.out.println("myArrayList.remove(1) = " + myArrayList.remove(1));
        System.out.println("myArrayList.get(2) = " + myArrayList.get(2));

    }
}
