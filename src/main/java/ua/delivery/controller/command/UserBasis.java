package ua.delivery.controller.command;

import ua.delivery.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class UserBasis implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String downloadCity = request.getParameter("downloadCity");
        String cityOfUnloading = request.getParameter("cityOfUnloading");
        int distance = Integer.parseInt(request.getParameter("distance"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int category = Integer.parseInt(request.getParameter("category"));

        return "/sum.jsp";
    }
}
