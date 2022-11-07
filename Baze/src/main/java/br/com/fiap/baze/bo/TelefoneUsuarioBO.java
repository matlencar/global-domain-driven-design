package br.com.fiap.baze.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.baze.dao.TelefoneUsuarioDao;
import br.com.fiap.baze.to.EnderecoUsuarioTO;
import br.com.fiap.baze.to.TelefoneUsuarioTO;

public class TelefoneUsuarioBO {
	
	private TelefoneUsuarioDao telefoneUsuarioDao;
	private Connection conexao;
	
	public TelefoneUsuarioBO(Connection conexao) {
		
		this.telefoneUsuarioDao = new TelefoneUsuarioDao(conexao);
	}
	
	public void cadastrarTelefone(TelefoneUsuarioTO telefone) throws SQLException {
		telefoneUsuarioDao.cadastrarTelefone(telefone);
	}
	
	public TelefoneUsuarioTO buscarPorTelefoneId(int id) throws SQLException {
		return telefoneUsuarioDao.buscarTelefonePorId(id);
	}
}
