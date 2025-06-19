public class SingleLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node insertAtBeginning(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head= newNode;
        return head;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static Node insertNthposition(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static Node deleteAtBeginning(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static Node deleteAtend(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteAtPosition(Node head, int position) {
        if (head == null || position < 0) {
            return null;
        }
        if (position == 0) {
            return deleteAtBeginning(head);
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static Node reversell(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node middlelement(Node head) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element is: " + slow.data);
        return slow;
    }

    public static Node removeDuplicates(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static Node mergetwosortedll(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;
        return dummy.next;
    }

    public static int nthNodeFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) 
            return -1;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Node mid = middlelement(head);
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static int interactionpoint(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }
        return (temp1 != null) ? temp1.data : -1;
    }

    public static Node detectandremoveloop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        Node loopNode = slow;
        Node prev = null;
        while (fast.next != loopNode) {
            prev = fast;
            fast = fast.next;
        }
        if (prev != null) prev.next = null;
        return loopNode;
    }

    public static Node rotatekplacesNode(Node head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        k = k % length;
        int skipLength = length - k;
        Node newTail = head;
        for (int i = 0; i < skipLength - 1; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static Node deleteNodewithouthead(Node node) {
        if (node == null || node.next == null) return null;
        node.data = node.next.data;
        node.next = node.next.next;
        return node;
    }

    public static Node removeloop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) return head;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        Node loopNode = slow;
        Node prev = null;
        while (fast.next != loopNode) {
            prev = fast;
            fast = fast.next;
        }
        if (prev != null) prev.next = null;
        return head;
    }

    public static boolean checkiftwoidentical(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }

    public static Node findFirstNode(Node head) {
        if (head == null) return null;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static int countNode(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }   

    public static void main(String[] args) {
        SingleLinkedList ll = new SingleLinkedList();
        Node head = null;
        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 30);
        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);
        head = insertNthposition(head, 80, 2);
        head = deleteAtBeginning(head);
        head = deleteAtend(head);
        head = deleteAtPosition(head, 3);
        head = reversell(head);
        middlelement(head);
        head = removeDuplicates(head);
        ll.display(head);
        System.out.print(countNode(head));
        System.out.println("\nReversed Linked List:");
        ll.display(reversell(head));
        System.out.println("\nnth node from end:" + nthNodeFromEnd(head, 2));
        System.out.println(deleteNodewithouthead(head.next));
        System.out.println("Rotate k places:");
        Node rotatedHead = rotatekplacesNode(head, 2);
        ll.display(rotatedHead);



        Node head2 = null;
        head2 = insertAtBeginning(head2, 5);
        head2 = insertAtBeginning(head2, 15);
        head2 = insertAtBeginning(head2, 25);
        head2 = insertAtEnd(head2, 35);
        head2 = insertAtEnd(head2, 45);

        Node mergedHead = mergetwosortedll(head, head2);
        System.out.println("Merged Sorted Linked List:");
        ll.display(mergedHead);
        System.out.println("Is Palindrome: " + isPalindrome(head));
        System.out.println("Interaction Point: " + interactionpoint(head, head2));
        System.out.println("Check if two linked lists are identical: " + checkiftwoidentical(head, head2));
        Node firstNode = findFirstNode(head);
        System.out.println("First Node: " + firstNode);

        Node loopNode = new Node(100);
        head2.next.next.next = loopNode;
        loopNode.next = head2.next;
        detectandremoveloop(head2);
        System.out.println("Loop detected and removed in second list.");
        System.out.println("After removing loop:");
        ll.display(head2);

    }
}
