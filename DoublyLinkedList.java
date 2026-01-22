class DoublyLinkedList {

    class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
        }
    }

    Node head, tail;

    // Insert at beginning → O(1)
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end → O(1)
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Forward traversal → O(n)
    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Backward traversal → O(n)
    void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Delete first node → O(1)
    void deleteFirst() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete last node → O(1)
    void deleteLast() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Delete by value → O(n)
    void deleteByValue(int value) {
        Node temp = head;

        while (temp != null && temp.data != value)
            temp = temp.next;

        if (temp == null) return;

        if (temp == head)
            deleteFirst();
        else if (temp == tail)
            deleteLast();
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Delete node before given value → O(n)
    void deleteBeforeValue(int value) {
        Node temp = head;

        while (temp != null && temp.data != value)
            temp = temp.next;

        if (temp == null || temp.prev == null) return;

        deleteByValue(temp.prev.data);
    }

    // Delete node after given value → O(n)
    void deleteAfterValue(int value) {
        Node temp = head;

        while (temp != null && temp.data != value)
            temp = temp.next;

        if (temp == null || temp.next == null) return;

        deleteByValue(temp.next.data);
    }

    // Find min & max → O(n)
    void findMinMax() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        int min = head.data;
        int max = head.data;
        Node temp = head;

        while (temp != null) {
            if (temp.data < min) min = temp.data;
            if (temp.data > max) max = temp.data;
            temp = temp.next;
        }

        System.out.println("Min: " + min + " Max: " + max);
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insertions
        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(5);
        dll.insertAtEnd(50);

        // Display
        dll.displayForward();
        dll.displayBackward();

        // Deletions
        dll.deleteFirst();
        dll.deleteLast();
        dll.deleteBeforeValue(30);
        dll.deleteAfterValue(30);
        dll.deleteByValue(20);

        // Min & Max
        dll.findMinMax();
    }
}
