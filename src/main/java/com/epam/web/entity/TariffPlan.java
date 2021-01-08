package com.epam.web.entity;

public class TariffPlan implements Entity {
    private final Long id;
    private String tariffName;
    private Integer price;
    private String description;

    public TariffPlan(Long id, String tariffName, Integer price, String description) {
        this.id = id;
        this.tariffName = tariffName;
        this.price = price;
        this.description = description;
    }

    @Override
    public Long getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffPlan that = (TariffPlan) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tariffName != null ? !tariffName.equals(that.tariffName) : that.tariffName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tariffName != null ? tariffName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "id=" + id +
                ", tariffName='" + tariffName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
