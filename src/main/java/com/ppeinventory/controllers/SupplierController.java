import java.util.List;
import com.ppeinventory.models.Supplier;
import com.ppeinventory.services.SupplierService;

public class SupplierController {
    private SupplierService supplierService;

    public SupplierController() {
        this.supplierService = new SupplierService();
    }

    public void addSupplier(Supplier supplier) {
        supplierService.addSupplier(supplier);
    }

    public void updateSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);
    }

    public Supplier getSupplier(String supplierCode) {
        return supplierService.getSupplier(supplierCode);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    public void deleteSupplier(String supplierCode) {
        supplierService.deleteSupplier(supplierCode);
    }
}