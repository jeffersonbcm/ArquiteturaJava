package br.edu.infnet.jefferson.model.domain;

public class Moto extends Veiculo {
	private String Cilindrada; 
	private float Autonomia;
	
	public String getCilindrada() {
		return Cilindrada;
	}
	public void setCilindrada(String cilindrada) {
		Cilindrada = cilindrada;
	}
	public float getAutonomia() {
		return Autonomia;
	}
	public void setAutonomia(float autonomia) {
		Autonomia = autonomia;
	} 
	
	
}