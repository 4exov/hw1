package edu.leicester.cw3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.leicester.cw3.entity.Convenor;

public interface ConvenorRepository extends CrudRepository<Convenor, Integer> {
	List<Convenor> findById(long id);
 

}
