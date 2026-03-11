package forum_data_structure.session_7;

public class Main {
    public static void main(String[] args) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        System.out.println("Using For Loop");
        for (int k=0; k < days.length ;k++) {
            System.out.println(days[k]);
        }

        System.out.println("Using Do While Loop");
        int i = 0;
        do {
            System.out.println(days[i]);
            i++;
        } while (i < days.length);

        String[][] address = {{"Florence", "735-1234", "Manila"}, {"Joyce", "983-3333", "Quezon City"}, {"Becca", "456-3322", "Manila"}};
        System.out.println("Buku Alamat saya");
        for (String[] strings : address) {
            System.out.println("Name: " + strings[0]);
            System.out.println("Tel.#: " + strings[1]);
            System.out.println("Address: " + strings[2]);
            System.out.println();
        }
    }
}
