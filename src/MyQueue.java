public class MyQueue {
    private String[] arr;
    private int front, rear, count, capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new String[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void add(String s) {
        if (count < capacity) {
            rear = (rear + 1) % capacity;
            arr[rear] = s;
            count++;
        }
    }

    public String poll() {
        if (isEmpty()) return null;
        String res = arr[front];
        front = (front + 1) % capacity;
        count--;
        return res;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < count; i++) {
                int idx = (front + i) % capacity;
                System.out.print(arr[idx]);
                if (i < count - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}