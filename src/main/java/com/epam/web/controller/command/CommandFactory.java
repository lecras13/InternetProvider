package com.epam.web.controller.command;

import com.epam.web.controller.command.impl.*;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.service.TariffPlansService;
import com.epam.web.service.UserService;

public class CommandFactory {
    private static final String MAIN = "main";
    private static final String MAIN_LOCATION = "WEB-INF/view/pages/main.jsp";
    private static final String TARIFF_EDIT_LOCATION="/WEB-INF/view/pages/tariffs-edit.jsp";

    private static final String LOGOUT = "logout";
    private static final String LOGIN = "login";
    private static final String USERS = "users";
    private static final String TARIFF_PLANS = "tariffs";
    private static final String TARIFF_PLANS_SAVE = "tariffs-save";
    private static final String TARIFF_PLANS_EDIT = "tariffs-edit";

    public static Command create(String command) {
        switch (command) {
            case TARIFF_PLANS_EDIT:
                return new GoToPage(TARIFF_EDIT_LOCATION);
            case TARIFF_PLANS_SAVE:
                return new TariffPlansSaveCommand(new TariffPlansService(new DaoHelperFactory()));
            case TARIFF_PLANS:
                return new TariffPlansCommand(new TariffPlansService(new DaoHelperFactory()));
            case USERS:
                return new UsersCommand(new UserService(new DaoHelperFactory()));
            case MAIN:
                return new GoToPage(MAIN_LOCATION);
            case LOGIN:
               return new LoginCommand(new UserService(new DaoHelperFactory()));
            case LOGOUT:
                return new LogoutCommand();
            /*case "registration":
                return new RegistrationCommand();*/
            default:
                throw new IllegalArgumentException();
        }
    }
}

