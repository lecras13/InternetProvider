package com.epam.web.entity.dto;

import com.epam.web.entity.Entity;
import com.epam.web.entity.Promotion;
import com.epam.web.entity.Role;
import com.epam.web.entity.TariffPlan;


public class UserDto implements Entity {
    private final Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Double totalAmount;
    private Boolean statusBlock;
    private Double traffic;
    private TariffPlan tariffPlan;
    private Promotion promotion;
    private Integer discount;

    public UserDto(Long id, String login, String password, String firstName, String lastName, Role role, Double totalAmount, Boolean statusBlock, Double traffic, TariffPlan tariffPlan, Promotion promotion, Integer discount) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.totalAmount = totalAmount;
        this.statusBlock = statusBlock;
        this.traffic = traffic;
        this.tariffPlan = tariffPlan;
        this.promotion = promotion;
        this.discount = discount;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getStatusBlock() {
        return statusBlock;
    }

    public void setStatusBlock(Boolean statusBlock) {
        this.statusBlock = statusBlock;
    }

    public Double getTraffic() {
        return traffic;
    }

    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    public TariffPlan getTariffPlan() {
        return tariffPlan;
    }

    public void setTariffPlan(TariffPlan tariffPlan) {
        this.tariffPlan = tariffPlan;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (login != null ? !login.equals(userDto.login) : userDto.login != null) return false;
        if (password != null ? !password.equals(userDto.password) : userDto.password != null) return false;
        if (firstName != null ? !firstName.equals(userDto.firstName) : userDto.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userDto.lastName) : userDto.lastName != null) return false;
        if (role != userDto.role) return false;
        if (totalAmount != null ? !totalAmount.equals(userDto.totalAmount) : userDto.totalAmount != null) return false;
        if (statusBlock != null ? !statusBlock.equals(userDto.statusBlock) : userDto.statusBlock != null) return false;
        if (traffic != null ? !traffic.equals(userDto.traffic) : userDto.traffic != null) return false;
        if (tariffPlan != null ? !tariffPlan.equals(userDto.tariffPlan) : userDto.tariffPlan != null) return false;
        if (promotion != null ? !promotion.equals(userDto.promotion) : userDto.promotion != null) return false;
        return discount != null ? discount.equals(userDto.discount) : userDto.discount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (statusBlock != null ? statusBlock.hashCode() : 0);
        result = 31 * result + (traffic != null ? traffic.hashCode() : 0);
        result = 31 * result + (tariffPlan != null ? tariffPlan.hashCode() : 0);
        result = 31 * result + (promotion != null ? promotion.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", totalAmount=" + totalAmount +
                ", statusBlock=" + statusBlock +
                ", traffic=" + traffic +
                ", tariffPlan=" + tariffPlan +
                ", promotion=" + promotion +
                ", discount=" + discount +
                '}';
    }
}
