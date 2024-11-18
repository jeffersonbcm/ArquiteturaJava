package br.edu.infnet.jefferson.model.service;

import java.util.Collection;
import java.util.List;

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

	public Collection<Veiculo> obterLista() {

		return (Collection<Veiculo>) veiculoRepository.findAll();
	}

	public List<Veiculo> obterListaPorValor(float valorInicial, float valorFinal) {

		return veiculoRepository.findByValorBetween(valorInicial, valorFinal);
	}

	public long obterQtde() {
		return veiculoRepository.count();
	}

	public boolean excluir(Integer id) {
		veiculoRepository.deleteById(id);
		return true;
	}

	public List<Veiculo> obterPorMarca(String marca) {

		return veiculoRepository.findByMarcaContaining(marca);

	}

	public Veiculo obterPorId(Integer id) {
		return veiculoRepository.findById(id).orElse(null);
	}
}
