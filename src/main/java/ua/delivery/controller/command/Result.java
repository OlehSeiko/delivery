package ua.delivery.controller.command;

import ua.delivery.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class Result implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            System.out.println("Result");
            String downloadCity = request.getParameter("downloadCity");
            System.out.println(downloadCity);
            String cityOfUnloading = request.getParameter("cityOfUnloading");
            System.out.println(cityOfUnloading);
            int distance = Integer.parseInt(request.getParameter("distance"));
            System.out.println(request.getParameter("distance"));
            int weight = Integer.parseInt(request.getParameter("weight"));
            System.out.println(request.getParameter("weight"));
            int category = Integer.parseInt(request.getParameter("category"));
            System.out.println(request.getParameter("category"));
            int sum = (distance * weight * category) / 4;
            System.out.println(sum);

            request.setAttribute("sum", sum);


            return "/sum.jsp";
        }catch (Exception e) {
            return "/sum.jsp";
        }
    }
}
