package br.com.fiap.baze.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.baze.dao.EnderecoUsuarioDao;
import br.com.fiap.baze.to.EnderecoUsuarioTO;

public class EnderecoUsuarioBO {
	
	private EnderecoUsuarioDao enderecoUsuarioDao;
	private Connection conexao;
	
	public EnderecoUsuarioBO(Connection conexao) {
		
		this.conexao = conexao;
		this.enderecoUsuarioDao = new EnderecoUsuarioDao(conexao);
	}
	
	public void cadastrarEndereco(EnderecoUsuarioTO endereco) throws SQLException {
		enderecoUsuarioDao.cadastrarEndereco(endereco);
	}
	
	public EnderecoUsuarioTO buscarPorId(int id) throws SQLException {
		return enderecoUsuarioDao.buscarEnderecoPorId(id);
	}
}
