package com.epam.web.service;

import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.TariffPlansDao;
import com.epam.web.entity.TariffPlan;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.util.List;


public class TariffPlansService {

    private DaoHelperFactory daoHelperFactory;

    public TariffPlansService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }


    public List<TariffPlan> getTariffPlans() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            // factory.startTransAction();
            TariffPlansDao dao = factory.createTariffDao();
            return dao.getTariffPlans();
        } catch (DaoException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }
    }

    public void saveTariffPlan(TariffPlan tariffPlan) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            // factory.startTransAction();
            TariffPlansDao dao = factory.createTariffDao();
            dao.save(tariffPlan);
        } catch (DaoException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }
    }
}
