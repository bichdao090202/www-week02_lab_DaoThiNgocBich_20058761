package vn.edu.iuh.fit.repositories;


import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class RoleRepository {
    private EntityManager em;

    public RoleRepository(){
        em = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public String getRolesByAccountID(String id){
        String sql = "select * from `grant_access`";
//        String sql = " SELECT role.role_name FROM account join grantaccess ON account.account_id = grantaccess.account_id JOIN role ON role.role_id = grantaccess.role_id WHERE account.account_id = "+id;
        return em.createNativeQuery(sql,Object[].class).getResultList().toString();
    }

}
