package kr.ac.springboot.term.reply;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.springboot.term.resume.Resume;


@RestController
@RequestMapping("/replies/*")
public class ResumereplyController {


    @Autowired
    private ResumereplyRepository replyRepo;

//    @Autowired
//    private WebBoardReplyRepository boardRepo;

    @GetMapping("/{rno}")
    public ResponseEntity<List<Resumereply>> getReplies(@PathVariable("rno") Long rno) {

        Resume resume = new Resume();
        resume.setRno(rno);
        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/{rno}")
    public ResponseEntity<List<Resumereply>> addReply(@PathVariable("rno") Long rno, @RequestBody Resumereply reply) {

        Resume resume = new Resume();
        resume.setRno(rno);

        reply.setResume(resume);

        replyRepo.save(reply);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{rno}/{no}")
    public ResponseEntity<List<Resumereply>> remove(
            @PathVariable("rno") Long rno,
            @PathVariable("no") Long no) {

        replyRepo.deleteById(no);

        Resume resume= new Resume();
        resume.setRno(rno);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);

    }


    @Transactional
    @PutMapping("/{rno}")
    public ResponseEntity<List<Resumereply>> modify(@PathVariable("rno") Long rno, @RequestBody Resumereply reply) {

        replyRepo.findById(reply.getNo()).ifPresent(origin -> {
            origin.setReplyText(reply.getReplyText());
            origin.setReplyer(reply.getReplyer());
            replyRepo.save(origin);
        });

        Resume resume = new Resume();
        resume.setRno(rno);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }

    private List<Resumereply> getListByResume(Resume resume) throws RuntimeException {
        return replyRepo.findAllByResumeOrderByUpdatedateDesc(resume);
    }
}
