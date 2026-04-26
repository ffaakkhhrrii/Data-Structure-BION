package team_practicum.sistem_text_editor;

import java.util.Stack;

class TextEditor {
    private StringBuilder text;
    private Stack<String> undoStack;   // Menyimpan snapshot sebelum perubahan
    private Stack<String> redoStack;   // Menyimpan perubahan yang di-undo

    public TextEditor() {
        this.text = new StringBuilder();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    // tambahkan teks baru
    public void tambahTeks(String teksBaru) {
        if (teksBaru == null || teksBaru.isEmpty()) {
            System.out.println("\nError: Teks tidak boleh kosong!");
            return;
        }
        
        // Simpan state sebelumnya untuk undo
        undoStack.push(text.toString());
        
        // Clear redo stack karena ada operasi baru
        redoStack.clear();

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