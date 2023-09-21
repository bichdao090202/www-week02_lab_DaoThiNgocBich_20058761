package vn.edu.iuh.fit.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20)")
    private int id;

    @Column(name="account_id")
    private String accountID;

    @Column(name = "login_time", columnDefinition = "DATETIME")
    @JsonbDateFormat (value = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime loginTime;

    @Column(name = "logout_time", columnDefinition = "DATETIME")
    @JsonbDateFormat (value = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime logoutTime;

    private String notes;

    public Log() {
    }

    public Log(String accountID) {
        this.accountID = accountID;
        this.loginTime = LocalDateTime.now();
    }

    public Log(int id, String accountID, LocalDateTime loginTime, LocalDateTime logoutTime, String notes) {
        this.id = id;
        this.accountID = accountID;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String account) {
        this.accountID = account;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime login_time) {
        this.loginTime = login_time;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logout_time) {
        this.logoutTime = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account=" + accountID +
                ", login_time=" + loginTime +
                ", logout_time=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
