package com.ppeinventory.controllers;

import com.ppeinventory.models.Hospital;
import com.ppeinventory.services.HospitalService;

import java.util.List;

public class HospitalController {
    private HospitalService hospitalService;

    public HospitalController() {
        this.hospitalService = new HospitalService();
    }

    public void addHospital(Hospital hospital) {
        hospitalService.addHospital(hospital);
    }

    public void updateHospital(Hospital hospital) {
        hospitalService.updateHospital(hospital);
    }

    public void deleteHospital(String hospitalCode) {
        hospitalService.deleteHospital(hospitalCode);
    }

    public Hospital getHospital(String hospitalCode) {
        return hospitalService.getHospital(hospitalCode);
    }

    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }
}