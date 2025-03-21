import java.io.*;
import java.util.*;

public class SupplierManager {
    private static final String FILE_NAME = "suppliers.txt";

    public static void addSupplier(Supplier supplier) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(supplier.toString());
            bw.newLine();
        } catch (IOException e) {
        }
    }

    public static Supplier searchSupplier(String supplierCode) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals(supplierCode)) {
                    return new Supplier(details[0], details[1]);
                }
            }
        } catch (IOException e) {
        }
        return null; // Supplier not found
    }

    public static List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                suppliers.add(new Supplier(details[0], details[1]));
            }
        } catch (IOException e) {
        }
        return suppliers;
    }
}
