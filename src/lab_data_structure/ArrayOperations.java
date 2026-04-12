package lab_data_structure;

public class ArrayOperations {
    private int[] data;

    public ArrayOperations(int[] data) {
        this.data = data;
    }

    // Traversal - Menampilkan isi array
    public void showData(){
        if (data.length == 0) {
            System.out.println("Array kosong");
            return;
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Linear Search
    public void linearSearch(int searchValue) {
        for(int i = 0; i < data.length; i++){
            if(data[i] == searchValue){
                System.out.println("Pencarian " + searchValue + " dalam Array : Ditemukan di indeks " + i);
                return;
            }
        }

        System.out.println("Pencarian " + searchValue + " dalam Array : Tidak ditemukan");
    }

    // Binary Search
    public void binarySearch(int searchValue){
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == searchValue) {
                System.out.println("Pencarian " + searchValue + " dalam Array : Ditemukan di indeks " + mid);
                return;
            } else if (data[mid] < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Pencarian " + searchValue + " dalam Array : Tidak ditemukan");
    }

    // Penyisipan Nilai Array pada indeks tertentu
    public void insertAtIndex(int value, int index){
        if(index < 0 || index > data.length){
            System.out.println("Indeks tidak valid");
            return;
        }

        int[] newData = new int[data.length + 1];
        System.arraycopy(data, 0, newData, 0, index);
        newData[index] = value;
        System.arraycopy(data, index, newData, index + 1, data.length - index);

        data = newData;
    }

    // Penghapusan Nilai Array berdasarkan value
    public void delete(int value){
        if(data.length == 0){
            System.out.println("Array kosong");
            return;
        }

        int indexToDelete = -1;
        for(int i = 0; i < data.length; i++){
            if(data[i] == value){
                indexToDelete = i;
                break;
            }
        }

        if(indexToDelete == -1){
            System.out.println("Nilai " + value + " tidak ditemukan dalam Array");
            return;
        }

        int[] newData = new int[data.length - 1];
        System.arraycopy(data, 0, newData, 0, indexToDelete);
        System.arraycopy(data, indexToDelete + 1, newData, indexToDelete, data.length - indexToDelete - 1);

        data = newData;
    }

    // Sorting (Bubble Sort)
    public void sortAscending() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Mengembalikan panjang array
    public int getLength() {
        return data.length;
    }
}
