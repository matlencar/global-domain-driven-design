package br.com.fiap.baze.validacao;

/**
 * Essa classe serve para validar se a string inserida é nula ou é vazia
 * @author Global Solution Baze
 *
 */
public class UtilValidacao {
	
	public static boolean isNullOrEmpty(String variavel) {
		return variavel == null || variavel.equals("");
		
	}
	
	/**
	 * Esse metodo é usado para verificar e valida se a string possui mais caracteres do que o permitido
	 */
	
	public static boolean isGreaterThan(String variavel, int quantidade) {
		return variavel != null && variavel.length() > quantidade;
	}
}
