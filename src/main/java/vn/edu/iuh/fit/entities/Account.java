package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @Column(name = "account_id")
    private String accountID;
    @Column(name = "full_name")
    private String fullName;
    private String password;

    private String email;

    private String phone;

    @Column(columnDefinition = "TINYINT(4)")
    private int status;

    public Account() {
    }

    public Account(String accountID, String fullName, String password, String email, String phone) {
        this.accountID = accountID;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = 1;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String account_id) {
        this.accountID = account_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id='" + accountID + '\'' +
                ", full_name='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
