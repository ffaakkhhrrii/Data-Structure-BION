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
        long startTime = System.nanoTime();
        
        if (teksBaru == null || teksBaru.isEmpty()) {
            System.out.println("\nError: Teks tidak boleh kosong!");
            return;
        }
        
        // Simpan state sebelumnya untuk undo
        undoStack.push(text.toString());
        
        // Clear redo stack karena ada operasi baru
        redoStack.clear();

        text.append(teksBaru);
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        System.out.println("Teks setelah tambah: \"" + text + "\"");
        System.out.println("Waktu: " + (executionTime / 1_000_000.0) + " ms");
    }

    // Undo
    public void undo() {
        long startTime = System.nanoTime();
        
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada operasi yang bisa di-undo.");
            return;
        }
        
        redoStack.push(text.toString());

        String previous = undoStack.pop();
        text = new StringBuilder(previous);
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        System.out.println("UNDO → Teks kembali ke: \"" + text + "\"");
        System.out.println("Waktu: " + (executionTime / 1_000_000.0) + " ms");
    }

    // Redo
    public void redo() {
        long startTime = System.nanoTime();
        
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada perubahan yang bisa di-redo.");
            return;
        }

        undoStack.push(text.toString());

        String next = redoStack.pop();
        text = new StringBuilder(next);
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        
        System.out.println("REDO → Teks: \"" + text + "\"");
        System.out.println("Waktu: " + (executionTime / 1_000_000.0) + " ms");
    }

    public String getText() {
        return text.toString();
    }
}