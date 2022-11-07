package br.com.fiap.baze.to;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTO {

	//Variaveis
	private int id;
	private String nome;
	private int idade;
	private long cpf;
	private int rg;
	private boolean genero;
	private String email;
	private double peso;
	private double altura;
	private String status;
	private TelefoneUsuarioTO telefoneUsuario;
	private EnderecoUsuarioTO enderecoUsuario;
	
	
	//Criando uma lista de telefones de usuarios
	private List<TelefoneUsuarioTO> telUsuarios = new ArrayList<>();
	
	//Criando uma lista de enderecos de usuarios
	private List<EnderecoUsuarioTO> enderecoUsuarios = new ArrayList<>();
	
	public UsuarioTO() {};
	
	//Contrutor com variaveis porem sem o this para referencia-los
	public UsuarioTO(int id, int rg, boolean genero, long cpf, String email, String nome, int idade, double peso, double altura, String status) {}

	//Construtores com variaveis
	public UsuarioTO(int id, String nome, int idade, long cpf, int rg, boolean genero, String email, double peso,
			double altura, String status) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.rg = rg;
		this.genero = genero;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.status = status;
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public boolean getGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TelefoneUsuarioTO getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(TelefoneUsuarioTO telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public EnderecoUsuarioTO getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(EnderecoUsuarioTO enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public void setTelUsuarios(List<TelefoneUsuarioTO> telUsuarios) {
		this.telUsuarios = telUsuarios;
	}

	public List<TelefoneUsuarioTO> getTelUsuarios() {
		return telUsuarios;
	}

	public void setTelUsuario(List<TelefoneUsuarioTO> telUsuarios) {
		this.telUsuarios = telUsuarios;
	}

	public List<EnderecoUsuarioTO> getEnderecoUsuarios() {
		return enderecoUsuarios;
	}

	public void setEnderecoUsuarios(List<EnderecoUsuarioTO> enderecoUsuarios) {
		this.enderecoUsuarios = enderecoUsuarios;
	}
}
