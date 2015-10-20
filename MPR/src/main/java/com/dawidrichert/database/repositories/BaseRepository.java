package com.dawidrichert.database.repositories;

import com.dawidrichert.database.models.Indexable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseRepository<T extends Indexable> implements Repository<T> {

    private final String tableName;
    private final String col_Id;
    protected DataSource dataSource;

    public BaseRepository(DataSource dataSource, String tableName, String col_Id) {
        this.dataSource = dataSource;
        this.tableName = tableName;
        this.col_Id = col_Id;
        try {
            createTableIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getById(long id)  {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql = String.format("SELECT * FROM %s WHERE %s=%s", tableName, col_Id, id);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        return mapResultSetToModel(resultSet);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<T> getAll() {
        Collection<T> items = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql = String.format("SELECT * FROM %s", tableName);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        items.add(mapResultSetToModel(resultSet));
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public abstract void add(T item);

    @Override
    public void remove(T item) {
        try(Connection connection = dataSource.getConnection()) {
            String sql = String.format("DELETE FROM %s WHERE %s=%s", tableName, col_Id, item.getId());

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll() {
        try(Connection connection = dataSource.getConnection()) {
            String sql = String.format("DELETE FROM %s", tableName);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public abstract void update(T item);

    protected abstract void createTableIfNotExists() throws SQLException;

    protected abstract T mapResultSetToModel(ResultSet resultSet) throws SQLException;
}
