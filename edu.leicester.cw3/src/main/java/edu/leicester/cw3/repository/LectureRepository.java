package edu.leicester.cw3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.leicester.cw3.entity.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Integer> {
	List<Lecture> findById(long id);
 

}
