package br.edu.infnet.jefferson.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.jefferson.model.domain.Moto;
import br.edu.infnet.jefferson.model.repository.MotoRepository;

@Service
public class MotoService {

	
	@Autowired
	private MotoRepository motoRepository;
	
	public Collection<Moto> obterLista(){
		return (Collection<Moto>) motoRepository.findAll();
	}
	
	public void incluir(Moto moto) {
		motoRepository.save(moto);
	}
	
	public long obterQtde() {
		return motoRepository.count();
	}
	
}
