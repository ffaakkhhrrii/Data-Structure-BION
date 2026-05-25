package exam;

import java.util.LinkedList;
import java.util.Stack;

public class Shipment {
    private int id;
    private String recipientName;
    private ShipmentStatus currentStatus;
    private Stack<ShipmentStatus> statusStack; // Stack untuk menyimpan status sebelumnya
    private LinkedList<String> statusHistory; // LinkedList untuk menyimpan riwayat status

    public Shipment(int id, String recipientName) {
        this.id = id;
        this.recipientName = recipientName;
        this.currentStatus = ShipmentStatus.CREATED;
        this.statusStack = new Stack<>();
        this.statusHistory = new LinkedList<>();

        // catat status awal
        statusStack.push(ShipmentStatus.CREATED);
        statusHistory.add("Status awal: CREATED");
    }

    // Getters
    public int getId() { return id; }
    public ShipmentStatus getCurrentStatus() { return currentStatus; }
    public LinkedList<String> getStatusHistory() { return statusHistory; }

    public void updateStatus(ShipmentStatus newStatus) {
        statusStack.push(newStatus);
        currentStatus = newStatus;
        statusHistory.add("Update to : " + newStatus);
    }

    public void rollback() {
        if (statusStack.size() <= 1) {
            System.out.println("Tidak ada status sebelumnya untuk di-rollback.");
            return;
        }
        statusStack.pop(); // buang status sekarang
        currentStatus = statusStack.peek(); // ambil status sebelumnya
        statusHistory.add("Rollback to : " + currentStatus);
    }

    public void printHistory() {
        System.out.println("=== Riwayat Shipment #" + id + " ===");
        for (String record : statusHistory) {
            System.out.println(record);
        }
    }
}