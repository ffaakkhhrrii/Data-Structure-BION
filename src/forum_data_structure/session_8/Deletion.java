package forum_data_structure.session_8;

import java.util.Arrays;

public class Deletion {

    public static void main(String[] args) {
        int[] data = new int[]{11, 12, 13, 14, 15};
        int[] newData = new int[data.length - 1];
        int j = 3; // hapus data index ketiga

        for (int i = 0, k = 0; i < data.length; i++) {
            if (i != j) {
                newData[k] = data[i];
                k++;
            }
        }

        System.out.println("Sebelum penghapusan :" + Arrays.toString(data));
        System.out.println("Setelah penghapusan :" + Arrays.toString(newData));

    }
}