package br.com.fiap.baze.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.baze.banco.exception.IdNotFoundException;
import br.com.fiap.baze.dao.UsuarioDao;
import br.com.fiap.baze.to.UsuarioTO;

/**Business Object do usuario
 * Classe responsavel por implementar as regras de negocio
 * @author Global Bolution Baze
 *
 */
public class UsuarioBO {
	
	private UsuarioDao usuarioDao;
	private EnderecoUsuarioBO enderecoBo;
	private TelefoneUsuarioBO telefoneBo;
	private Connection conexao;
	
	/*
	 * Construtor utilizando das dao's e bo's 
	 */
	public UsuarioBO(Connection conexao) {
		this.conexao = conexao;
		
		/**
		 * Instanciando e referenciando as dao's e bo's que ser�o utilizadas nos construtores
		 */
		this.usuarioDao = new UsuarioDao(conexao);
		this.enderecoBo = new EnderecoUsuarioBO(conexao);
		this.telefoneBo = new TelefoneUsuarioBO(conexao);
	}
	
	public void cadastrarUsuario(UsuarioTO usuario) throws SQLException {
		
		try {
			conexao.setAutoCommit(false);
			usuarioDao.cadastrarUsuario(usuario);
			usuario.getEnderecoUsuario().setUsuarioTo(usuario);
			enderecoBo.cadastrarEndereco(usuario.getEnderecoUsuario());
			conexao.commit();
			
		} catch(SQLException e) {
			conexao.rollback();
			throw new SQLException(e.getMessage());
		}
	}
	
	public List<UsuarioTO> listar() throws SQLException {
		List<UsuarioTO> lista = usuarioDao.listarUsuario();
		
		for(UsuarioTO to : lista) {
			
			to.setEnderecoUsuario(enderecoBo.buscarPorId(to.getId()));
			
			to.setTelefoneUsuario(telefoneBo.buscarPorTelefoneId(to.getId()));
		} 
		
		
		return lista;
	}
}
