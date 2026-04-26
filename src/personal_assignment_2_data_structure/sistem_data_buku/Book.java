package personal_assignment_2_data_structure.sistem_data_buku;

public class Book {
    private String kodeBuku;
    private String judul;
    private String penulis;

    public Book(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    @Override
    public String toString() {
        return "Kode: " + kodeBuku + " | Judul: " + judul + " | Penulis: " + penulis;
    }
}

