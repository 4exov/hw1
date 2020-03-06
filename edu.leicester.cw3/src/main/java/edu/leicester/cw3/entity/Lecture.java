package edu.leicester.cw3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Lecture {
	@Id
	@GeneratedValue
	private long id;
	private int week;
	private String title;
	private String slides;
	@OneToMany(mappedBy="lecutre", cascade = CascadeType.ALL)
	private List<Module> modules;
	
	public Lecture() {}
	
	public Lecture(int week, String title, String slides) {
		this.setWeek(week);
		this.setTitle(title);
		this.setSlides(slides);
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlides() {
		return slides;
	}

	public void setSlides(String slides) {
		this.slides = slides;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	
	}


