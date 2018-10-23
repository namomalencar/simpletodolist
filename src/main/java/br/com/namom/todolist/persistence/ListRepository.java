package br.com.namom.todolist.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.namom.todolist.domain.ListDomain;

public interface ListRepository extends JpaRepository<ListDomain, Long> {

}
