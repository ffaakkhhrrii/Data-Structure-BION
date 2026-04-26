package personal_assignment_2_data_structure.sistem_kasir_toko;

public class Transaction {
    private String nomorAntrian;
    private String namaPelanggan;
    private double totalBelanja;

    public Transaction(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
    }

    public String getNomorAntrian() {
        return nomorAntrian;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public double getTotalBelanja() {
        return totalBelanja;
    }

    @Override
    public String toString() {
        return "No: " + nomorAntrian + " | Nama: " + namaPelanggan + " | Total: Rp" + String.format("%,.0f", totalBelanja);
    }
}

