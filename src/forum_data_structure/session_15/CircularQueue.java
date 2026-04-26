package forum_data_structure.session_15;

class CircularQueue {
    int size = 5;
    int[] queue = new int[size];
    int front = -1, rear = -1;

    // enqueue
    void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue penuh");
        } else if (front == -1) {
            front = rear = 0;
            queue[rear] = data;
        } else {
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
        System.out.println(data + " masuk ke queue");
    }

    // dequeue
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue kosong");
        } else {
            System.out.println(queue[front] + " keluar dari queue");
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
        }
    }

    // display
    void display() {
        if (front == -1) {
            System.out.println("Queue kosong");
            return;
        }

        System.out.print("Isi queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();

        q.dequeue();
        q.dequeue();

        q.enqueue(60);
        q.enqueue(70);
        q.display();
    }
}