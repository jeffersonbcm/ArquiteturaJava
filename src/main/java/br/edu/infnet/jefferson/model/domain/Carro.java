package br.edu.infnet.jefferson.model.domain;

public class Carro extends Veiculo {
	private String categoria; 
	private boolean gps;
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isGps() {
		return gps;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	
	
	
}
