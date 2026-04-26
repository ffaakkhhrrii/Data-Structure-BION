package team_practicum.sistem_text_editor;

class TextEditor {
    private StringBuilder text;
    private TextStack undoStack;   // menyimpan snapshot sebelum perubahan
    private TextStack redoStack;   // menyimpan perubahan yang di-undo

    public TextEditor() {
        this.text = new StringBuilder();
        this.undoStack = new TextStack();
        this.redoStack = new TextStack();
    }

    // tambahkan teks baru
    public void tambahTeks(String teksBaru) {
        undoStack.push(text.toString());
        redoStack = new TextStack();

        text.append(teksBaru);
        System.out.println("Teks setelah tambah: \"" + text + "\"");
    }

    // Undo
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada operasi yang bisa di-undo.");
            return;
        }
        
        redoStack.push(text.toString());

        String previous = undoStack.pop();
        text = new StringBuilder(previous);
        System.out.println("UNDO → Teks kembali ke: \"" + text + "\"");
    }

    // Redo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada perubahan yang bisa di-redo.");
            return;
        }

        undoStack.push(text.toString());

        String next = redoStack.pop();
        text = new StringBuilder(next);
        System.out.println("REDO → Teks: \"" + text + "\"");
    }

    public String getText() {
        return text.toString();
    }
}