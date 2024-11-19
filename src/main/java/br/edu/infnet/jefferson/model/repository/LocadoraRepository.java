package br.edu.infnet.jefferson.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.jefferson.model.domain.Locadora;

@Repository
public interface LocadoraRepository extends CrudRepository<Locadora, Integer> {
	
	List<Locadora> findByRazaosocialContaining(String razaosocial, Sort sort);

}
