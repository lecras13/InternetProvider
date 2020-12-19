package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersCommand implements Command {
    private static final String USERS_PAGE = "/WEB-INF/view/pages/admin-users.jsp";
    private static final String USERS = "users";
    private static final int RECORDS_ON_PAGE = 4;
    private static final String PAGE = "page";
    private static final String NO_OF_PAGES = "noOfPages";
    private static final String CURRENT_PAGE = "currentPage";


    private final UserService service;

    public UsersCommand(UserService service) {
        this.service = service;
    }


    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        int page = 1;
        int recordsPerPage = 4;

        if (req.getParameter(PAGE) != null) {
            page = Integer.parseInt(req.getParameter(PAGE));
        }

        List<User> users = service.getAllUsersForPage((page - 1) * RECORDS_ON_PAGE, RECORDS_ON_PAGE);
        List<User> usersAll = service.getAllUsers();
        int noOfRecords = usersAll.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / RECORDS_ON_PAGE);
        req.setAttribute(NO_OF_PAGES, noOfPages);
        req.setAttribute(CURRENT_PAGE, page);
        req.setAttribute(USERS, users);
        return CommandResult.forward(USERS_PAGE);

    }
}
