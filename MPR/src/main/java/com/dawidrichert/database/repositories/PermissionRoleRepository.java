package com.dawidrichert.database.repositories;

import com.dawidrichert.database.models.DbPermissionRole;

import javax.sql.DataSource;
import java.sql.*;

public class PermissionRoleRepository extends BaseRepository<DbPermissionRole> {

    private static final String tableName = "PermissionsRoles";
    private static final String col_IdRole = "IdRole";
    private static final String col_IdPermission = "IdPermission";

    public PermissionRoleRepository(DataSource dataSource) {
        super(dataSource, tableName, col_IdRole);
    }

    @Override
    public long add(DbPermissionRole permissionRole) {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql  = String.format("INSERT INTO %s (", tableName);
            sql += String.format("%s, ", col_IdRole);
            sql += String.format("%s) VALUES (?, ?)", col_IdPermission);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, permissionRole.getRoleId());
                preparedStatement.setLong(2, permissionRole.getPermissionId());
                preparedStatement.executeUpdate();
                return getLastInsertedId(preparedStatement);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void update(DbPermissionRole permissionRole) {
        try(Connection connection = dataSource.getConnection()) {
            String sql;
            sql  = String.format ("UPDATE %s SET ", tableName);
            sql += String.format ("%s=?, ", col_IdRole);
            sql += String.format ("%s=? ", col_IdPermission);
            sql += String.format ("WHERE %s=?", col_IdRole);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, permissionRole.getRoleId());
                preparedStatement.setLong(2, permissionRole.getPermissionId());
                preparedStatement.setLong(3, permissionRole.getRoleId());
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
            sql += String.format("%s BIGINT NOT NULL, ", col_IdRole);
            sql += String.format("%s BIGINT NOT NULL)", col_IdPermission);

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected DbPermissionRole mapResultSetToModel(ResultSet resultSet) throws SQLException {
        return new DbPermissionRole(
                resultSet.getLong(col_IdRole),
                resultSet.getLong(col_IdPermission));
    }
}
