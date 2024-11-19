package br.edu.infnet.jefferson.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.jefferson.Constantes;
import br.edu.infnet.jefferson.model.domain.Veiculo;
import br.edu.infnet.jefferson.model.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@Operation(summary = "Recupera todos os veiculos existentes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "400", description = "Parametros Invalidos"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/lista")
	public Collection<Veiculo> ObterLista() {

		return veiculoService.obterLista();
	}

	@Operation(summary = "Busca um veiculo pelo valor mínimo e máximo")
	@GetMapping(value = "/filtrarPorValor")
	public ResponseEntity<List<Veiculo>> obterListaPorValor(@RequestParam float min, @RequestParam float max) {

		if (min < 0 || max < 0 || min > max) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		List<Veiculo> veiculos = veiculoService.obterListaPorValor(min, max);

		if (veiculos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(veiculos);
		}

		return ResponseEntity.ok(veiculos);
	}
	
	@Operation(summary = "Alterar valor um veiculo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@PatchMapping(value = "/alterar")
	public ResponseEntity<Veiculo> alterar(@RequestParam Integer id, @RequestParam float valor) {
		
		Veiculo veiculo = veiculoService.alterar(id, valor);
		
		return ResponseEntity.ok(veiculo);
	}
	
		
	@Operation(summary = "Exclui um veiculo pelo ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {

		if (veiculoService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);

		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_REGISTRO_NOT_FOUND);
	}

	@Operation(summary = "Busca um veiculo pela marca")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/buscar/{marca}")
	public ResponseEntity<List<Veiculo>> obterPorMarca(@PathVariable String marca) {

		List<Veiculo> veiculos = veiculoService.obterPorMarca(marca);

		if (veiculos.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(veiculos);
		}

		return ResponseEntity.ok(veiculos);

	}

	@Operation(summary = "Busca um veiculo pelo ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> obterPorId(@PathVariable Integer id) {
		
		Veiculo veiculo = veiculoService.obterPorId(id);
		
		if(veiculo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(veiculo);
	}
}
