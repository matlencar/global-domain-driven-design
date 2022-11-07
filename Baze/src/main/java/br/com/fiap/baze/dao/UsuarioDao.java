package br.com.fiap.baze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.baze.banco.exception.IdNotFoundException;
import br.com.fiap.baze.to.EnderecoUsuarioTO;
import br.com.fiap.baze.to.UsuarioTO;

public class UsuarioDao {

	private Connection conexao;
	
	//Construtor que seve para receber a conexao
	public UsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Usando o result set para retornar o usuario
	 * @param resultSet
	 * @throws SQLException
	 */
	private UsuarioTO parse(ResultSet resultSet) throws SQLException {
		
		int id = resultSet.getInt("id_usuario");
		String nome = resultSet.getString("nm_usuario");
		int idade = resultSet.getInt("nr_idade");
		long cpf = resultSet.getLong("nr_cpf");
		int rg = resultSet.getInt("nr_rg");
		boolean genero = resultSet.getBoolean("nm_genero");
		String email = resultSet.getString("nm_email");
		double peso = resultSet.getDouble("nr_peso");
		double altura = resultSet.getDouble("nr_altura");
		String status = resultSet.getString("st_usuario");
		
		//Instanciando a classe
		UsuarioTO usuario = new UsuarioTO(id, rg , genero, cpf, email, nome, idade, peso, altura, status);
		
		return usuario;
	}
	
	/**
	 * Cadastrar o usuario no banco de dados
	 * @throws SQLException
	 */
	public void cadastrarUsuario(UsuarioTO usuario) throws SQLException {
		
		//Preparar o preparedStatement com o comando SQL de insert para inserir as informações
		PreparedStatement ps = conexao.prepareStatement("insert into t_baze_usuario values "
				+ "(sq_t_baze_usuario.nextval, ?,?,?,?,?,?,?,?,?)", new String[] {"id_usuario"});
		
		//Setando os valores na query, usando a ordem do banco de dados 
		ps.setInt(1, usuario.getId());
		ps.setInt(2, usuario.getRg());
		ps.setLong(3, usuario.getCpf());
		ps.setString(4, usuario.getEmail());
		ps.setString(5, usuario.getNome());
		ps.setInt(6, usuario.getIdade());
		ps.setDouble(7, usuario.getPeso());
		ps.setDouble(8, usuario.getAltura());
		ps.setString(9, usuario.getStatus());
		
		//Comando que executa a query
		ps.executeUpdate();
		
		//Usar o result set para recuperar o codigo gerado pela sequence
		
		ResultSet result = ps.getGeneratedKeys();
		if(result.next()) {
			int id = result.getInt(1);
			usuario.setId(id);
		}
		
	}
	
	/**
	 * Atualizar Usuario no banco de dados
	 * @throws SQLException 
	 */
	public void atualizarUsuario(UsuarioTO usuario) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("update t_baze_usuario set id_usuario = ?, nr_rg = ?, nm_genero = ?,"
				+ "nr_cpf=?, nm_email = ?, nm_usuario = ?, nr_idade = ?, nr_peso = ?, nr_altura = ?, st_usuario = ?");
		
		//Setando os valores na query, usando a ordem do banco de dados 
		ps.setInt(1, usuario.getId());
		ps.setInt(2, usuario.getRg());
		ps.setLong(3, usuario.getCpf());
		ps.setString(4, usuario.getEmail());
		ps.setString(5, usuario.getNome());
		ps.setInt(6, usuario.getIdade());
		ps.setDouble(7, usuario.getPeso());
		ps.setDouble(8, usuario.getAltura());
		ps.setString(8, usuario.getStatus());
		
		int quantidade  = ps.executeUpdate();
		
		if(quantidade == 0) {
			throw new IdNotFoundException("usuario nao pode ser encontrado para efetivar a atualizacao ");
		}
	}
	
	/**
	 * Metodo usado para retornar minha lista de usuarios
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private List<UsuarioTO> parseList(ResultSet result) throws SQLException {
		List<UsuarioTO> listaDeUsuarios = new ArrayList<UsuarioTO>();
		while(result.next()) {
			UsuarioTO user = parse(result);
			listaDeUsuarios.add(user);
		}
		return listaDeUsuarios;
	}
	
	public List<UsuarioTO> listarUsuario() throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_usuario");
		
		ResultSet result = ps.executeQuery();
		
		return  parseList(result);
	}
	
	/**
	 * Deletar um usuario do banco pelo seu id
	 * @throws SQLException 
	 * @throws IdNotFoundException 
	 */
	
	public void deletarUsuario(int id) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("delete from t_baze_usuario where id_usuario = ?");
		
		ps.setInt(1, id);
		
		int quantidade  = ps.executeUpdate();
		
		if(quantidade == 0) {
			throw new IdNotFoundException("usuario nao teve seu id encontrado, e nao podera ser removido ");
		}
	}
	
	public UsuarioTO buscarUsuarioPorId(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_usuario where id_usuario = ?");
		
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		return parse(result);
	}
	
}
