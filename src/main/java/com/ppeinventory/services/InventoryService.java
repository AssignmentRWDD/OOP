package com.ppeinventory.services;

import com.ppeinventory.models.Item;
import com.ppeinventory.utils.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    private static final String PPE_FILE = "src/main/resources/ppe.txt";
    private static final String TRANSACTIONS_FILE = "src/main/resources/transactions.txt";

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            items = FileUtil.readItemsFromFile(PPE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void updateItemQuantity(String itemCode, int quantityChange, String supplierOrHospitalCode) {
        List<Item> items = getAllItems();
        for (Item item : items) {
            if (item.getItemCode().equals(itemCode)) {
                item.setQuantityInStock(item.getQuantityInStock() + quantityChange);
                logTransaction(itemCode, supplierOrHospitalCode, quantityChange);
                break;
            }
        }
        saveItems(items);
    }

    private void logTransaction(String itemCode, String supplierOrHospitalCode, int quantity) {
        String transactionRecord = String.format("%s,%s,%d,%s%n", itemCode, supplierOrHospitalCode, quantity, java.time.LocalDateTime.now());
        try {
            FileUtil.appendToFile(TRANSACTIONS_FILE, transactionRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveItems(List<Item> items) {
        try {
            FileUtil.writeItemsToFile(PPE_FILE, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getLowStockItems(int threshold) {
        List<Item> lowStockItems = new ArrayList<>();
        for (Item item : getAllItems()) {
            if (item.getQuantityInStock() < threshold) {
                lowStockItems.add(item);
            }
        }
        return lowStockItems;
    }

    public Item getItemByCode(String itemCode) {
        for (Item item : getAllItems()) {
            if (item.getItemCode().equals(itemCode)) {
                return item;
            }
        }
        return null;
    }
}