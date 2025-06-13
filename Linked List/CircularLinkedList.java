public class CircularLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
        return newNode;
    }

    

    public static Node insertAtPosition(Node head, int data, int pos) {
        if (pos <= 1) {
            return insertAtBeginning(head, data);
        }
        Node newNode = new Node(data);
        Node current = head;
        int count = 1;
        while (count < pos - 1 && current.next != head) {
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertAtBeginning(head, 10);
        
        head = insertAtPosition(head, 15, 2);
        head = insertAtPosition(head, 5, 1);
        head = insertAtPosition(head, 35, 10);
        display(head);
    }
}
