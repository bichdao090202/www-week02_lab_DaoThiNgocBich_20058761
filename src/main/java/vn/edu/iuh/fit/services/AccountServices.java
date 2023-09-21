package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.List;

public class AccountServices {
    private AccountRepository repository;

    public AccountServices() {
        repository = new AccountRepository();
    }

    public List<Account> getAllAccountActive() {
        return repository.getAllAccountActive();
    }

    public Account checkAccount(String email, String password) {
        return repository.checkAccount(email, password);
    }

}
