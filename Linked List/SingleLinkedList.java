public class SingleLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev=null;

        }
    }

    
    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }
    
    public void display(Node head)
{
    if(head == null) {
        System.out.println("List is empty");
        
    }
    Node temp=head;
    while(temp != null) {
        System.out.print(temp.data + "-> ");
        temp = temp.next;
    }
    System.out.println("null");

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
    public static Node insertNthposition(Node head,int data,int position){
        Node newNode = new Node(data);
        if(position==0){
            newNode.next=head;
            head=newNode;
            return head;
        }
        Node temp = head;
        for(int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if(temp == null) {
            System.out.println("Position is out of bounds");
           return head;
        }
        newNode.next = temp.next;
        temp.next = newNode; 
        return head;
    }

    public static int countNode(Node head) {
        if (head == null) {
            return 0;
        }
        int count=0;
        Node temp=head;
        for(temp=head;temp!=null;temp=temp.next){
            count++;
        }
        return count;

    }
    public static void main(String[] args) {
        SingleLinkedList ll= new SingleLinkedList();
        
        
        Node head = null;
        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 20);
        head = insertAtBeginning(head, 30);
        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);
        head= insertNthposition(head, 80, 2);
        ll.display(head);
        System.out.print(countNode(head));
    }
}