package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.repositories.RoleRepository;

public class RoleServices {
    private RoleRepository repository;

    public RoleServices() {
        repository = new RoleRepository();
    }

    public String getRolesByAccountID(String id) {
        return repository.getRolesByAccountID(id);
    }

}
