package com.epam.web.extractor;

import com.epam.web.entity.TariffPlan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TariffPlanExtractor implements EntityExtractor <TariffPlan>{
    private static final String ID = "id";
    private static final String TARIFF_NAME = "tariff-name";
    private static final String PRICE = "price";
    private static final String PRESCRIPTION = "prescription";


    @Override
    public Map<String, Object> parse(TariffPlan tariffPlan) {
        Map<String, Object> result = new LinkedHashMap<>();
        Long id = tariffPlan.getId();
        String tariffName = tariffPlan.getTariffName();
        Integer price = tariffPlan.getPrice();
        String prescription = tariffPlan.getPrescription();

        result.put(TARIFF_NAME, tariffName);
        result.put(PRICE, price);
        result.put(PRESCRIPTION, prescription);
        if(id > 0) {
            result.put(ID, id);
        }
        return result;
    }
}
