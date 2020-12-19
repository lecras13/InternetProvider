package com.epam.web.mapper;

import com.epam.web.entity.TariffPlan;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TariffsRowMapper implements RowMapper<TariffPlan> {
    private static final String ID = "id";
    private static final String TARIFF_NAME = "tariff_name";
    private static final String PRICE = "price";
    private static final String PRESCRIPTION = "prescription";

    @Override
    public TariffPlan map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(ID);
        String tariffName = resultSet.getString(TARIFF_NAME);
        Integer price = resultSet.getInt(PRICE);
        String prescription = resultSet.getString(PRESCRIPTION);
        return new TariffPlan(id, tariffName, price, prescription);
    }
}