package team_practicum.sistem_text_editor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        System.out.println("=========================================");
        System.out.println("   SISTEM EDITOR TEKS");
        System.out.println("=========================================");

        int pilihan;

        do {
            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("1. Tambah Teks (TextEditor)");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan Teks Saat Ini");
            System.out.println("0. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan teks: ");
                    String teks = scanner.nextLine();
                    editor.tambahTeks(teks);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    System.out.println("\nTeks saat ini: \"" + editor.getText() + "\"");
                    break;

                case 0:
                    System.out.println("\nTerima kasih telah menggunakan sistem ini!");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid! Silakan coba lagi.");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
