package vn.edu.iuh.fit.ConnectionDB;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionDB {
    private static ConnectionDB connectionDB;
    private EntityManagerFactory managerFactory;

    public ConnectionDB() {
        managerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static ConnectionDB getConnectionDB() {
        if (connectionDB == null) {
            connectionDB = new ConnectionDB();
        }
        return connectionDB;
    }

    public EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }
}
