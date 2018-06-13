package kr.ac.springboot.term.experience;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface experienceRepository extends CrudRepository<experience,Long> {
     
	List<experience> findAll();


}
