public class Hospital {
    private final String hospitalCode;
    private final String name;

    public Hospital(String hospitalCode, String name) {
        this.hospitalCode = hospitalCode;
        this.name = name;
    }

    public String getHospitalCode() { return hospitalCode; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return hospitalCode + "," + name;
    }
}
