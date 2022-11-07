package br.com.fiap.baze.to;

public class CorridaTO {

	//Variaveis
	private int id;
	private double km;
	private double tempo;
	
	//Construtor vazio
	public CorridaTO() {}

	//Construtor com parametros e variaveis
	public CorridaTO(int id, double km, double tempo) {
		this.id = id;
		this.km = km;
		this.tempo = tempo;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getKm() {
		return km;
	}

	public void setCorrida(double km) {
		this.km = km;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}
}
