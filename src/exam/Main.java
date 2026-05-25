package exam;

// Class ini saya gunakan sebagai simulasi pada sistem
public class Main {
    public static void main(String[] args) {
        TrackingSystem system = new TrackingSystem();

        // Tambah shipment
        Shipment s1 = new Shipment(1001, "Fakhri");
        Shipment s2 = new Shipment(1002, "Budi");
        system.addShipment(s1);
        system.addShipment(s2);

        // Proses sesuai urutan
        system.processShipment(); // proses s1 dulu (FIFO)

        // Update status
        system.updateStatus(1001, ShipmentStatus.PICKED_UP);
        system.updateStatus(1001, ShipmentStatus.IN_TRANSIT);

        // Simulasi human error lalu rollback
        system.updateStatus(1001, ShipmentStatus.DELIVERED); // salah input
        system.rollbackStatus(1001); // balik ke IN_TRANSIT

        // Cari shipment
        system.searchShipment(1001);

        // Lihat histori
        s1.printHistory();
    }
}
