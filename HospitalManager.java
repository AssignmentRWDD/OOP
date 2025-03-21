import java.io.*;
import java.util.*;

public class HospitalManager {
    private static final String FILE_NAME = "hospitals.txt";

    public static void addHospital(Hospital hospital) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(hospital.toString());
            bw.newLine();
        } catch (IOException e) {
        }
    }

    public static Hospital searchHospital(String hospitalCode) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals(hospitalCode)) {
                    return new Hospital(details[0], details[1]);
                }
            }
        } catch (IOException e) {
        }
        return null; // Hospital not found
    }

    public static List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                hospitals.add(new Hospital(details[0], details[1]));
            }
        } catch (IOException e) {
        }
        return hospitals;
    }
}
