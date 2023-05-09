

import com.CriarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class TesteDelete {
    public static void main(String[] args) throws SQLException {
      CriarConexao conexao = new CriarConexao();
        Connection connection = conexao.recuperarConexao();
        PreparedStatement stm = connection.prepareStatement("delete from produto where id_produto > ?");
        stm.setInt(1,2);
        stm.execute();
        Integer linhasModificadas = stm.getUpdateCount();
        //retorna a quantidade de linhas modificadas.
        System.out.println(linhasModificadas);
    }
}
