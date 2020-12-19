package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.extractor.UserExtractor;
import com.epam.web.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from users where login=? and password=SHA1(?)";
    private static final String TABLE_NAME = "users";
    private static final String GET_USERS_FOR_TABLE = "SELECT * FROM users limit ?, ?";
    //private static final String GET_USERS_FOR_TABLE = "select * from users join tariff_plans on users.tariff_id=tariff_plans.id";
   // private static final String GET_USERS_FOR_TABLE = "SELECT *, tariff_plans.tariff_name as tariff FROM users join tariff_plans on users.tariff_id=tariff_plans.id limit ?, ?";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), new UserExtractor());
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public List<User> getAllUsersForPage(int firstRow, int rowCount) throws DaoException {
        return executeQuery(GET_USERS_FOR_TABLE, firstRow, rowCount);
    }

    @Override
    public List<User> getAllUsers() throws DaoException {
        return super.getAll(TABLE_NAME);
    }

    @Override
    protected String saveItem() {
        return null;
    }

    @Override
    protected String updateItem() {
        return null;
    }
}