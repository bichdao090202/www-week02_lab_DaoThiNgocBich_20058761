package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public AccountRepository() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        trans = em.getTransaction();
    }

    public List<Account> getAllAccountActive() {
        try {
            trans.begin();
            ArrayList<Account> list = (ArrayList<Account>) em.createQuery("select a from Account a where status = ?1", Account.class).setParameter(1, "1").getResultList();
            trans.commit();
            return list;
        } catch (Exception ex) {
            trans.rollback();
        }
        return null;
    }

    public Account checkAccount(String accountID, String password) {
        try {
            trans.begin();
            String sql = "select a from Account a where accountID = ?1 and password =?2";
            Account account = em.createQuery(sql, Account.class).setParameter(1, accountID).setParameter(2, password).getSingleResult();
            trans.commit();
            return account;
        } catch (Exception ex) {
            trans.rollback();
        }
        return null;
    }
}
