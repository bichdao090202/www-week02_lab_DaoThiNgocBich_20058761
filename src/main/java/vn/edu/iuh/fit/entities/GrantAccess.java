package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

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

    @Column(name = "is_grant", columnDefinition = "ENUM('1','0','1')")
    private int isGrant;

    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, String note) {
        this.role = role;
        this.account = account;
        this.isGrant = 1;
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

    public int getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(int is_grant) {
        this.isGrant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" + "role=" + role + ", account=" + account + ", is_grant=" + isGrant + ", note='" + note + '\'' + '}';
    }
}
