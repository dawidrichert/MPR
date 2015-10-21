package com.dawidrichert.database.repositories;

import com.dawidrichert.database.models.DbRoleUser;

import javax.sql.DataSource;
import java.sql.*;

public class RoleUserRepository extends BaseRepository<DbRoleUser> {

    private static final String tableName = "RolesUsers";
    private static final String col_IdUser = "IdUser";
    private static final String col_IdRole = "IdRole";

    public RoleUserRepository(DataSource dataSource) {
        super(dataSource, tableName, col_IdRole);
    }

    @Override
    public long add(DbRoleUser roleUser) {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql  = String.format("INSERT INTO %s (", tableName);
            sql += String.format("%s, ", col_IdUser);
            sql += String.format("%s) VALUES (?, ?)", col_IdRole);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, roleUser.getUserId());
                preparedStatement.setLong(2, roleUser.getRoleId());
                preparedStatement.executeUpdate();
                return getLastInsertedId(preparedStatement);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(DbRoleUser roleUser) {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql  = String.format ("UPDATE %s SET ", tableName);
            sql += String.format ("%s=?, ", col_IdUser);
            sql += String.format ("%s=? ", col_IdRole);
            sql += String.format ("WHERE %s=?", col_IdUser);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, roleUser.getUserId());
                preparedStatement.setLong(2, roleUser.getRoleId());
                preparedStatement.setLong(3, roleUser.getUserId());
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void createTableIfNotExists() {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql = String.format("CREATE TABLE IF NOT EXISTS %s (", tableName);
            sql += String.format("%s BIGINT NOT NULL, ", col_IdUser);
            sql += String.format("%s BIGINT NOT NULL)", col_IdRole);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected DbRoleUser mapResultSetToModel(ResultSet resultSet) throws SQLException {
        return new DbRoleUser(
                resultSet.getLong(col_IdUser),
                resultSet.getLong(col_IdRole));
    }
}
