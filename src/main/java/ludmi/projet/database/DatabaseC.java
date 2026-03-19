package ludmi.projet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseC extends DatabaseConnection{

    private static  final String URL = "jdbc:sqlite:user.db";
    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL);
    }

    public static void initD(){
        String sql = """
                CREATE TABLE IF NOT EXIST user(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user TEXT,
                password TEXT,
                )
                """;

        try(Connection conn = getConnection();
        Statement stmt = conn.createStatement();) {

            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
