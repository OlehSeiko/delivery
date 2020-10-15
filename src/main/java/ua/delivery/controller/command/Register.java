package ua.delivery.controller.command;

import ua.delivery.controller.Command;
import ua.delivery.model.entity.User;
import ua.delivery.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register implements Command {
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
        } else {
            User user = new User();

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(Role.ROLE_USER);

            System.out.println(user);


            String url = "jdbs:mysql://localhost:3306/userdb";
            String username1 = "root";
            String password1 = "root";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Connection conn = DriverManager.getConnection(url, username, password);

                System.out.println("DriverManager.getConnection");
                final String query = "INSERT INTO user" +
                        "(firstName, lastName, role, username, password) " +
                        "VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.clearParameters();
                    pstmt.setString(1, user.getFirstName());
                    pstmt.setString(2, user.getLastName());
                    pstmt.setString(3, user.getRole().name());
                    pstmt.setString(4, user.getUsername());
                    pstmt.setString(5, user.getPassword());
                    int countAdded = pstmt.executeUpdate();
                    System.out.println("added - " + countAdded);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            {


                return "/user-basis.jsp";
            }

        }

    }
}
