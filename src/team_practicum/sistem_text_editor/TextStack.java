package team_practicum.sistem_text_editor;

class TextStack {
    private StackNode top;

    public void push(String text) {
        StackNode newNode = new StackNode(text);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (top == null) return null;
        String data = top.text;
        top = top.next;
        return data;
    }

    public String peek() {
        if (top == null) return null;
        return top.text;
    }

    public boolean isEmpty() {
        return top == null;
    }
}