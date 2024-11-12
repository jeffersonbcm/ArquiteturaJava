package br.edu.infnet.jefferson.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.jefferson.model.domain.Veiculo;
import br.edu.infnet.jefferson.model.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public void incluir(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
		
	}
	
}
