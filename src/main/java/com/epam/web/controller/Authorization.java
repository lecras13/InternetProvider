package com.epam.web.controller;

import com.epam.web.controller.command.CommandResult;
import com.epam.web.controller.command.impl.GoToPage;
import com.epam.web.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Authorization implements Filter {
    private static final String COMMAND = "command";
    private static final String ROLE = "userRole";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";
    private static final String ERROR_MESSAGE_VALUE = "Wrong command!";
    private static final String INDEX_PAGE = "index.jsp";
    private final static String GUEST = "GUEST";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute(ROLE);

        String command = request.getParameter(COMMAND);

        if (command != null && !guestCommand(command)) {
            if (role.equals(Role.ADMIN) && adminCommand(command)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if (role.equals(Role.USER) && userCommand(command)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                response.sendError(403);
                //RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(INDEX_PAGE);
                //dispatcher.forward(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
    }


    private boolean adminCommand(String command) {
        List<String> commandList = new ArrayList<>();
        commandList.add("users");
        commandList.add("main");
        commandList.add("logout");
        commandList.add("tariffs-save");
        commandList.add("tariffs-edit");
        return commandList.contains(command);
    }


    private boolean userCommand(String command) {
        List<String> commandList = new ArrayList<>();
        commandList.add("my-page");//not exist
        commandList.add("main");
        commandList.add("logout");
        return commandList.contains(command);
    }


    private boolean guestCommand(String command) {
        List<String> commandList = new ArrayList<>();
        commandList.add("login");
        commandList.add("registration");
        commandList.add("tariffs");
        commandList.add("promotions");

        return commandList.contains(command);
    }
}
