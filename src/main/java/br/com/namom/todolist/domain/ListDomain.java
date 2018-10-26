package br.com.namom.todolist.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ListDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Date date;

	@OneToMany(mappedBy = "myList", cascade = CascadeType.ALL)
	private List<TaskDomain> taks;

	public ListDomain(String name) {
		this.name = name;
		this.date = new Date();
	}

	public ListDomain() {	}

}
