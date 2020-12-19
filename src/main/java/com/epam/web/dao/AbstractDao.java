package com.epam.web.dao;

import com.epam.web.exception.DaoException;
import com.epam.web.extractor.EntityExtractor;
import com.epam.web.mapper.RowMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);
    private static final String ID = "id";
    private Connection connection;
    private RowMapper<T> mapper;
    private EntityExtractor<T> entityExtractor;

    protected AbstractDao(Connection connection, RowMapper<T> mapper, EntityExtractor<T> entityExtractor) {
        this.connection = connection;
        this.mapper = mapper;
        this.entityExtractor = entityExtractor;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            LOGGER.info("Error with sqlQuery");
            throw new DaoException(e);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    protected Optional<T> executeForSingleResult(String query, String login, String password) throws DaoException {
        List<T> items = executeQuery(query, login, password);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new DaoException("More then one record found");
        } else {
            return Optional.empty();
        }
    }


    public List<T> getAll(String tableName) throws DaoException {
        return executeQuery("select * from " + tableName);
    }

    @Override
    public Optional<T> getById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(T item) throws DaoException {
        Map<String, Object> parsed = entityExtractor.parse(item);
        Object id = parsed.get(ID);
        Object[] values = (parsed.values()).toArray();
        PreparedStatement preparedStatement;
        try {
            if (id == null) {
                preparedStatement = createStatement(saveItem(), values);
            }else {
                preparedStatement = createStatement(updateItem(), values);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void removeById(Long id) {

    }

    protected abstract String saveItem();

    protected abstract String updateItem();

    protected abstract String deleteItem();

}

