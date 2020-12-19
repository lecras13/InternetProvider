package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.service.UserService;

import com.epam.web.exception.ServiceException;
import com.mysql.cj.Session;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
    private static final String ERROR_MESSAGE_VALUE = "User not found";
    private static final String INDEX_PAGE = "index.jsp";
    private static final String MAIN_PAGE = "/controller?command=main";
    private final static String ROLE = "userRole";

    private final UserService service;

    public LoginCommand(UserService service) {
        this.service = service;
    }


    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        Optional<User> guest = service.login(login, password);
        HttpSession session = req.getSession();

        if (guest.isPresent()) {
            User user = guest.get();
            Role role = user.getRole();
            session.setAttribute(LOGIN, login);
            session.setAttribute(ROLE, role);
            return CommandResult.redirect(MAIN_PAGE);
        } else {
            req.setAttribute(ERROR_MESSAGE_ATTRIBUTE, ERROR_MESSAGE_VALUE);
            return CommandResult.forward(INDEX_PAGE);
        }
    }
}
