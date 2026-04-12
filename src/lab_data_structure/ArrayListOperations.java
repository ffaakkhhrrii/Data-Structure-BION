package lab_data_structure;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    private ArrayList<Integer> data;

    public ArrayListOperations(ArrayList<Integer> data) {
        this.data = data;
    }

    // Traversal - Menampilkan isi ArrayList
    public void showData(){
        if (data.isEmpty()) {
            System.out.println("ArrayList kosong");
            return;
        }
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i));
            if (i < data.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Mencari elemen dalam ArrayList (Linear Search)
    public void linearSearch(int value){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == value) {
                System.out.println("Pencarian " + value + " dalam ArrayList : Ditemukan di indeks " + i);
                return;
            }
        }

        System.out.println("Pencarian " + value + " dalam ArrayList : Tidak ditemukan");
    }

    // Binary Search
    public void binarySearch(int searchValue){
        int left = 0;
        int right = data.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data.get(mid) == searchValue) {
                System.out.println("Pencarian " + searchValue + " dalam ArrayList : Ditemukan di indeks " + mid);
                return;
            } else if (data.get(mid) < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Pencarian " + searchValue + " dalam ArrayList : Tidak ditemukan");
    }

    // Menambahkan elemen pada indeks tertentu
    public void insertAtIndex(int value, int index){
        if(index < 0 || index > data.size()){
            System.out.println("Indeks tidak valid");
            return;
        }
        data.add(index, value);
    }

    // Menghapus elemen berdasarkan nilai
    public void delete(int value){
        if (data.isEmpty()) {
            System.out.println("ArrayList kosong. Tidak ada elemen yang dapat dihapus");
            return;
        }

        data.remove(Integer.valueOf(value));
    }

    // Mengurutkan elemen dalam ArrayList (Ascending)
    public void sortAscending(){
        if (data.isEmpty()) {
            System.out.println("ArrayList kosong. Tidak ada elemen yang dapat diurutkan");
            return;
        }
        
        Collections.sort(data);
    }

    // Mendapatkan ukuran ArrayList
    public int getSize(){
        return data.size();
    }
}
