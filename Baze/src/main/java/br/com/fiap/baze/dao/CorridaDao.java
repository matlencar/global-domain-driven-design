package br.com.fiap.baze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.baze.banco.exception.IdNotFoundException;
import br.com.fiap.baze.to.CorridaTO;

public class CorridaDao {
	
private Connection conexao;
	
	public CorridaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Usando o result set para retornar a corrida do usuario
	 * @param result
	 * @throws SQLException
	 */
	private CorridaTO parse(ResultSet result) throws SQLException {
		int id = result.getInt("id_corrida");
		double km = result.getDouble("nr_km");
		double tempo = result.getInt("nr_tempo");
		
		return new CorridaTO(id, tempo, km);
		
	}
	
	/**
	 * Metodo que vai buscar a corrida pelo id
	 * @throws SQLException 
	 */
	
	public CorridaTO buscarBicicletaPorId(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_corrida where id_corrida = ?");
		
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		return parse(result);
	}
	
	/**
	 * Cadastrar a corrida do usuario no banco
	 * @throws SQLException 
	 */
	
	public void cadastrarBicicleta(CorridaTO corrida) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("insert into t_baze_corrida (id_corrida, "
				+ " nr_km, nr_tempo) " + " values (sq_t_baze_corrida.nextval,?,?,?)");
		
		ps.setInt(1, corrida.getId());
		ps.setDouble(2, corrida.getKm());
		ps.setDouble(3, corrida.getTempo());
	
		
		ps.executeUpdate();
	}
	
	/**
	 * Deletar uma corrida do banco pelo seu id
	 * @throws SQLException 
	 * @throws IdNotFoundException 
	 */
	
	public void deletarCorrida(int id) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("delete from t_baze_corrida where id_corrida = ?");
		
		ps.setInt(1, id);
		
		int quantidade  = ps.executeUpdate();
		
		if(quantidade == 0) {
			throw new IdNotFoundException("corrida nao teve seu id encontrado, e nao podera ser removido ");
		}
	}
}
