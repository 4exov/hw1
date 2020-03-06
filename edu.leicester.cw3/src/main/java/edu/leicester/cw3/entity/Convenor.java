package edu.leicester.cw3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Convenor {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String position;
	private String office;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	
	
	
	public Convenor() {}
	
	public Convenor(String name, String position, String office) {
		this.setName(name);
		this.setPosition(position);
		this.setOffice(office);

	}
}