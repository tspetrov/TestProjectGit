package OCP.Chapter10;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select name from animal")) {
            while (rs.next())
                System.out.println(rs.getString(1));
        }
    }
}
