package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RoleRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public RoleRepository() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        trans = em.getTransaction();
    }

    public String getRolesByAccountID(String id) {
        try {
            trans.begin();
            String sql = "select * from `grant_access`";
//        String sql = " SELECT role.role_name FROM account join grantaccess ON account.account_id = grantaccess.account_id JOIN role ON role.role_id = grantaccess.role_id WHERE account.account_id = "+id;
            String role = em.createNativeQuery(sql, Object[].class).getResultList().toString();
            trans.commit();
            return role;
        } catch (Exception e) {
            trans.rollback();
        }
        return null;
    }

}
