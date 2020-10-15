package ua.delivery.controller;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute (HttpServletRequest request);
}
