package com.ppeinventory.models;

public class Supplier {
    private String supplierCode;
    private String name;

    public Supplier(String supplierCode, String name) {
        this.supplierCode = supplierCode;
        this.name = name;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierCode='" + supplierCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}