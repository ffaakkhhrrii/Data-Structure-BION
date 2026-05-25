package forum_data_structure.session_28;

public class HashTableLinearProbing {
    public static void main(String[] args) {

        int[] data = {72, 27, 36, 45, 63, 82, 94, 105};
        int size = 8;

        Integer[] hashTable = new Integer[size];

        for (int key : data) {

            int index = key % size;

            // Linear Probing
            while (hashTable[index] != null) {
                index = (index + 1) % size;
            }

            hashTable[index] = key;
        }

        // Tampilkan isi hash table
        System.out.println("Isi Hash Table:");

        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + " : " + hashTable[i]);
        }
    }
}