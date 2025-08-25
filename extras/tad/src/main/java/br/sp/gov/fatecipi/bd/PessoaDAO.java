package br.sp.gov.fatecipi.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAO {
    
    public void inserir(Pessoa pessoa) {
        String sql_str = "INSERT INTO tb_pessoa(nome_pessoa, cpf_pessoa) VALUES (?,?)";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection c = connectionFactory.obtemConnection()){
            PreparedStatement ps = c.prepareStatement(sql_str);
            ps.setString(1,pessoa.getNome());
            ps.setString(2,pessoa.getCpf());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }


    public void atualizar(Pessoa pessoa) {
        String sql = "UPDATE tb_pessoa SET nome_pessoa = ?, cpf_pessoa = ? WHERE id_pessoa = ?";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.obtemConnection()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,pessoa.getNome());
            ps.setString(2,pessoa.getCpf());
            ps.setInt(3,pessoa.getIdPessoa());
        } catch(SQLException se) {
            System.out.println(se.getStackTrace());
        }
    }


}
