package team_practicum.sistem_text_editor;

class StackNode {
    String text;
    StackNode next;

    public StackNode(String text) {
        this.text = text;
        this.next = null;
    }
}