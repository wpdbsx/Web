package kr.ac.springboot.term.experience;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.springboot.term.resume.Resume;



@Controller

public class experienceController {
    @Autowired
     private experienceRepository experRepo;
    
      //@Autowired
    //private ResumeRepository resumRepo;
    @GetMapping("/experience")
    public String experienceIndex(Model model){
    	model.addAttribute("exper",experRepo.findAll());
    
      return "experience";
    }
    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") experience vo) {
    	
    }
    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") experience vo) {
    	Resume resume = new Resume();
    	resume.setRno(1L);
       vo.setResume(resume); 
    	//vo.setResume(resumRepo.findById(1L).get());
    	
    	experRepo.save(vo);
    	
    	return "redirect:/experience";
    }
    @GetMapping("/{bno}")
    public String view(@PathVariable("bno") long bno, Model model) {
      if(experRepo.findById(bno).isPresent()) {
    	  model.addAttribute("exper",experRepo.findById(bno).get());
      }else {
    	  return "errors/404";
      }
    return "/view";
}
    @GetMapping("/{bno}/update")
    public String editGet(@PathVariable("bno") long bno, @ModelAttribute("vo") experience vo, Model model ) {
      if(experRepo.findById(bno).isPresent()) {
    	model.addAttribute("vo",experRepo.findById(bno).get());
    } else {
    	return "errors/404";
    }
    return "/update";
    }
    
    @PostMapping("/update")
    public String editPost(@ModelAttribute("vo") experience vo) {
    Optional<experience> experience = experRepo.findById(vo.getBno());    
	if(experience.isPresent()) {
		experience.get().setRole(vo.getRole());
		experience.get().setContent(vo.getContent());
		experience.get().setDetail(vo.getDetail());
		experience.get().setDate(vo.getDate());
	     experRepo.save(experience.get());
	 }      else {
		    experRepo.save(vo);
	 }
	return "redirect:/experience";
            }
    @GetMapping("/{bno}/delete")
    public String delete(@PathVariable("bno") long bno) {
    	if(experRepo.findById(bno).isPresent()) {
    		experRepo.deleteById(bno);
    	} else {
    		 return "errors/404";
    	}
    	return "redirect:/experience";
    }
    		
    	
    
}
