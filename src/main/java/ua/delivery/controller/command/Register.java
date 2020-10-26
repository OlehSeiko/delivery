package ua.delivery.controller.command;

import org.apache.commons.dbcp.BasicDataSource;
import ua.delivery.controller.Command;
import ua.delivery.model.entity.User;
import ua.delivery.model.entity.enums.Role;
import ua.delivery.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register implements Command {

    private UserService userService;

    public Register(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (firstName == null || firstName.equals("") ||
                lastName == null || lastName.equals("") ||
                username == null || username.equals("") ||
                password == null || password.equals("")) {
            return "/registration.jsp";
        }else {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.ROLE_USER);

        System.out.println(user);

        userService.create(user);
        return "redirect:/login.jsp";
    }
//        else {
//            User user = new User();
//
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setUsername(username);
//            user.setPassword(password);
//            user.setRole(Role.ROLE_USER);
//
//            System.out.println(user);
//
//
//            String url = "jdbc:mysql://localhost:3306/userdb?useUnicode=true&serverTimezone=UTC";
//            String username1 = "root";
//            String password1 = "root";
//
//            final String query = "INSERT INTO users" +
//                    "(firstName, lastName, username, password, role) " +
//                    "VALUES (?, ?, ?, ?, ?)";
//
//            DataSource dataSource;
//            BasicDataSource ds = new BasicDataSource();
//            ds.setUrl(url);
//            ds.setUsername(username1);
//            ds.setPassword(password1);
//            ds.setMinIdle(5);
//            ds.setMaxIdle(10);
//            ds.setMaxOpenPreparedStatements(100);
//            dataSource = ds;
//
//
//
//
//            try (Connection conn = dataSource.getConnection())
//             {
//                 System.out.println("CONN");
//                 PreparedStatement preparedStatement = conn.prepareStatement(query);
//                 preparedStatement.setString(1, user.getFirstName());
//                 preparedStatement.setString(2, user.getLastName());
//                 preparedStatement.setString(3, user.getUsername());
//                 preparedStatement.setString(4, user.getPassword());
//                 preparedStatement.setString(5, user.getRole().name());
//                 preparedStatement.executeUpdate();
//                 System.out.println("User save");
//
//             } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//
//            return "redirect:/login.jsp";

    }
}





