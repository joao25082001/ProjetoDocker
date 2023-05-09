

import com.CriarConexaoSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jvtenorio
 */
public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        CriarConexao conexao = new CriarConexao();
        Connection connection = conexao.recuperarConexao();
        CriarConexaoSQL sql = new CriarConexaoSQL();
        JdbcTemplate con = sql.getConnection();
        Statement stm = connection.createStatement();
        
        
       

       con.update("insert into usuario (nome,email,senha,cpf,tipo) values ('marcel','ma@gmail.com','senha200','5143768898','admin')");
       stm.execute("insert into usuario (nome,email,senha,cpf,tipo) values ('marcel','ma@gmail.com','senha200','5143768898','admin')");
        
       
        //retorna um bollean false ja que não é uma lista
        //Retorna um as chaves criadas pelo stm.execute
//        ResultSet resultadoInsert = stm.getGeneratedKeys();
//        while (resultadoInsert.next()) {
//            Integer id = resultadoInsert.getInt(1);
//            System.out.println("o id criado foi: " + id);
//        }

    }

}
