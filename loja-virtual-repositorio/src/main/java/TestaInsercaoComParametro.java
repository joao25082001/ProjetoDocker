
import com.CriarConexao;
import java.sql.Connection;
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
public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

         CriarConexao conexao = new CriarConexao();
        try (Connection connection = conexao.recuperarConexao()){
            connection.setAutoCommit(false);
            try (
                    PreparedStatement stm = connection.prepareStatement("insert into produto (nome,descricao) values (?,?)", Statement.RETURN_GENERATED_KEYS);) {
                adioionarVariavel(stm, "copo", "copo vidro");
                adioionarVariavel(stm, "radio", "radio de bateria");
                connection.commit();
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("rolback executado");
                connection.rollback();
            }
        }
    }

    private static void adioionarVariavel(PreparedStatement stm, String nome, String descricao) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);
        if (nome.equals("radio")) {
            throw new RuntimeException("nao foi possivel adiocionar os produtos");
        };
        stm.execute();
        try (ResultSet resultadoChave = stm.getGeneratedKeys()) {;
            while (resultadoChave.next()) {
                Integer id = resultadoChave.getInt(1);
                System.out.println("o id criado foi: " + id);
            }
        }

    }
}
