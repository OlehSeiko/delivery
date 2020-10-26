package ua.delivery.model.dao;

import ua.delivery.model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    public User findByUsername(String username);
}

