package ua.delivery.model.service;

import ua.delivery.model.dao.DaoFactory;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.entity.User;

import java.util.List;

public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(User user){
        System.out.println("UserService: create()");
        UserDao userDao = daoFactory.createUserDao();
        userDao.create(user);
    }

    public List<User> findAll(){
        System.out.println("UserService: findAll()");
        UserDao userDao = daoFactory.createUserDao();
        return userDao.findAll();
    }
    public User findByUsername(String username){
        System.out.println("UserService: findByUsername()");
        UserDao userDao = daoFactory.createUserDao();
        return userDao.findByUsername(username);
    }
}

