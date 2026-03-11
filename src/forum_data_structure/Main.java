package forum_data_structure;

class Karyawan {

    void work() {
        System.out.println("Sedang bekerja di kantor");
    }
}

class Manager extends Karyawan {

    @Override
    void work() {
        System.out.println("Sedang bekerja di rumah");
    }
}

class Character {

    void jutsu() {
        System.out.println("Sedang melakukan jutsu");
    }
}

class Naruto extends Character {

    void rasengan() {
        System.out.println("Sedang melakukan rasengan");
    }
}

public class Main {
    public static void main(String[] args) {
        Naruto c = new Naruto();
        c.rasengan();
    }
}