package br.edu.infnet.jefferson.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.jefferson.Constantes;
import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.service.LocadoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private LocadoraService locadoraService;
		
	@Operation(summary = "Recupera todas as locadoras existentes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public ResponseEntity<Collection<Locadora>> ObterLista() {
		return ResponseEntity.ok(locadoraService.obterLista());
	}
	
	
	@Operation(summary = "Inclui uma nova locadora")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Valid @RequestBody Locadora locadora) {
		
		locadoraService.incluir(locadora);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui uma locadora pelo ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		
		if(locadoraService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
			
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_REGISTRO_NOT_FOUND);
	}
	
	@Operation(summary = "Busca uma locadora pela razão social")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/buscar/{razaoSocial}")
	public ResponseEntity<List<Locadora>> obterPorRazaosocial(@PathVariable String razaoSocial){
		
		List<Locadora> locadoras = locadoraService.obterPorRazaosocial(razaoSocial);
		
		if(locadoras.isEmpty()){
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(locadoras);
		}
		
		return ResponseEntity.ok(locadoras);
	}
	
	@Operation(summary = "Busca uma locadora pelo ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/{id}")
	public ResponseEntity<Locadora> obterPorId(@PathVariable Integer id) {
		
		Locadora locadora = locadoraService.obterPorId(id);
		
		if(locadora == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(locadora);
	}
}
