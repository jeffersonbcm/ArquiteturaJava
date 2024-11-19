package br.edu.infnet.jefferson.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.jefferson.Constantes;
import br.edu.infnet.jefferson.exceptions.RegistroNaoEncontradoException;
import br.edu.infnet.jefferson.model.domain.Carro;
import br.edu.infnet.jefferson.model.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public Collection<Carro> obterLista(){
		return (Collection<Carro>) carroRepository.findAll();
	}
	
	public void incluir(Carro carro) {
		carroRepository.save(carro);
	}
	
	public Carro alterar(Carro carro) {

		if (!carroRepository.existsById(carro.getId())) {
			throw new RegistroNaoEncontradoException(Constantes.MSG_REGISTRO_NOT_FOUND);
		}

		return carroRepository.save(carro);
	}
	
	public long obterQtde() {
		return carroRepository.count();
	}
	
}
