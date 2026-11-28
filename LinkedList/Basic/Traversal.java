package LinkedList.Basic;

public class Traversal {


    public static class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void insertAtEnd(int value) {
        Node temp = new Node(value);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }
    public static void insertAtStrart(int value){
        Node temp=new Node(value);
        if(tail==null){
            tail=temp;
            head=temp;
        }
        else{
            temp.next=head;
            head=temp;
        }
    }

    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static int countNodes(){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        insertAtEnd(10);
        insertAtEnd(20);
        insertAtEnd(30);
        insertAtEnd(40);
        insertAtEnd(50);

        insertAtStrart(100);
        insertAtStrart(200);
        insertAtStrart(300);
        insertAtStrart(400);


        display();
        System.out.println(countNodes());
    }

}
