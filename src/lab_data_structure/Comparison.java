package lab_data_structure;

import java.util.ArrayList;

public class Comparison {
    
    public static void main(String[] args) {
        System.out.println("Comparison Array and ArrayList");
        System.out.println();
        
        // Data
        // Generate 1000 data
        int[] arrayData = generateData(1000);
        int[] arrayForSort = generateRandomData(1000);
        ArrayList<Integer> arrayListData = new ArrayList<>();
        ArrayList<Integer> arrayListDataForSort = new ArrayList<>();

        for (int val : arrayData) {
            arrayListData.add(val);
        }

        for(int val : arrayForSort){
            arrayListDataForSort.add(val);
        }
        
        // Jalankan benchmark
        traversal(arrayData, arrayListData);
        linearSearch(arrayData, arrayListData);
        binarySearch(arrayData, arrayListData);
        insertion(arrayData, arrayListData);
        deletion(arrayData, arrayListData);
        sorting(arrayForSort, arrayListDataForSort);
        
        System.out.println("Selesai.");
    }

    // Generate data berurutan untuk traversal dan searching
    static int[] generateData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }
        return data;
    }

    // Generate random data untuk sorting
    static int[] generateRandomData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (int)(Math.random() * 10000);
        }
        return data;
    }

    // Benchmark Traversal (menjalankan method showData() untuk Array dan ArrayList)
    static void traversal(int[] arrayData, ArrayList<Integer> arrayListData) {
        System.out.println("1. Traversal:");

        ArrayOperations arrayOps = new ArrayOperations(arrayData);
        System.out.print("Array: ");
        long start1 = System.nanoTime();
        arrayOps.showData();
        long end1 = System.nanoTime();
        System.out.println("Waktu: " + (end1 - start1) / 1_000_000.0 + " ms");

        ArrayListOperations arrayListOps = new ArrayListOperations(arrayListData);
        System.out.print("ArrayList: ");
        long start2 = System.nanoTime();
        arrayListOps.showData();
        long end2 = System.nanoTime();
        System.out.println("Waktu: " + (end2 - start2) / 1_000_000.0 + " ms");
        System.out.println();
    }

    // Benchmark Linear Search (menjalankan method linearSearch() untuk Array dan ArrayList)
    static void linearSearch(int[] arrayData, ArrayList<Integer> arrayListData) {
        System.out.println("2. Linear Search :");
        
        ArrayOperations arrayOps = new ArrayOperations(arrayData);
        long start1 = System.nanoTime();
        arrayOps.linearSearch(500);
        long end1 = System.nanoTime();
        System.out.println("Waktu Array: " + (end1 - start1) / 1_000_000.0 + " ms");
        
        ArrayListOperations arrayListOps = new ArrayListOperations(arrayListData);
        long start2 = System.nanoTime();
        arrayListOps.linearSearch(500);
        long end2 = System.nanoTime();
        System.out.println("Waktu ArrayList: " + (end2 - start2) / 1_000_000.0 + " ms");
        System.out.println();
    }

    // Benchmark Binary Search (menjalankan method binarySearch() untuk Array dan ArrayList)
    static void binarySearch(int[] arrayData, ArrayList<Integer> arrayListData) {
        System.out.println("3. Binary Search :");

        ArrayOperations arrayOps = new ArrayOperations(arrayData);
        long start1 = System.nanoTime();
        arrayOps.binarySearch(500);
        long end1 = System.nanoTime();
        System.out.println("Waktu Array: " + (end1 - start1) / 1_000_000.0 + " ms");

        ArrayListOperations arrayListOps = new ArrayListOperations(arrayListData);
        long start2 = System.nanoTime();
        arrayListOps.binarySearch(500);
        long end2 = System.nanoTime();
        System.out.println("Waktu ArrayList: " + (end2 - start2) / 1_000_000.0 + " ms");
        System.out.println();
    }

    // Benchmark Insertion (menjalankan method insertAtIndex() untuk Array dan ArrayList)
    static void insertion(int[] arrayData, ArrayList<Integer> arrayListData) {
        System.out.println("4. Insertion :");
        
        ArrayOperations arrayOps = new ArrayOperations(arrayData.clone());
        long start1 = System.nanoTime();
        arrayOps.insertAtIndex(9999, 500);
        long end1 = System.nanoTime();
        System.out.println("Array size setelah insert: " + arrayOps.getLength());
        System.out.println("Waktu: " + (end1 - start1) / 1_000_000.0 + " ms");
        
        ArrayList<Integer> arrayListData2 = new ArrayList<>(arrayListData);
        ArrayListOperations arrayListOps = new ArrayListOperations(arrayListData2);
        long start2 = System.nanoTime();
        arrayListOps.insertAtIndex(9999, 500);
        long end2 = System.nanoTime();
        System.out.println("ArrayList size setelah insert: " + arrayListOps.getSize());
        System.out.println("Waktu: " + (end2 - start2) / 1_000_000.0 + " ms");
        System.out.println();
    }

    // Benchmark Deletion (menjalankan method delete() untuk Array dan ArrayList)
    static void deletion(int[] arrayData, ArrayList<Integer> arrayListData) {
        System.out.println("5. Deletion :");
        
        ArrayOperations arrayOps = new ArrayOperations(arrayData.clone());
        long start1 = System.nanoTime();
        arrayOps.delete(500);
        long end1 = System.nanoTime();
        System.out.println("Array size setelah delete: " + arrayOps.getLength());
        System.out.println("Waktu: " + (end1 - start1) / 1_000_000.0 + " ms");
        
        ArrayList<Integer> arrayListData2 = new ArrayList<>(arrayListData);
        ArrayListOperations arrayListOps = new ArrayListOperations(arrayListData2);
        long start2 = System.nanoTime();
        arrayListOps.delete(500);
        long end2 = System.nanoTime();
        System.out.println("ArrayList size setelah delete: " + arrayListOps.getSize());
        System.out.println("Waktu: " + (end2 - start2) / 1_000_000.0 + " ms");
        System.out.println();
    }

    // Benchmark Sorting (menjalankan method sortAscending() untuk Array dan ArrayList)
    static void sorting(int[] arrayData, ArrayList<Integer> arrayListData) {
        System.out.println("6. Sorting :");

        ArrayOperations arrayOps = new ArrayOperations(arrayData.clone());
        long start1 = System.nanoTime();
        arrayOps.sortAscending();
        long end1 = System.nanoTime();
        System.out.print("Array : ");
        arrayOps.showData();
        System.out.println("Waktu: " + (end1 - start1) / 1_000_000.0 + " ms");

        ArrayList<Integer> arrayListData2 = new ArrayList<>(arrayListData);
        ArrayListOperations arrayListOps = new ArrayListOperations(arrayListData2);
        long start2 = System.nanoTime();
        arrayListOps.sortAscending();
        long end2 = System.nanoTime();
        System.out.print("ArrayList : ");
        arrayListOps.showData();
        System.out.println("Waktu: " + (end2 - start2) / 1_000_000.0 + " ms");
        System.out.println();
    }
}
