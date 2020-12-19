package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.TariffPlan;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.TariffPlansService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TariffPlansSaveCommand implements Command {
    private static final String TARIFF_PLANS_PAGE ="/controller?command=tariffs";
    private static final String ID = "id";
    private static final String TARIFF_NAME = "tariff-name";
    private static final String PRICE = "price";
    private static final String PRESCRIPTION = "prescription";
    private final TariffPlansService service;

    public TariffPlansSaveCommand(TariffPlansService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Long id = 0L;
        String str = request.getParameter(ID);
        if (str != null) {
            id = Long.parseLong(str);
        }

        String tariffName = request.getParameter(TARIFF_NAME);
        Integer price = Integer.parseInt(request.getParameter(PRICE));
        String prescription = request.getParameter(PRESCRIPTION);

        TariffPlan tariffPlan = new TariffPlan(id, tariffName, price, prescription);
        service.saveTariffPlan(tariffPlan);
        return CommandResult.forward(TARIFF_PLANS_PAGE);
    }
}
