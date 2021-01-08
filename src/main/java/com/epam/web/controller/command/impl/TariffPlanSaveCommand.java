package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.TariffPlan;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.TariffPlanService;
import com.epam.web.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffPlanSaveCommand implements Command {
    private static final String TARIFF_PLANS_PAGE = "/controller?command=tariffs";
    private static final String TARIFF_EDIT_LOCATION = "/WEB-INF/view/pages/tariffs-edit.jsp";
    private static final String ID = "id";
    private static final String TARIFF_NAME = "tariff";
    private static final String PRICE = "price";
    private static final String DESCRIPTION = "description";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessageData";
    private static final String ERROR_MESSAGE = "Wrong data!";

    private final Validator<TariffPlan> tariffPlanValidator;
    private final TariffPlanService service;

    public TariffPlanSaveCommand(Validator<TariffPlan> tariffPlanValidator, TariffPlanService service) {
        this.tariffPlanValidator = tariffPlanValidator;
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Long id = request.getParameter(ID).equals("") ? null : Long.parseLong(request.getParameter(ID));

        String tariffName = request.getParameter(TARIFF_NAME);
        Integer price = Integer.parseInt(request.getParameter(PRICE));
        String description = request.getParameter(DESCRIPTION);

        TariffPlan tariffPlan = new TariffPlan(id, tariffName, price, description);
        if (!tariffPlanValidator.isValid(tariffPlan)) {
            request.setAttribute(ERROR_MESSAGE_ATTRIBUTE, ERROR_MESSAGE);
            return CommandResult.forward(TARIFF_EDIT_LOCATION);
        } else {
            service.saveTariffPlan(tariffPlan);
            return CommandResult.redirect(TARIFF_PLANS_PAGE);
        }
    }
}
