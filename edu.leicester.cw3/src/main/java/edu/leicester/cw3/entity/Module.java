package edu.leicester.cw3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Module {
	@Id
	@GeneratedValue
	private long id;
	private String code;
	private String title;
	private int semester;
	private boolean core;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Convenor convenor;
	
	@OneToMany(mappedBy="module", cascade = CascadeType.ALL)
	private List<Lecture> lectures;
	
	public Module() {}
	
	public Module (String code, String title, int semester, boolean core) {
	this.setCode(code);
	this.setTitle(title);
	this.setSemester(semester);
	this.setCore(core);
	this.setConvenor(convenor);
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public boolean isCore() {
		return core;
	}

	public void setCore(boolean core) {
		this.core = core;
	}

	public Convenor getConvenor() {
		return convenor;
	}

	public void setConvenor(Convenor convenor) {
		this.convenor = convenor;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}


	
}
