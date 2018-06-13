package kr.ac.springboot.term.resume;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.experience.experience;
import kr.ac.springboot.term.reply.Resumereply;

@Entity
@Table(name="tbl_resume")
public class Resume {

	
	 public Resume() {
	 
	 }
	 public Resume(String sno,String name,String email,String introduce, String student ) {
	     this.sno= sno;
	     this.name=name;
	     this.email=email;
	     this.introduce=introduce;
	     this.student=student;
	 }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rno;
    private String name;
    private String sno;
    private String email;
	private String introduce;
    private String student;
    
    @JsonIgnore
    @OneToMany(mappedBy="resume",fetch=FetchType.LAZY)
    private List<Resumereply> reply;
    @JsonIgnore
    @OneToMany(mappedBy="resume",fetch=FetchType.LAZY)
    private List<experience> exper;
    
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

    
  
    public Long getRno() {
        return rno;
    }

    public void setRno(Long rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Resume [rno=" + rno + ", name=" + name + ", sno=" + sno + ", email=" + email + ", introduce="
				+ introduce + ", student=" + student + "]";
	}
    
}
