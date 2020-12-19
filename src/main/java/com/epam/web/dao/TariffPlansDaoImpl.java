package com.epam.web.dao;

import com.epam.web.entity.TariffPlan;
import com.epam.web.exception.DaoException;
import com.epam.web.extractor.TariffPlanExtractor;
import com.epam.web.mapper.TariffsRowMapper;

import java.sql.Connection;
import java.util.List;

public class TariffPlansDaoImpl extends AbstractDao<TariffPlan> implements TariffPlansDao {
    private static final String TABLE_NAME = "tariff_plans";
    private static final String UPDATE = "UPDATE tariff_plans SET tariff_name=?, price=?, prescription=? WHERE id=?";
    private static final String SAVE = "INSERT INTO tariff_plans(tariff_name, price, prescription) VALUES(?, ?, ?)";


    public TariffPlansDaoImpl(Connection connection) {
        super(connection, new TariffsRowMapper(), new TariffPlanExtractor());
    }

    @Override
    public List<TariffPlan> getTariffPlans() throws DaoException {
        return getAll(TABLE_NAME);
    }

    @Override
    protected String saveItem() {
        return SAVE;
    }

    @Override
    protected String updateItem() {
        return UPDATE;
    }
}
