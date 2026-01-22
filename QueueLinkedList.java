class QueueLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;

    // Enqueue operation → O(1)
    void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(data + " enqueued");
    }

    // Dequeue operation → O(1)
    void dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println(front.data + " dequeued");
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Peek operation → O(1)
    void peek() {
        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Find minimum and maximum → O(n)
    void findMinMax() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        int min = front.data;
        int max = front.data;

        Node temp = front;
        while (temp != null) {
            if (temp.data < min)
                min = temp.data;
            if (temp.data > max)
                max = temp.data;
            temp = temp.next;
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    // Main method
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.peek();
        q.findMinMax();

        q.dequeue();
        q.peek();
    }
}
