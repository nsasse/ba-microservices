package de.nsasse.roboadvisor.contract.service;

import de.nsasse.roboadvisor.contract.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();

    User findById(long id);
}
