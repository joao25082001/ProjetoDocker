
import com.CriarConexao;
import com.CriarConexaoSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jvtenorio
 */
public class TestaListagem {

    public static void main(String[] args) throws SQLException {
      
        CriarConexao criarConexao = new CriarConexao();
        Connection conectarBanco = criarConexao.recuperarConexao();
        CriarConexaoSQL sql =  new CriarConexaoSQL();
       
    
        Statement stm = conectarBanco.createStatement();
        boolean resultados = stm.execute("select * from usuario");
        System.out.println(resultados);
    
         ResultSet rst = stm.getResultSet();
             while(rst.next()){
             Integer id = rst.getInt("ID");
                 System.out.println("ID: "+id);
             String nome = rst.getString("NOME");
              System.out.println("NOME:" +nome);
             }
           conectarBanco.close();
//        FabricaConexao conexao = new FabricaConexao();
//        Connection connection = conexao.recuperaConexao();
//        PreparedStatement stm = connection.prepareStatement("Select id_produto,nome, descricao from produto");
//        stm.execute();
//        ResultSet resultadoSelect = stm.getResultSet();
//        while (resultadoSelect.next()) {
//            Integer id = resultadoSelect.getInt("id_produto");
//            System.out.println(id);
//            String nome = resultadoSelect.getNString("nome");
//            System.out.println(nome);
//            String descricao = resultadoSelect.getNString("descricao");
//            System.out.println(descricao);
//
//        }

    }
}
