package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.repositories.LogRepository;

public class LogServices {
    private LogRepository repository;

    public LogServices() {
        repository = new LogRepository();
    }

    public int insertLog(Log log) {
        return repository.insertLog(log);
    }

    public boolean updateLogoutTime(int logId) {
        return repository.updateLogoutTime(logId);
    }

}
