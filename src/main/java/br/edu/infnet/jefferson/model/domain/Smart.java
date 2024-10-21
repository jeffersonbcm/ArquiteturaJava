package br.edu.infnet.jefferson.model.domain;

public class Smart extends Produto {
	private boolean gps; // Tem GPS?
	private boolean batimentos; // Tem Leitor de Batimentos Cardiacos?
	
	public boolean isGps() {
		return gps;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	public boolean isBatimentos() {
		return batimentos;
	}
	public void setBatimentos(boolean batimentos) {
		this.batimentos = batimentos;
	}
	

	
}
