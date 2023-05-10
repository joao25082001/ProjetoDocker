/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jvtenorio
 */
public class CriarConexao {

    public Connection recuperarConexao() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC", "root",
                "joaovitor");

    }


}
