import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String itemCode;
    private final String supplierOrHospitalCode;
    private final int quantity;
    private final String type; // "Received" or "Distributed"
    private final String dateTime;

    public Transaction(String itemCode, String supplierOrHospitalCode, int quantity, String type) {
        this.itemCode = itemCode;
        this.supplierOrHospitalCode = supplierOrHospitalCode;
        this.quantity = quantity;
        this.type = type;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return itemCode + "," + supplierOrHospitalCode + "," + quantity + "," + type + "," + dateTime;
    }
}
