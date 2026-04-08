public class MyStack {
    private String[] arr;
    private int top;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        arr = new String[capacity];
        top = -1;
    }

    public void push(String s) {
        if (top < capacity - 1) arr[++top] = s;
    }

    public String pop() {
        return (top >= 0) ? arr[top--] : null;
    }

    public String peek() {
        return (top >= 0) ? arr[top] : null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            System.out.println("All transactions:");
            for (int i = 0; i <= top; i++) System.out.println(" - " + arr[i]);
        }
    }
}