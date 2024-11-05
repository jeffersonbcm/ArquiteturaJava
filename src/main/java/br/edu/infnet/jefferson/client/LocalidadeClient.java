package br.edu.infnet.jefferson.client;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.jefferson.model.domain.Estado;
import br.edu.infnet.jefferson.model.domain.Municipio;

//https://servicodados.ibge.gov.br/api/v1/localidades/estados
//https://servicodados.ibge.gov.br/api/v1/localidades/estados/13/municipios

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", value = "localidadeClient")
public interface LocalidadeClient {

	@GetMapping(value = "/estados")
	Collection<Estado> obterEstados();
	
	@GetMapping(value = "/estados/{uf}/municipios")
	Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
	
}
