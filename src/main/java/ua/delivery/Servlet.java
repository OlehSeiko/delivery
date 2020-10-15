package ua.delivery;

import ua.delivery.controller.Command;
import ua.delivery.controller.command.Login;
import ua.delivery.controller.command.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();


    @Override
    public void init() throws ServletException {
        commands.put("login", new Login());
        commands.put("registration", new Register());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);


    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

        //підключаю БД

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
            response.sendRedirect(page.replace("redirect:", "/delivery"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }







    }

    @Override
    public void destroy() {

    }
}
