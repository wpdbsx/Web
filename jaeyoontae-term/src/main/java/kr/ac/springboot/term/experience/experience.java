package kr.ac.springboot.term.experience;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
@Table(name="tbl_experience")

public class experience {
            
	public experience() {
		
	}
	public experience(String role,String content,String detail,String date,Resume resume) {
		 this.role = role;
		 this.content= content;
		 this.detail=detail;
		 this.date=date;
		 this.resume=resume;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bno;
	private String role;
	private String content;
	private String detail;
	private String date;
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Resume resume;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public Long getBno() {
		return bno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "experience [bno=" + bno + ", role=" + role + ", content=" + content + ", detail=" + detail + ", resume="
				+ resume + "]";
	}
	
	
	
}
