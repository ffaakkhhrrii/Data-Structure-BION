package exam;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TrackingSystem {
    private HashMap<Integer, Shipment> shipmentMap;  // untuk pencarian cepat
    private Queue<Shipment> processingQueue;          // untuk urutan kedatangan

    public TrackingSystem() {
        this.shipmentMap = new HashMap<>();
        this.processingQueue = new LinkedList<>();
    }

    // Tambah shipment baru ke sistem
    public void addShipment(Shipment shipment) {
        shipmentMap.put(shipment.getId(), shipment);
        processingQueue.offer(shipment);
        System.out.println("Shipment #" + shipment.getId() + " ditambahkan ke sistem.");
    }

    // Proses shipment sesuai urutan kedatangan (FIFO)
    public void processShipment() {
        if (processingQueue.isEmpty()) {
            System.out.println("Tidak ada shipment yang perlu diproses.");
            return;
        }
        Shipment shipment = processingQueue.poll();
        System.out.println("Memproses shipment #" + shipment.getId() + " | Status: " + shipment.getCurrentStatus());
    }

    // Update status shipment berdasarkan ID
    public void updateStatus(int id, ShipmentStatus newStatus) {
        Shipment shipment = shipmentMap.get(id);
        if (shipment == null) {
            System.out.println("Shipment #" + id + " tidak ditemukan.");
            return;
        }
        shipment.updateStatus(newStatus);
        System.out.println("Shipment #" + id + " diupdate ke: " + newStatus);
    }

    // Rollback status terakhir
    public void rollbackStatus(int id) {
        Shipment shipment = shipmentMap.get(id);
        if (shipment == null) {
            System.out.println("Shipment #" + id + " tidak ditemukan.");
            return;
        }
        shipment.rollback();
        System.out.println("Shipment #" + id + " di-rollback ke: " + shipment.getCurrentStatus());
    }

    // Pencarian shipment berdasarkan nomor resi
    public Shipment searchShipment(int id) {
        Shipment shipment = shipmentMap.get(id);
        if (shipment == null) {
            System.out.println("Shipment #" + id + " tidak ditemukan.");
            return null;
        }
        System.out.println("Ditemukan - Shipment #" + id + " | Status: " + shipment.getCurrentStatus());
        return shipment;
    }
}