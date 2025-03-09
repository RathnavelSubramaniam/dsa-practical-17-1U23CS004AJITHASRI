import java.util.*;
public class LinkedQueue {
    class Node {
        int data;
        Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
        }
    }
    Node front;
    Node rear;
    LinkedQueue() 
    { 
        this.front = null; 
        this.rear  = null;
    }
    public boolean isEmpty()
    {
        if(front==null)
        return true;
        else
        return false;
    }
    public void enQueue(int data) 
    {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        else
        {
        rear.next = newNode;
        rear = newNode;
        }
    }
    public int deQueue() 
    {
       int data=-1;
       if (isEmpty()) {
       System.out.print("\nQueue Underflow");
    }
    else
    {
        Node temp = front;
        data=temp.data;
        front = front.next;
    }
        if (front == null)
        rear = null;
        return data;
        }
public static void main(String[] args) {
    LinkedQueue queue = new LinkedQueue();
        Scanner scanner = new Scanner(System.in);
        int ch,data, c;
        System.out.println("Enter integers to create nodes (enter a non-integer to exit):");
        while (scanner.hasNext()) {
        if(scanner.hasNextInt())
          {
        data = scanner.nextInt();
        queue.enQueue(data);
        }
        else
        {
        String temp=scanner.next();
        System.out.println("Queue using Linked List created");
        System.out.println("Queue");
        queue.displayQueue();
        do
        {
    System.out.println("1.EnQueue");
    System.out.println("2.DeQueue");
    System.out.println("3.Exit");
    System.out.println("Enter your choice:"); 
    ch= scanner.nextInt();
    switch(ch)
    {
        case 1: 
            System.out.println("Enter the element to insert:");
            data=scanner.nextInt();
            queue.enQueue(data);
            System.out.println("After EnQueue");
            queue.displayQueue();
            break;
        case 2:
            data=queue.deQueue();
            if(data!=-1)
            {
            System.out.println("Deleted Element:"+data);
            System.out.println("After DeQueue");
            queue.displayQueue();
            }
            break;
       case 3:
            System.exit(0);  
}}while(ch<3);
}
        }
scanner.close();
}
public void displayQueue() {
       Node current = front;
       while (current != null) {
       System.out.print(current.data + " -> ");
       current = current.next;
       }
System.out.println("null");
}
}