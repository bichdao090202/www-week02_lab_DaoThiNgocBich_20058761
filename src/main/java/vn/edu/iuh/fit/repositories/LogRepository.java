package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Log;

import java.time.LocalDateTime;

public class LogRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public LogRepository() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
        trans = em.getTransaction();
    }

    public int insertLog(Log log) {
        try {
            trans.begin();
            em.persist(log);
            trans.commit();
            return log.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        }
        return -1;
    }

    public boolean updateLogoutTime(int logId) {
        try {
            trans.begin();
            Log log = getLogByID(logId);
            log.setLogoutTime(LocalDateTime.now());
            em.merge(log);
            trans.commit();
            return true;
        } catch (Exception e) {
            trans.rollback();
        }
        return false;
    }

    public Log getLogByID(int id) {
        try {
            trans.begin();
            Log log = em.find(Log.class, id);
            trans.commit();
            return log;
        } catch (Exception e) {
            trans.rollback();
        }
        return null;
    }

}
