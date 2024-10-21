package br.edu.infnet.jefferson.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.jefferson.model.domain.Vendedor;
import br.edu.infnet.jefferson.model.service.VendedorService;

@RestController
public class VendedorController {
	@Autowired
	private VendedorService vendedorservice;
	
	
	@GetMapping(value = "lista/vendedor")
	public Collection<Vendedor> ObterLista() {

		return vendedorservice.ObterLista();
	}
}
