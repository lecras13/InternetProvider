package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandResult;
import com.epam.web.entity.Promotion;
import com.epam.web.entity.TariffPlan;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.PromotionService;
import com.epam.web.service.impl.TariffPlanServiceImpl;
import com.epam.web.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PromotionSaveCommand implements Command {
    private static final String PROMOTIONS_PAGE = "/controller?command=promotions";
    private static final String PROMOTIONS_EDIT_LOCATION = "/WEB-INF/view/pages/promotions-edit.jsp";
    private static final String ID = "id";
    private static final String PROMOTION_NAME = "promotion-name";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String START_DATE = "start-date";
    private static final String END_DATE = "end-date";
    private static final String DESCRIPTION = "description";
    private static final String TARIFF_ID = "select_tariff";
    private static final String NEW_PRICE = "new-price";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessageData";
    private static final String ERROR_MESSAGE = "Wrong data!";
    private static final String TARIFF_PLANS = "tariffs";

    private final Validator<Promotion> promotionValidator;
    private final PromotionService promotionService;
    private final TariffPlanServiceImpl tariffPlanService;

    public PromotionSaveCommand(Validator<Promotion> promotionValidator, PromotionService promotionService, TariffPlanServiceImpl tariffPlanService) {
        this.promotionValidator = promotionValidator;
        this.promotionService = promotionService;
        this.tariffPlanService = tariffPlanService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Date startDate = null;
        Date endDate = null;
        Long id = request.getParameter(ID).equals("") ? null : Long.parseLong(request.getParameter(ID));

        String promotionName = request.getParameter(PROMOTION_NAME);
        try {
            startDate = new SimpleDateFormat(DATE_FORMAT).parse(request.getParameter(START_DATE));
            endDate = new SimpleDateFormat(DATE_FORMAT).parse(request.getParameter(END_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String description = request.getParameter(DESCRIPTION);

        Long tariffPlanId = Long.parseLong(request.getParameter(TARIFF_ID));
        Integer newPrice = Integer.parseInt(request.getParameter(NEW_PRICE));

        Promotion promotion = new Promotion(id, promotionName, startDate, endDate, description, tariffPlanId, newPrice);

        if (!promotionValidator.isValid(promotion)) {
            request.setAttribute(ERROR_MESSAGE_ATTRIBUTE, ERROR_MESSAGE);
            List<TariffPlan> tariffPlans = tariffPlanService.getTariffPlans();
            request.setAttribute(TARIFF_PLANS, tariffPlans);
            return CommandResult.forward(PROMOTIONS_EDIT_LOCATION);
        } else {
            promotionService.savePromotion(promotion);
            return CommandResult.redirect(PROMOTIONS_PAGE);
        }
    }
}
