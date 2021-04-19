package cz.educanet;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT D.nazev, Z.jmeno, Z.id FROM zvirata as Z JOIN druhy as D ON (Z.druh = D.id) WHERE Z.jmeno like ('Prdelka') limit 5");
        System.out.println("ID" + "\t    " + "Jmeno" + "\t    " + "Druh");
        System.out.println("------------------------------------------");

        while(result.next()) {
            int id = result.getInt("id");
            String jmeno = result.getString("jmeno");
            String druhy = result.getString("nazev");
            System.out.println("" + id + "\t" + jmeno + "\t   " + druhy
            );
        }
        System.out.println("------------------------------------------");
        connection.close();
    }

}
