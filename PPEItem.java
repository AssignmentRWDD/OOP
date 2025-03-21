public class PPEItem {
    private final String itemCode;
    private String supplierCode;
    private int quantity;

    public PPEItem(String itemCode, String supplierCode, int quantity) {
        this.itemCode = itemCode;
        this.supplierCode = supplierCode;
        this.quantity = quantity;
    }

    public PPEItem(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() { return itemCode; }
    public String getSupplierCode() { return supplierCode; }
    public int getQuantity() { return quantity; }

    public void updateQuantity(int change) {
        this.quantity += change;
    }
}
