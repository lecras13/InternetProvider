package com.epam.web.service.impl;

import com.epam.web.dao.PromotionDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.entity.Promotion;
import com.epam.web.entity.dto.PromotionDto;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.PromotionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PromotionServiceImpl implements PromotionService {
    private static final Logger LOGGER = LogManager.getLogger(PromotionServiceImpl.class);
    private final DaoHelperFactory daoHelperFactory;

    public PromotionServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }


    @Override
    public List<Promotion> getPromotions() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PromotionDao dao = factory.createPromotionDao();
            return dao.getAll();
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.error("Exception promotionService get promotions!");
            throw new ServiceException(e);
        }
    }

    @Override
    public void savePromotion(Promotion promotion) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PromotionDao dao = factory.createPromotionDao();
            dao.save(promotion);
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.error("Exception promotionService saving promotion!");
            throw new ServiceException(e);
        }
    }

    @Override
    public void deletePromotion(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PromotionDao dao = factory.createPromotionDao();
            dao.removeById(id);
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.error("Exception promotionService deleting promotion!");
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Promotion> getPromotionById(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PromotionDao dao = factory.createPromotionDao();
            return dao.getById(id);
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.error("Exception promotionService get promotion by id!");
            throw new ServiceException(e);
        }
    }
}
