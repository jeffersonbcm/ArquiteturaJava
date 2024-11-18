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
import br.edu.infnet.jefferson.model.domain.Moto;
import br.edu.infnet.jefferson.model.service.MotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/motos")
public class MotoController {

	
	@Autowired
	private MotoService motoService;
	
	@Operation(summary = "Recupera todas as motos existentes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Moto>> ObterLista() {
		
		return ResponseEntity.ok(motoService.obterLista());
	}
	
	@Operation(summary = "Inclui uma novo moto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Moto moto) {
		
		motoService.incluir(moto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
}
