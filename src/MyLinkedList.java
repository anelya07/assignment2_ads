public class MyLinkedList {
    private Node head;
    private int size;

    private static class Node {
        BankAccount data;
        Node next;
        Node(BankAccount data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(BankAccount acc) {
        Node newNode = new Node(acc);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public BankAccount get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public BankAccount findByUsername(String username) {
        Node current = head;
        while (current != null) {
            if (current.data.getUsername().equals(username)) return current.data;
            current = current.next;
        }
        return null;
    }

    public void printAll() {
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.data.getUsername() + " – Balance: " + current.data.getBalance());
            current = current.next;
            count++;
        }
    }
}