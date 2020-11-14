package br.edu.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.modelo.ControleWanderson;
import br.edu.faculdadedelta.util.Conexao;

public class ControleDAO {
	
	
	public void incluir (ControleWanderson controleWanderson) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "INSERT INTO bens (nome_bem, especificacao_bem, desc_departamento, valor_bem, data_cadastro_bem)"
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, controleWanderson.getDescricao().trim());
		ps.setString(2, controleWanderson.getEspecificacao().trim());
		ps.setString(3, controleWanderson.getDepartamento().trim());
		ps.setDouble(4, controleWanderson.getValorBem());
		ps.setDate(5, new java.sql.Date(controleWanderson.getDataCadastro().getTime()));
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
		}
	
	public void alterar (ControleWanderson controleWanderson) throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "UPDATE bens SET nome_bem=?, "
				+ "especificacao_bem=?, "
				+ "desc_departamento=?, "
				+ "valor_bem=?, "
				+ "data_cadastro_bem=? "
				+ "WHERE id_bem = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, controleWanderson.getDescricao().trim());
		ps.setString(2, controleWanderson.getEspecificacao().trim());
		ps.setString(3, controleWanderson.getDepartamento().trim());
		ps.setDouble(4, controleWanderson.getValorBem());
		ps.setDate(5, new java.sql.Date(controleWanderson.getDataCadastro().getTime()));
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public void excluir (ControleWanderson controleWanderson) throws ClassNotFoundException, SQLException {
		
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "DELETE FROM bens"
				+ "	WHERE id_bem = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, controleWanderson.getId());
		
		ps.executeUpdate();
		
		ps.close();
		conn.close();
	}
	
	public List <ControleWanderson> listar () throws ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectarNoBanco();
		String sql = "SELECT id_bem, nome_bem, especificacao_bem, desc_departamento, valor_bem, data_cadastro_bem "
				+ "FROM bens";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<ControleWanderson> listaRetorno = new ArrayList<ControleWanderson>();
		
		while (rs.next()) {
			ControleWanderson controleWanderson = new ControleWanderson();
			controleWanderson.setId(rs.getLong("id_bem"));
			controleWanderson.setDescricao(rs.getString("nome_bem"));
			controleWanderson.setEspecificacao(rs.getString("especificacao_bem"));
			controleWanderson.setDepartamento(rs.getString("desc_departamento"));
			controleWanderson.setValorBem(rs.getDouble("valor_bem"));
			controleWanderson.setDataCadastro(rs.getDate("data_cadastro_bem"));
			listaRetorno.add(controleWanderson);
			
		}
		ps.close();
		rs.close();
		conn.close();
		
		return listaRetorno;
		
	}

}
