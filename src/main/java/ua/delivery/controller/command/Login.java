package ua.delivery.controller.command;

import ua.delivery.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(name + " " + pass);
        if (name == null || name.equals(" ") || pass == null || pass.equals(" ")) {
            return "/login.jsp";
        }
            // TODO go to Service
            return "/WEB-INF/user/user-basis.jsp";
        }
    }

