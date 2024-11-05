package br.edu.infnet.jefferson.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.repository.LocadoraRepository;

@Service
public class LocadoraService {
	
	@Autowired
	private LocadoraRepository locadoraRepository;

	private Map<String, Locadora> mapaLocadoras = new HashMap<String, Locadora>();

	public void incluir(Locadora locadora) {
		mapaLocadoras.put(locadora.getCnpj(), locadora);
		locadoraRepository.save(locadora);
	}

	public Collection<Locadora> ObterLista() {

		return mapaLocadoras.values();
	}

}