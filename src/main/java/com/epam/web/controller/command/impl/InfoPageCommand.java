package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.Promotion;
import com.epam.web.entity.Role;
import com.epam.web.entity.TariffPlan;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.impl.PromotionServiceImpl;
import com.epam.web.service.impl.TariffPlanServiceImpl;
import com.epam.web.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class InfoPageCommand implements Command {
    private static final String INFO_LOCATION = "/WEB-INF/view/pages/info.jsp";
    private static final String ID = "user_id";
    private static final String USER = "user";
    private static final String SESSION_ROLE = "userRole";
    private static final String TARIFF_NAME = "tariff_name";
    private static final String PROMOTION_NAME = "promotion_name";
    private static final String PROMOTION_NONE = "---";

    private final UserServiceImpl userService;
    private final TariffPlanServiceImpl tariffPlanService;
    private final PromotionServiceImpl promotionService;

    public InfoPageCommand(UserServiceImpl userService, TariffPlanServiceImpl tariffPlanService, PromotionServiceImpl promotionService) {
        this.userService = userService;
        this.tariffPlanService = tariffPlanService;
        this.promotionService = promotionService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Long id = session.getAttribute(SESSION_ROLE).equals(Role.USER) ?
                (Long) session.getAttribute(ID) :
                Long.parseLong(request.getParameter(ID));

        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Long tariffId = user.getTariffId();
            Long promotionId = user.getPromotionId();
            request.setAttribute(USER, user);

            Optional<TariffPlan> tariffPlanOptional = tariffPlanService.getTariffPlanById(tariffId);
            if (tariffPlanOptional.isPresent()) {
                TariffPlan tariffPlan = tariffPlanOptional.get();
                String tariffPlanName = tariffPlan.getTariffName();
                request.setAttribute(TARIFF_NAME, tariffPlanName);
            }

            Optional<Promotion> promotionOptional = promotionService.getPromotionById(promotionId);
            if (promotionOptional.isPresent()) {
                Promotion promotion = promotionOptional.get();
                String promotionName = promotion.getPromotionName();
                request.setAttribute(PROMOTION_NAME, promotionName);
            } else {
                request.setAttribute(PROMOTION_NAME, PROMOTION_NONE);
            }
        }
        return CommandResult.forward(INFO_LOCATION);
    }
}