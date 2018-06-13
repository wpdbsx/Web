package kr.ac.springboot.term.resume;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {
@Autowired
 ResumeRepository resumeRepo;
    // '/' ==> list
    // '/register' ==> create
    // '/{rno} ==> view
    // '/{rno}/update ==> update'
    // '/{rno}/delete ==> delete'

    @GetMapping("/")
    public String resumeIndex(Model model) {
       
    	model.addAttribute("resume",resumeRepo.findByName("제윤태"));

        return "resume";
    }
    

}
