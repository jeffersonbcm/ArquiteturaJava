package br.edu.infnet.jefferson.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public Locadora alterar(Locadora locadora) {

//		if (!locadoraRepository.existsById(locadora.getId())) {
//			throw new NaoEncontradoException(Constantes.MSG_REGISTRO_NOT_FOUND);
//		}

		return locadoraRepository.save(locadora);
	}

	public boolean excluir(Integer id) {
		locadoraRepository.deleteById(id);

		return true;
	}

	public Collection<Locadora> obterLista() {
		return (Collection<Locadora>) locadoraRepository.findAll();
	}

	public List<Locadora> obterPorRazaosocial(String razaosocial) {

		return locadoraRepository.findByRazaosocialContaining(razaosocial, Sort.by(Sort.Order.asc("razaosocial")));

	}

	public long obterQtde() {

		return locadoraRepository.count();
	}

	public Locadora obterPorId(Integer id) {
		return locadoraRepository.findById(id).orElse(null);
	}

}