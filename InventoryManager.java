import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InventoryManager {
    private static final String FILE_NAME = "ppe.txt";
    private static final String TRANSACTION_FILE = "transactions.txt";

    public static void updateInventory(String itemCode, int quantityChange, String supplierOrHospitalCode, String type) {
        List<PPEItem> items = loadInventory();
        boolean itemFound = false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (PPEItem item : items) {
                if (item.getItemCode().equals(itemCode)) {
                    if (type.equals("Distributed") && item.getQuantity() < quantityChange) {
                        System.out.println("Insufficient stock for distribution!");
                        return;
                    }
                    item.updateQuantity(quantityChange);
                    itemFound = true;
                }
                bw.write(item.getItemCode() + "," + item.getSupplierCode() + "," + item.getQuantity());
                bw.newLine();
            }
        } catch (IOException e) {
        }

        if (itemFound) {
            logTransaction(new Transaction(itemCode, supplierOrHospitalCode, quantityChange, type));
            System.out.println("Inventory updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public static List<PPEItem> loadInventory() {
        List<PPEItem> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                items.add(new PPEItem(details[0], details[1], Integer.parseInt(details[2])));
            }
        } catch (IOException e) {
        }
        return items;
    }

    public static void logTransaction(Transaction transaction) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true))) {
            bw.write(transaction.toString());
            bw.newLine();
        } catch (IOException e) {
        }
    }

    public static void displaySortedInventory() {
        List<PPEItem> items = loadInventory();
        items.sort(Comparator.comparing(PPEItem::getItemCode)); // Sort by item code

        System.out.println("Available PPE Items (Sorted by Item Code):");
        for (PPEItem item : items) {
            System.out.println(item.getItemCode() + " - " + item.getQuantity() + " boxes");
        }
    }

    public static void displayLowStockItems() {
        List<PPEItem> items = loadInventory();
        System.out.println("Low Stock PPE Items (Less than 50 boxes):");
        for (PPEItem item : items) {
            if (item.getQuantity() < 50) {
                System.out.println(item.getItemCode() + " - " + item.getQuantity() + " boxes");
            }
        }
    }

    public static List<PPEItem> getLowStockItems() {
        List<PPEItem> items = loadInventory();
        List<PPEItem> lowStockItems = new ArrayList<>();
        for (PPEItem item : items) {
            if (item.getQuantity() < 50) { // Define low stock as less than 50 boxes
                lowStockItems.add(item);
            }
        }
        return lowStockItems;
    }

    public static void trackReceivedItems(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);

        System.out.println("PPE Received Transactions from " + start + " to " + end + ":");
        try (BufferedReader br = new BufferedReader(new FileReader(TRANSACTION_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                String type = details[3];
                LocalDate transactionDate = LocalDate.parse(details[4].split(" ")[0], formatter);

                if (type.equals("Received") && (transactionDate.isEqual(startDate) || transactionDate.isEqual(endDate)
                        || (transactionDate.isAfter(startDate) && transactionDate.isBefore(endDate)))) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading transactions file: " + e.getMessage());
        }
    }
}
