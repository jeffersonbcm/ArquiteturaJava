package br.edu.infnet.jefferson.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.service.LocadoraService;

@RestController
public class LocadoraController {
	@Autowired
	private LocadoraService locadoraservice;
	
	
	@GetMapping(value = "lista/locadora")
	public Collection<Locadora> ObterLista() {

		return locadoraservice.ObterLista();
	}
}
