package ua.delivery.model.dao;

import ua.delivery.model.entity.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {

    Optional<User> findAll(String name);
}

