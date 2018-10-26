package br.com.namom.todolist.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.namom.todolist.domain.TaskDomain;

public interface TaskRepository extends JpaRepository<TaskDomain, Long> {

}
