
import com.CriarConexao;
import com.CriarConexaoSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jvtenorio
 */
public class TestaConexao {

    public static void main(String[] args) throws SQLException {
       CriarConexao criarConexao = new CriarConexao();
        Connection conectarBanco = criarConexao.recuperarConexao();
        conectarBanco.close();
            CriarConexaoSQL sql =  new CriarConexaoSQL();
         sql.getConnection();
        
    
    }
}
