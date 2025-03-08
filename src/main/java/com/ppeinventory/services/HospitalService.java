package com.ppeinventory.services;

import com.ppeinventory.models.Hospital;
import com.ppeinventory.utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalService {

    private static final String HOSPITAL_FILE = "src/main/resources/hospitals.txt";

    public void addHospital(Hospital hospital) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HOSPITAL_FILE, true))) {
            writer.write(hospital.getHospitalCode() + "," + hospital.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(HOSPITAL_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    hospitals.add(new Hospital(data[0], data[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hospitals;
    }

    public void updateHospital(Hospital hospital) {
        List<Hospital> hospitals = getAllHospitals();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HOSPITAL_FILE))) {
            for (Hospital h : hospitals) {
                if (h.getHospitalCode().equals(hospital.getHospitalCode())) {
                    writer.write(hospital.getHospitalCode() + "," + hospital.getName());
                } else {
                    writer.write(h.getHospitalCode() + "," + h.getName());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteHospital(String hospitalCode) {
        List<Hospital> hospitals = getAllHospitals();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HOSPITAL_FILE))) {
            for (Hospital h : hospitals) {
                if (!h.getHospitalCode().equals(hospitalCode)) {
                    writer.write(h.getHospitalCode() + "," + h.getName());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}