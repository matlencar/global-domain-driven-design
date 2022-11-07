package br.com.fiap.baze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.baze.banco.exception.IdNotFoundException;
import br.com.fiap.baze.to.TelefoneUsuarioTO;



public class TelefoneUsuarioDao {
	
	private Connection conexao;

	public TelefoneUsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Usando o result set para retornar o telefone do usuario
	 * @param result
	 * @throws SQLException
	 */
	private TelefoneUsuarioTO parse(ResultSet result) throws SQLException {
		int id = result.getInt("id_");
		int celular = result.getInt("nr_telefone");
		int ddd = result.getInt("nr_ddd");
		int ddi = result.getInt("nr_ddi");
		
		return new TelefoneUsuarioTO(id, celular, ddd, ddi);
		
	}
	
	/**
	 * Cadastrar o telefone do usuario no banco
	 * @throws SQLException 
	 */
	
	public void cadastrarTelefone(TelefoneUsuarioTO telefone) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("insert into t_baze_telefone_usuario (id_telefone_usuario, "
				+ " nr_telefone, nr_ddd, nr_ddi) " + " values (sq_t_baze_telefone_usuario.nextval,?,?,?,?)");
		
		ps.setInt(1, telefone.getId());
		ps.setInt(2, telefone.getCelular());
		ps.setInt(3, telefone.getDdd());
		ps.setInt(4, telefone.getDdi());
		
		ps.executeUpdate();
	}
	
	public void atualizarTelefone(TelefoneUsuarioTO telefone) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("update t_baze_telefone_usuario set id_telefone_usuario = ?, nr_telefone = ?, nr_ddd = ?,"
				+ "nr_ddi = ?");
		
		ps.setInt(1, telefone.getId());
		ps.setInt(2, telefone.getCelular());
		ps.setInt(3, telefone.getDdd());
		ps.setInt(4, telefone.getDdi());
		
		int quantidade  = ps.executeUpdate();
		
			if(quantidade == 0) {
				throw new IdNotFoundException("telefone nao pode ser encontrado para efetivar a atualizacao ");
		}
	}
	
	/**
	 * Metodo que vai buscar o telefone pelo id
	 * @throws SQLException 
	 */
	
	public TelefoneUsuarioTO buscarTelefonePorId(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_telefone_usuario where id_telefone_usuario = ?");
		
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		return parse(result);
	}
}
