package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.mariadb.jdbc.plugin.codec.LocalDateTimeCodec;
import vn.edu.iuh.fit.ConnectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Log;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.Date;

public class LogRepository {
    private EntityManager em;

    public LogRepository(){
        em = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public int addLog(Log log) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(log);
            tr.commit();
            return log.getId();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return -1;
    }

    public boolean updateLogoutTime(int logId){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
//            String sql = "select a from Account a where email = ?1 and password =?2";
//            em.createNativeQuery("UPDATE log SET logout_time = ?1, notes = ?2 WHERE account_id = ?3 and logout_time=null")
//                            .setParameter(1, new Date() ).setParameter(3,logId).setParameter(2,"hihi").executeUpdate();
            Log log = new Log();
            log = getLogByID(logId);
            log.setLogoutTime(LocalDateTime.now());
            em.merge(log);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public Log getLogByID(int id){
        return  em.find(Log.class,id);
    }


}
