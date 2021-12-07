package models;

public class Cars {
    private Integer id;
    private Integer year;
    private String make;
    private String model;
    private String vin;


    public Cars(){

    }

    public Cars(Integer id, Integer year, String make, String model, String vin) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vin = vin;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
