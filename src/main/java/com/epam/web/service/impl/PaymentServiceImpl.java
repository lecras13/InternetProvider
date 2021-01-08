package com.epam.web.service.impl;

import com.epam.web.dao.PaymentDao;
import com.epam.web.dao.UserDao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.entity.Payment;
import com.epam.web.entity.User;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.PaymentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOGGER = LogManager.getLogger(PaymentServiceImpl.class);
    private final DaoHelperFactory daoHelperFactory;

    public PaymentServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Payment> getPayments(Long id) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PaymentDao dao = factory.createPaymentDao();
            return dao.getPaymentsByUserId(id);
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.error("Exception paymentService get payment!");
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Payment> getPaymentsForPage(Long id, int firstRow, int rowCount) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            PaymentDao dao = factory.createPaymentDao();
            return dao.getPaymentsByUserIdForPage(id, firstRow, rowCount);
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.error("Exception paymentService get payment for page!");
            throw new ServiceException(e);
        }
    }

    @Override
    public void pay(Payment payment, Long userId) throws ServiceException {
        DaoHelper factory = null;
        try {
            factory = daoHelperFactory.create();
            factory.startTransAction();
            PaymentDao paymentDao = factory.createPaymentDao();
            paymentDao.save(payment);

            UserDao userDao = factory.createUserDao();
            Optional<User> optionalUser = userDao.getById(userId);
            User user = optionalUser.get();
            Double amountToAdd = payment.getAmount();
            Double amount = user.getTotalAmount();
            Double newAmount = amountToAdd + amount;
            userDao.updateAmount(userId, newAmount);
            factory.endTransaction();
        } catch (DaoException | ConnectionPoolException e) {
            LOGGER.warn("Exception paymentService-pay. Rollback runs!");
            factory.rollback();
            throw new ServiceException(e);
        }
    }
}
