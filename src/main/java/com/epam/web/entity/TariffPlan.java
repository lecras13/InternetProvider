package com.epam.web.entity;

public class TariffPlan extends Entity {
    private String tariffName;
    private Integer price;
    private String prescription;


    public TariffPlan(Long id, String tariffName, Integer price, String prescription) {
        super(id);
        this.tariffName = tariffName;
        this.price = price;
        this.prescription = prescription;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setDescription(String description) {
        this.prescription = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        TariffPlan that = (TariffPlan) o;

        if (tariffName != null ? !tariffName.equals(that.tariffName) : that.tariffName != null){
            return false;
        }
        if (price != null ? !price.equals(that.price) : that.price != null){
            return false;
        }
        return prescription != null ? prescription.equals(that.prescription) : that.prescription == null;
    }

    @Override
    public int hashCode() {
        int result = tariffName != null ? tariffName.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (prescription != null ? prescription.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "tariffName='" + tariffName + '\'' +
                ", price=" + price +
                ", description='" + prescription + '\'' +
                '}';
    }
}
