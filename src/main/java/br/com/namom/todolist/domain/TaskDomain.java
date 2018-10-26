package br.com.namom.todolist.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class TaskDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Date date;

	private Boolean status;

	@ManyToOne
	@JoinColumn(name = "id_list_domain")
	private ListDomain myList;

	public TaskDomain(String name, ListDomain mylist) {
		this.name = name;
		this.date = new Date();
		this.status = true;
		this.myList = mylist;
	}

	public TaskDomain() {
	}

}
