package br.edu.infnet.jefferson.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.jefferson.model.domain.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {

}
