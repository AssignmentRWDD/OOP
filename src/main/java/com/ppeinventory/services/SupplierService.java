package com.ppeinventory.services;

import com.ppeinventory.models.Supplier;
import com.ppeinventory.utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierService {

    private static final String SUPPLIER_FILE = "src/main/resources/suppliers.txt";

    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(SUPPLIER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    suppliers.add(new Supplier(data[0].trim(), data[1].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    public void addSupplier(Supplier supplier) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SUPPLIER_FILE, true))) {
            bw.write(supplier.getSupplierCode() + "," + supplier.getName());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSupplier(Supplier supplier) {
        List<Supplier> suppliers = getAllSuppliers();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SUPPLIER_FILE))) {
            for (Supplier s : suppliers) {
                if (s.getSupplierCode().equals(supplier.getSupplierCode())) {
                    bw.write(supplier.getSupplierCode() + "," + supplier.getName());
                } else {
                    bw.write(s.getSupplierCode() + "," + s.getName());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSupplier(String supplierCode) {
        List<Supplier> suppliers = getAllSuppliers();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SUPPLIER_FILE))) {
            for (Supplier s : suppliers) {
                if (!s.getSupplierCode().equals(supplierCode)) {
                    bw.write(s.getSupplierCode() + "," + s.getName());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}