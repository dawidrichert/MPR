package com.dawidrichert.repositories;

import com.dawidrichert.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserRepository implements Repository<User> {

    private String tableName = "Users";
    private String col_Id = "Id";
    private String col_Login = "Login";
    private String col_Password = "Password";
    private DataSource dataSource;

    public UserRepository(DataSource dataSource) {
        try {
            setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource newDataSource) throws SQLException {
        this.dataSource = newDataSource;
        createTableIfNotExists();
    }

    public User getById(long id)  {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql = String.format("SELECT * FROM %s WHERE %s=%s", tableName, col_Id, id);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        return new User(
                                resultSet.getLong(col_Id),
                                resultSet.getString(col_Login),
                                resultSet.getString(col_Password),
                                null,
                                null,
                                null);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection<User> getAll() {
        Collection<User> users = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql = String.format("SELECT * FROM %s", tableName);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        users.add(new User(
                                resultSet.getLong(col_Id),
                                resultSet.getString(col_Login),
                                resultSet.getString(col_Password),
                                null,
                                null,
                                null));
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void add(User user) {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql  = String.format("INSERT INTO %s (", tableName);
            sql += String.format("%s, ", col_Login);
            sql += String.format("%s) VALUES (?, ?)", col_Password);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(User user) {
        try(Connection connection = dataSource.getConnection()) {
            String sql = String.format("DELETE FROM %s WHERE %s=%s", tableName, col_Id, user.getId());

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

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

    public void update(User user) {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql  = String.format ("UPDATE %s SET ", tableName);
            sql += String.format ("%s=?, ", col_Login);
            sql += String.format ("%s=? ", col_Password);
            sql += String.format ("WHERE %s=?", col_Id);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setLong(3, user.getId());
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql = String.format("CREATE TABLE IF NOT EXISTS %s (", tableName);
            sql += String.format("%s BIGINT GENERATED BY DEFAULT AS IDENTITY, ", col_Id);
            sql += String.format("%s VARCHAR(256) NOT NULL, ", col_Login);
            sql += String.format("%s VARCHAR(256) NOT NULL)", col_Password);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
