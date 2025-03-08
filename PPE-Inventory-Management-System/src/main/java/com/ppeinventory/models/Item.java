package com.ppeinventory.models;

public class Item {
    private String itemCode;
    private String supplierCode;
    private int quantityInStock;

    public Item(String itemCode, String supplierCode, int quantityInStock) {
        this.itemCode = itemCode;
        this.supplierCode = supplierCode;
        this.quantityInStock = quantityInStock;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}