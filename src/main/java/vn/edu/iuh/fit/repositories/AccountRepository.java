package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Account;

import java.sql.PreparedStatement;
import java.util.List;

public class AccountRepository {
    private EntityManager em;

    public AccountRepository(){
        em = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public List<Account> getAllAccountActive(){
        return em.createQuery("select a from Account a where status = ?1", Account.class)
                .setParameter(1,"1").getResultList();
    }

    public Account checkAccount(String email, String password){
        EntityTransaction transaction = em.getTransaction();
        Account account = new Account();
        transaction.begin();
        try {
            String sql = "select a from Account a where email = ?1 and password =?2";
            account = em.createQuery(sql, Account.class)
                    .setParameter(1,email).setParameter(2,password).getSingleResult();
            transaction.commit();
            return account;
        }catch (Exception ex){
            transaction.rollback();
        }
        return null;
    }


}
