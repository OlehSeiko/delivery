package ua.delivery.controller.command;

import ua.delivery.controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserBasis implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        request.setAttribute("user", user);

        return "WEB-INF/user/user-basis.jsp";
    }
}
