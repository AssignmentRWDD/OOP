import java.util.List;
import com.ppeinventory.models.Item;
import com.ppeinventory.services.InventoryService;

public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController() {
        this.inventoryService = new InventoryService();
    }

    public void updateItemQuantity(String itemCode, String supplierCode, int quantity, boolean isReceived) {
        if (isReceived) {
            inventoryService.increaseItemQuantity(itemCode, supplierCode, quantity);
        } else {
            if (inventoryService.checkItemAvailability(itemCode, quantity)) {
                inventoryService.decreaseItemQuantity(itemCode, supplierCode, quantity);
            } else {
                System.out.println("Insufficient stock for item: " + itemCode);
            }
        }
    }

    public List<Item> getAllItems() {
        return inventoryService.getAllItems();
    }

    public List<Item> getLowStockItems() {
        return inventoryService.getItemsBelowReorderQuantity();
    }

    public List<Item> getItemsReceivedInTimeFrame(String startDate, String endDate) {
        return inventoryService.getItemsReceivedInTimeFrame(startDate, endDate);
    }

    public void trackItem(String itemCode) {
        inventoryService.trackItem(itemCode);
    }
}