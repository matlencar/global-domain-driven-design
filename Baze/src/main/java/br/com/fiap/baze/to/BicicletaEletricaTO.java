package br.com.fiap.baze.to;

public class BicicletaEletricaTO extends BicicletaTO {

	//Variaveis
	private int codigo;
	private double amperesBateria;
	private double motor;
	private BicicletaTO bicicleta;
	
	//Construtor vazio
	public BicicletaEletricaTO() {}
	
	//Construtor com parametros e variaveis
	public BicicletaEletricaTO(int id, int aro, double quadro, double peso, double altura, String cor, String tipo,
			int marcha,int codigo, double amperesBateria, double motor, BicicletaTO bicicleta) {
		super(id, aro, quadro, peso, altura, cor, tipo, marcha);
		this.amperesBateria = amperesBateria;
		this.motor = motor;
		this.bicicleta = bicicleta;
		this.codigo = codigo;
	}
	
	//Construtor sem heran�a
	public BicicletaEletricaTO(int codigo, double amperesBateria, double motor) {
		this.codigo = codigo;
		this.amperesBateria = amperesBateria;
		this.motor = motor;
	}

	//Getters and Setter
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getAmperesBateria() {
		return amperesBateria;
	}

	public void setAmperesBateria(double amperesBateria) {
		this.amperesBateria = amperesBateria;
	}

	public double getMotor() {
		return motor;
	}

	public void setMotor(double motor) {
		this.motor = motor;
	}

	public BicicletaTO getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(BicicletaTO bicicleta) {
		this.bicicleta = bicicleta;
	}
}
