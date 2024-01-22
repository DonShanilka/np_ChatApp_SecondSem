package lk.ijse.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection db;
    private Connection connection;
    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/chat",
                "root",
                "Shanilka800@#"
        );
    }

    public static DbConnection getInstance() throws SQLException {
        return db == null ? db = new DbConnection() : db ;
    }
    public Connection getConnection(){
        return connection;
    }
}
