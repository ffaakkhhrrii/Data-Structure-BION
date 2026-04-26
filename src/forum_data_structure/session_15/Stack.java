package forum_data_structure.session_15;

class StackArray {
    int max = 5;
    int[] stack = new int[max];
    int top = -1;

    // push
    void push(int data) {
        if (top == max - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = data;
            System.out.println(data + " berhasil ditambahkan");
        }
    }

    // pop
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--] + " dihapus");
        }
    }

    // peek
    void peek() {
        if (top != -1) {
            System.out.println("Top element: " + stack[top]);
        }
    }

    // display
    void display() {
        System.out.print("Isi stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray s = new StackArray();

        s.push(10);
        s.push(20);
        s.push(30);
        s.display();

        s.pop();
        s.display();

        s.peek();
    }
}