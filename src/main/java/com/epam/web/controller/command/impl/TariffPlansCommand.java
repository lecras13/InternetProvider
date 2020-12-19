package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.TariffPlan;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.TariffPlansService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TariffPlansCommand implements Command {
    private static final String TARIFF_PLANS_PAGE = "/WEB-INF/view/pages/tariff-plans.jsp";
    private static final String TARIFF_PLANS = "tariffs";

    private final TariffPlansService service;

    public TariffPlansCommand(TariffPlansService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        List<TariffPlan> tariffPlans = service.getTariffPlans();
        request.setAttribute(TARIFF_PLANS, tariffPlans);
        return CommandResult.forward(TARIFF_PLANS_PAGE);
    }
}
