package com.epam.web.mapper;

public class RowMapperFactory {
    private final static String USER_TABLE = "user_table";

    public static RowMapper create(String table) {
        switch (table) {
            case USER_TABLE:
                return new UserRowMapper();
            default:
                throw new IllegalArgumentException("unknown table = " + table);
        }
    }
}
