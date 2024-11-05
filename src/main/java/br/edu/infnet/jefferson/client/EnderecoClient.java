package br.edu.infnet.jefferson.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.jefferson.model.domain.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", value = "enderecoClient")
public interface EnderecoClient {
		
	@GetMapping(value = "/{cep}/json/")
	Endereco findByCep(@PathVariable String cep);

}
