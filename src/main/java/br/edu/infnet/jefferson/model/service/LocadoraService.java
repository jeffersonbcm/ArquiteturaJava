package br.edu.infnet.jefferson.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.jefferson.model.domain.Endereco;
import br.edu.infnet.jefferson.model.domain.Locadora;
import br.edu.infnet.jefferson.model.repository.LocadoraRepository;

@Service
public class LocadoraService {
	
	@Autowired
	private LocadoraRepository locadoraRepository;
	
	@Autowired
	private LocalizacaoService localizacaoService;

	public Locadora incluir(Locadora locadora) {
		
		String cep = locadora.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);
		
		locadora.setEndereco(endereco);
		
		return locadoraRepository.save(locadora);
	}

	public Collection<Locadora> ObterLista() {

		return (Collection<Locadora>) locadoraRepository.findAll();
	}

	public List<Locadora> obterPorRazaosocial(String razaosocial) {
	
	return locadoraRepository.findByRazaosocialContaining(razaosocial);
	
	}
}	