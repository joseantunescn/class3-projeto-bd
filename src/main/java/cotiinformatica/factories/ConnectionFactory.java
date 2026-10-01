package cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection createConnection() throws Exception{
        // var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5434/bd-pessoas", "coti", "coti");

        var host = "jdbc:postgresql://localhost:5434/bd-pessoas";
        var user = "coti";
        var pass = "coti";

        return DriverManager.getConnection(host, user, pass);
    }
}
