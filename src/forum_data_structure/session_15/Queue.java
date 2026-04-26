package forum_data_structure.session_15;

class QueueArray {
    int max = 5;
    int[] queue = new int[max];
    int front = 0;
    int rear = -1;
    int size = 0;

    // enqueue
    void enqueue(int data) {
        if (size == max) {
            System.out.println("Queue penuh");
        } else {
            queue[++rear] = data;
            size++;
            System.out.println(data + " masuk ke queue");
        }
    }

    // dequeue
    void dequeue() {
        if (size == 0) {
            System.out.println("Queue kosong");
        } else {
            System.out.println(queue[front] + " keluar dari queue");
            front++;
            size--;
        }
    }

    // peek
    void peek() {
        if (size != 0) {
            System.out.println("Elemen depan: " + queue[front]);
        }
    }

    // display
    void display() {
        System.out.print("Isi queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();

        q.peek();
    }
}