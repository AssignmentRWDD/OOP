public class Supplier {
    private final String supplierCode;
    private final String name;

    public Supplier(String supplierCode, String name) {
        this.supplierCode = supplierCode;
        this.name = name;
    }

    public String getSupplierCode() { return supplierCode; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return supplierCode + "," + name;
    }
}
