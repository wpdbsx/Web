package kr.ac.springboot.term.reply;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.ac.springboot.term.resume.Resume;



public interface ResumereplyRepository extends CrudRepository<Resumereply,Long>  {
	 List<Resumereply> findAllByResumeOrderByUpdatedateDesc(Resume resume);
}
