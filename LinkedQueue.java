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

    // Constructor for the queue
    LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to insert data into the queue
    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Method to remove data from the queue
    public int deQueue() {
        if (isEmpty()) {
            return -1; // Return -1 if the queue is empty
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    // Method to display the current state of the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers to create nodes (enter a non-integer to exit):");
        // Input loop to create initial nodes
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int data = scanner.nextInt();
                queue.enQueue(data);
            } else {
                // When a non-integer is entered, break the loop
                String temp = scanner.next();
                break;
            }
        }

        // Display initial queue state
        System.out.println("Queue using Linked List created");
        System.out.println("Queue:");
        queue.displayQueue();

        // Menu for queue operations
        int ch, data;
        do {
            System.out.println("\n1. EnQueue");
            System.out.println("2. DeQueue");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter the element to insert:");
                    data = scanner.nextInt();
                    queue.enQueue(data);
                    System.out.println("After EnQueue:");
                    queue.displayQueue();
                    break;

                case 2:
                    data = queue.deQueue();
                    if (data != -1) {
                        System.out.println("Deleted Element: " + data);
                        System.out.println("After DeQueue:");
                        queue.displayQueue();
                    } else {
                        System.out.println("Queue is empty, cannot DeQueue.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (ch != 3);

        scanner.close();
    }
}
