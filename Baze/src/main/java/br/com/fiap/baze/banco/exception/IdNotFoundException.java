package br.com.fiap.baze.banco.exception;

public class IdNotFoundException extends Exception {
	
	public IdNotFoundException() {}
	
	public IdNotFoundException(String mensagem) {
		super(mensagem);
	}
}
