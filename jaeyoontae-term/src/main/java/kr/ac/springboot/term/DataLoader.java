package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.experience;
import kr.ac.springboot.term.experience.experienceRepository;
import kr.ac.springboot.term.reply.Resumereply;
import kr.ac.springboot.term.reply.ResumereplyRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {
    
	@Autowired
	private ResumeRepository resumeRepo;
	@Autowired
	private experienceRepository experRepo;
	@Autowired
	private ResumereplyRepository replyRepo;
	Resume resume =new Resume("2014558113","제윤태","wpdbsx@naver.com","반갑습니다","경성대학교 소프트웨어학과") ;
	
    @Override
    public void run(ApplicationArguments args) {
        // 초기 데이터 입력
    	resumeRepo.save(resume);
    	experRepo.save(new experience("졸업","개금고등학교 졸업","2014년 2월 졸업","2011년~2013년",resume));
        experRepo.save(new experience("입학","경성대학교 입학","2014년 3월 입학","2014년~2019년",resume));
        experRepo.save(new experience("토익","토익880점","2017년 2월 획득","2016년 5월~2017년 2월",resume));
        experRepo.save(new experience("자격증","SQLP","2018년 5월 획득","2018년 1월~5월",resume));
        replyRepo.save(new Resumereply("나나","느는",resume));
    	
    }

}