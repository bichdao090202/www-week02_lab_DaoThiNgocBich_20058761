package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Account;

import java.sql.PreparedStatement;
import java.util.List;

public class AccountRepository {
    private EntityManager em;

    public AccountRepository(){
        em = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public String getAllAccountActive(){
        return em.createQuery("select a from Account a where status = ?1", Account.class)
                .setParameter(1,"1").getResultList().toString();
    }
}
