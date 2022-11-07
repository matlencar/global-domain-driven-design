package br.com.fiap.baze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.baze.banco.exception.IdNotFoundException;
import br.com.fiap.baze.to.BicicletaEletricaTO;

public class BicicletaEletricaDao {
	
private Connection conexao;
	
	public BicicletaEletricaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Usando o result set para retornar a bicicleta eletrica do usuario
	 * @param result
	 * @throws SQLException
	 */
	private BicicletaEletricaTO parse(ResultSet result) throws SQLException {
		int codigo = result.getInt("id_bike_eletrica");
		double amperes = result.getDouble("nr_amperes_bateria");
		double motor = result.getDouble("nr_motor");
		
		return new BicicletaEletricaTO(codigo,amperes,motor);
		
	}
	
	/**
	 * Metodo que vai buscar o bicicleta eletrica pelo id
	 * @throws SQLException 
	 */
	
	public BicicletaEletricaTO buscarBicicletaEletricaPorId(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_bike where id_bike_eletrica = ?");
		
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		return parse(result);
	}
	
	/**
	 * Cadastrar o bicicleta eletrica do usuario no banco
	 * @throws SQLException 
	 */
	
	public void cadastrarBicicletaEletrica(BicicletaEletricaTO bicicletaEletrica) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("insert into t_baze_bike_eletrica (id_bike_eletrica, "
				+ " nr_amperes_bateria, nr_motor,) " + " values (sq_t_baze_bike.nextval,?,?,?)");
		
		ps.setInt(1, bicicletaEletrica.getCodigo());
		ps.setDouble(2, bicicletaEletrica.getAmperesBateria());
		ps.setDouble(3, bicicletaEletrica.getMotor());
		
		ps.executeUpdate();
	}
	
	/**
	 * Deletar um bicicleta eletrica do banco pelo seu id
	 * @throws SQLException 
	 * @throws IdNotFoundException 
	 */
	
	public void deletarBicicletaEletrica(int id) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("delete from t_baze_bike_eletrica where id_bike = ?");
		
		ps.setInt(1, id);
		
		int quantidade  = ps.executeUpdate();
		
		if(quantidade == 0) {
			throw new IdNotFoundException("bicicleta eletrica nao teve seu id encontrado, e nao podera ser removido ");
		}
	}
}
