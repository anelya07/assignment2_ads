public class RequestQueue {
    private Request[] arr;
    private int front, rear, count, capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        arr = new Request[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void add(Request r) {
        if (count < capacity) {
            rear = (rear + 1) % capacity;
            arr[rear] = r;
            count++;
        }
    }

    public Request poll() {
        if (isEmpty()) return null;
        Request res = arr[front];
        front = (front + 1) % capacity;
        count--;
        return res;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void printAll() {
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