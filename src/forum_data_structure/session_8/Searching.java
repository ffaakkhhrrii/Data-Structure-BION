package forum_data_structure.session_8;

public class Searching {

    static int cariData(int[] arr, int n, int key) {
        for (int i = 0; i < n; i++)
            if (arr[i] == key) return i;

        // Jika data tidak ditemukan
        return -1;
    }

    public static void main(String args[]) {
        int[] data = {54, 33, 221, 667, 2029};
        int n = data.length;

        // Data yang ingin dicari
        int key = 221;

        // Mencari data menggunakan linear search
        int position = cariData(data, n, key);

        if (position == -1) System.out.println("Element tidak ditemukan");
        else System.out.println("Element ditemukan pada posisi: " + (position + 1));
    }
}