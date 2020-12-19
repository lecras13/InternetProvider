package com.epam.web.entity;

public class User extends Entity {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Integer totalAmount;
    private Boolean statusBlock;
    private Integer traffic;
    private Integer tariffPlanId;
    private String tariffPlanName;
    private Integer promotionId;
    private Integer discount;


    public User() {
    }

    public User(Long id, String login, String password, String firstName, String lastName, Role role, Integer totalAmount, Boolean statusBlock, Integer traffic, Integer tariffPlanId, String tariffPlanName, Integer promotionId, Integer discount) {
        super(id);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.totalAmount = totalAmount;
        this.statusBlock = statusBlock;
        this.traffic = traffic;
        this.tariffPlanId = tariffPlanId;
        this.tariffPlanName = tariffPlanName;
        this.promotionId = promotionId;
        this.discount = discount;
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

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getStatusBlock() {
        return statusBlock;
    }

    public void setStatusBlock(Boolean statusBlock) {
        this.statusBlock = statusBlock;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public Integer getTariffPlanId() {
        return tariffPlanId;
    }

    public void setTariffPlanId(Integer tariffPlanId) {
        this.tariffPlanId = tariffPlanId;
    }

    public String getTariffPlanName() {
        return tariffPlanName;
    }

    public void setTariffPlanName(String tariffPlanName) {
        this.tariffPlanName = tariffPlanName;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null) {
            return false;
        }
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null){
            return false;
        }
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null){
            return false;
        }
        if (role != user.role) return false;
        if (totalAmount != null ? !totalAmount.equals(user.totalAmount) : user.totalAmount != null) {
            return false;
        }
        if (statusBlock != null ? !statusBlock.equals(user.statusBlock) : user.statusBlock != null){
            return false;
        }
        if (traffic != null ? !traffic.equals(user.traffic) : user.traffic != null) {
            return false;
        }
        if (tariffPlanId != null ? !tariffPlanId.equals(user.tariffPlanId) : user.tariffPlanId != null) {
            return false;
        }
        if (tariffPlanName != null ? !tariffPlanName.equals(user.tariffPlanName) : user.tariffPlanName != null)
            return false;
        if (promotionId != null ? !promotionId.equals(user.promotionId) : user.promotionId != null) {
            return false;
        }
        return discount != null ? discount.equals(user.discount) : user.discount == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (statusBlock != null ? statusBlock.hashCode() : 0);
        result = 31 * result + (traffic != null ? traffic.hashCode() : 0);
        result = 31 * result + (tariffPlanId != null ? tariffPlanId.hashCode() : 0);
        result = 31 * result + (tariffPlanName != null ? tariffPlanName.hashCode() : 0);
        result = 31 * result + (promotionId != null ? promotionId.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", totalAmount=" + totalAmount +
                ", statusBlock=" + statusBlock +
                ", traffic=" + traffic +
                ", tariffPlanId=" + tariffPlanId +
                ", tariffPlanName='" + tariffPlanName + '\'' +
                ", promotionId=" + promotionId +
                ", discount=" + discount +
                '}';
    }
}