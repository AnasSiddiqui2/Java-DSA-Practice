class QueueArray {

    int[] queue;
    int front, rear, size;

    // Constructor
    QueueArray(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation → O(1) (Amortized)
    void enqueue(int data) {
        if (size == queue.length) {
            resize();
        }
        rear++;
        queue[rear] = data;
        size++;
        System.out.println(data + " enqueued");
    }

    // Resize array when full → O(n)
    void resize() {
        int newCapacity = queue.length * 2;
        int[] newQueue = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }

        queue = newQueue;
        System.out.println("Queue resized to capacity " + newCapacity);
    }

    // Dequeue operation → O(1)
    void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(queue[front] + " dequeued");
        front++;
        size--;
    }

    // Peek operation → O(1)
    void peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    // Display Queue → O(n)
    void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // Find minimum and maximum → O(n)
    void findMinMax() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        int min = queue[front];
        int max = queue[front];

        for (int i = front; i <= rear; i++) {
            if (queue[i] < min) min = queue[i];
            if (queue[i] > max) max = queue[i];
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    // Main method
    public static void main(String[] args) {
        QueueArray q = new QueueArray(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // This insertion causes resizing
        q.enqueue(40);

        q.display();
        q.peek();
        q.findMinMax();

        q.dequeue();
        q.display();
    }
}
