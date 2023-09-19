package vn.edu.iuh.fit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private int is_grant;

    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, int is_grant, String note) {
        this.role = role;
        this.account = account;
        this.is_grant = is_grant;
        this.note = note;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(int is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                '}';
    }
}
