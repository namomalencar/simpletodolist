package br.com.namom.todolist.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.namom.todolist.domain.ListDomain;
import br.com.namom.todolist.persistence.Lists;

@Controller
@RequestMapping("/lists")
public class ListController {

	@Autowired
	private Lists lists;

	@GetMapping
	public ModelAndView list() {
		List<ListDomain> list = lists.findAll();

		ModelAndView modelAndView = new ModelAndView("lists");
		modelAndView.addObject("lists", list);

		return modelAndView;
	}
	
	@Transactional
	public void save(ListDomain list) {
		lists.save(list);
	}
	
	
	

}
