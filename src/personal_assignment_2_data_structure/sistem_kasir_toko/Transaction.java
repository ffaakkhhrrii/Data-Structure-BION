package personal_assignment_2_data_structure.sistem_kasir_toko;

public class Transaction {
    private String nomorAntrian;
    private String namaPelanggan;
    private double totalBelanja;
    private String waktuTransaksi;

    public Transaction(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.waktuTransaksi = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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

    public String getWaktuTransaksi() {
        return waktuTransaksi;
    }

    @Override
    public String toString() {
        return "No: " + nomorAntrian + " | Nama: " + namaPelanggan + " | Total: Rp" + String.format("%,.0f", totalBelanja) + " | Waktu: " + waktuTransaksi;
    }
}

