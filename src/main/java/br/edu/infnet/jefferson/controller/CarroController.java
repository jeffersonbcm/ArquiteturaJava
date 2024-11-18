package br.edu.infnet.jefferson.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.jefferson.Constantes;
import br.edu.infnet.jefferson.model.domain.Carro;
import br.edu.infnet.jefferson.model.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/carros")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@Operation(summary = "Recupera todos os carros existentes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Carro>> ObterLista() {
		
		return ResponseEntity.ok(carroService.obterLista());
	}
	
	@Operation(summary = "Inclui um novo carro")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Carro carro) {
		
		carroService.incluir(carro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	

}
