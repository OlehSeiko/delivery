//package ua.delivery.model.service;
//
//import ua.delivery.model.dao.DaoFactory;
//import ua.delivery.model.dao.UserDAO;
//import ua.delivery.model.entity.User;
//
//import java.util.List;
//
//public class UserService {
//
//    DaoFactory daoFactory = DaoFactory.getInstance();
//
//    public List<User> findAll(){
//        System.out.println("UserService: findAll()");
//        UserDAO userDao = daoFactory.createUserDao();
//        return userDao.findAll();
//    }
//}
//
