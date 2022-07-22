package banking;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private SQLiteDataSource dataSource;
    private Connection connection;
    private Statement statement;

    public void openDb(String pathToDB) throws SQLException {
        String url = "jdbc:sqlite:" + pathToDB;
        dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        connection = dataSource.getConnection();
        statement = connection.createStatement();

        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS card ("
                        + "id INTEGER PRIMARY KEY, "
                        + "number TEXT NOT NULL, "
                        + "pin TEXT NOT NULL, "
                        + "balance INTEGER DEFAULT 0)"
        );
    }

    public void insert(String number, String pin) {
        String sql = String.format(
                "INSERT INTO card (number, pin) VALUES ('%s', '%s')", number, pin);
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Card select(String number, String pin) {
        String sql = String.format(
                "SELECT * FROM card WHERE number = '%s' AND pin = '%s'", number, pin);
        Card card = null;
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                card = new Card();
                card.setNumber(rs.getString("number"));
                card.setPin(rs.getString("pin"));
                card.setBalance(rs.getInt("balance"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return card;
    }

    public void close() {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
