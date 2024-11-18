package br.edu.infnet.jefferson.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.jefferson.model.domain.Veiculo;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {


	List<Veiculo> findByValorBetween(float valorInicial, float valorFinal);
	
	List<Veiculo> findByMarcaContaining(String marca);

}
