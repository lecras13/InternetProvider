package com.epam.web.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class SessionLocaleFilter implements Filter {
    private static final String LANG_PARAMETER = "lang";
    private static final String SESSION_LOCALE_PARAMETER = "sessionLocale";


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String sessionLocale = req.getParameter(SESSION_LOCALE_PARAMETER);
        if (sessionLocale != null) {
            req.getSession().setAttribute(LANG_PARAMETER, sessionLocale);
        }
        chain.doFilter(request, response);
    }
    public void destroy() {}
    public void init(FilterConfig arg) throws ServletException {}
}