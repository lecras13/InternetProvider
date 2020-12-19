package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    List<User> getAllUsersForPage(int firstRow, int rowCount) throws DaoException;
    List<User> getAllUsers() throws DaoException;
}
