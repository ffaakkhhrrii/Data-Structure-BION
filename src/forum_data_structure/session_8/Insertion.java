package forum_data_structure.session_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insertion {

    private static void tambahElement(Integer[] arr, int element, int position) {
        // Print inisialisasi array
        System.out.println("Before :\n" + Arrays.toString(arr));

        // Convert array menjadi ArrayList
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        // Menambahkan elemen pada posisi yang diinginkan (posisi dimulai dari 1)
        list.add(position - 1, element);

        // Convert kembali ke array
        arr = list.toArray(arr);

        // Print array setelah penambahan elemen
        System.out.println("\nArray dengan value " + element + " ditambahkan pada posisi " + position + ":\n" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Inisialisasi array
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Elemen yang ingin ditambahkan
        int element = 50;

        // Posisi di mana elemen akan ditambahkan (posisi dimulai dari 1)
        int position = 5;

        // Memanggil method untuk menambahkan elemen ke dalam array
        tambahElement(arr, element, position);
    }
}