import java.util.Arrays;

class Queue {

    public static int count, capacity, front, queue[];

    public Queue(int capacity) {
        this.count = -1;
        this.front = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public boolean isEmpty() {
        return (count == -1);
    }

    public boolean isFull() {
        return (count == capacity - 1);
    }

    public void offer(int value) {
        queue[++count] = value;
    }

    public int poll() {
        front = queue[0];
        for (int i = 0; i < count; i++) {
            queue[i] = queue[i + 1];
        }
        queue[count--] = 0;
        return front;
    }

    public void sort() {
        Arrays.sort(queue);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nThe queue is empty.");
            return;
        }
        else {
            System.out.println("\nEnumerating queue from front to tail...");
            for (int i = 0; i < count + 1; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.print("\n");
        }
    }
}
