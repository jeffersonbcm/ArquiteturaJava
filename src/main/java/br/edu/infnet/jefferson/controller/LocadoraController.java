package br.edu.infnet.jefferson.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.service.LocadoraService;

@RestController
public class LocadoraController {
	
	@Autowired
	private LocadoraService locadoraService;
	
	
	@GetMapping(value = "lista/locadora")
	public Collection<Locadora> ObterLista() {
		
		return locadoraService.ObterLista();
	}
		
	@GetMapping(value = "/locadoras/buscar/{razaoSocial}")
	public List<Locadora> obterPorRazaosocial(@PathVariable String razaoSocial){
		
		return locadoraService.obterPorRazaosocial(razaoSocial);
	}
	
}
