package edu.leicester.cw3.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ModuleRepository extends CrudRepository<Module, Integer> {
	Optional<Module> findById(long id);
	Optional<Module> deleteById(long id);


	

}
