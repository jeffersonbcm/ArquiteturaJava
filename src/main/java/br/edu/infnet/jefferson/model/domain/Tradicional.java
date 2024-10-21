package br.edu.infnet.jefferson.model.domain;

public class Tradicional extends Produto {
	private String TipoRelogio; //Digital, Analogico ou Digiana
	private String TipoPulseira; // Aco, Couro ou Borracha
	
	public String getTipoRelogio() {
		return TipoRelogio;
	}
	public void setTipoRelogio(String tipoRelogio) {
		TipoRelogio = tipoRelogio;
	}
	public String getTipoPulseira() {
		return TipoPulseira;
	}
	public void setTipoPulseira(String tipoPulseira) {
		TipoPulseira = tipoPulseira;
	}

}
