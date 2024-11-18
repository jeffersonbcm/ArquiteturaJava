package br.edu.infnet.jefferson.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.jefferson.model.domain.Moto;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {

}
