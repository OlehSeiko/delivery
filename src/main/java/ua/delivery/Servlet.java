package ua.delivery;

import ua.delivery.controller.Command;
import ua.delivery.controller.command.Login;
import ua.delivery.controller.command.Register;
import ua.delivery.controller.command.Result;
import ua.delivery.controller.command.UserBasis;
import ua.delivery.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();


    @Override
    public void init() throws ServletException {
        commands.put("login", new Login());
        commands.put("registration", new Register(new UserService()));
        commands.put("result", new Result());
        commands.put("user-basis", new UserBasis());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("RequestURI - " + path);
        path = path.replaceAll(".*/Delivery_war/", "");
        System.out.println(path);
        Command command = commands.getOrDefault(path,
                (r) -> "index.jsp");
        String page = command.execute(request);
        System.out.println("P A G E!!!!!!" + page);
        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", "/Delivery_war"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }







    }

    @Override
    public void destroy() {

    }
}
