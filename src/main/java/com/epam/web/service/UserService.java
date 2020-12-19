package com.epam.web.service;

import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.ConnectionPoolException;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class UserService {

    private DaoHelperFactory daoHelperFactory;

    public UserService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }


    public Optional<User> login(String login, String password) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            factory.startTransAction();
            UserDao dao = factory.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> getAllUsersForPage(int firstRow, int rowCount) throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            return dao.getAllUsersForPage(firstRow, rowCount);
        } catch (DaoException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> getAllUsers() throws ServiceException {
        try (DaoHelper factory = daoHelperFactory.create()) {
            UserDao dao = factory.createUserDao();
            return dao.getAllUsers();
        } catch (DaoException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }
    }
}

