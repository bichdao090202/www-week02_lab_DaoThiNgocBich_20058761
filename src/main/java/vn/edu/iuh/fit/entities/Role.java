package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    @Column(name = "role_id")
    private String roleID;
    @Column(name = "role_name")
    private String roleName;

    private String description;

    @Column(columnDefinition = "TINYINT(4)")
    private int status;

    public Role() {

    }

    public Role(String roleID, String roleName, String description, int status) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String role_id) {
        this.roleID = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_name) {
        this.roleName = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" + "role_id='" + roleID + '\'' + ", role_name='" + roleName + '\'' + ", description='" + description + '\'' + ", status=" + status + '}';
    }
}
