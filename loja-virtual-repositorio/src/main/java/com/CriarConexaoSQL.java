/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource; 
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jvtenorio
 */
public class CriarConexaoSQL {
 private final JdbcTemplate connection;

 public CriarConexaoSQL() {
BasicDataSource dataSource = new BasicDataSource();


dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
dataSource.setUrl("jdbc:sqlserver://svr-medserver-sentinel.database.windows.net:1433;database=bd-medserver-sentinel;user=admin-medserver-sentinel@svr-medserver-sentinel;password={#Gfgrupo4};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
dataSource.setUsername("admin-medserver-sentinel@svr-medserver-sentinel");
dataSource.setPassword("#Gfgrupo4");

try (Connection connection = dataSource.getConnection()) {
if (connection != null) {
System.out.println("Conexão com o SQL Server estabelecida com sucesso!");
} else {
System.out.println("Falha ao conectar ao SQL Server.");
}
} catch (SQLException e) {
 System.out.println("Erro ao conectar ao SQL Server: " + e.getMessage());
}

this.connection = new JdbcTemplate(dataSource);
}


 public JdbcTemplate getConnection() {
 
    return connection;

}
}
