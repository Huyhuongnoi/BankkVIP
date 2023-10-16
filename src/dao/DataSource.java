package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class DataSource {
    private static HikariConfig hikariConfig = new HikariConfig();
    private static HikariDataSource hikariDataSource;
    private static DataSource dataSource;

    static {
        hikariConfig.setJdbcUrl("jdbc:mySQL://localhost:3306/bank");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");
        hikariConfig.setMaximumPoolSize(20);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setAutoCommit(false);
        hikariConfig.setIdleTimeout(30000);
        hikariConfig.setMaxLifetime(180000);
        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    private DataSource() {
    }

    public Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }

    public static DataSource getInstance() {
        if (Objects.isNull(dataSource)) {
            dataSource = new DataSource();
        }
        return dataSource;
    }
}
