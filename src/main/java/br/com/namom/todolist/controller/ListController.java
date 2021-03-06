package br.com.namom.todolist.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.namom.todolist.domain.ListDomain;
import br.com.namom.todolist.persistence.ListRepository;

@Controller
public class ListController {

	@Autowired
	private ListRepository repoList;

	public ListController(ListRepository repoList) {
		this.repoList = repoList;
	}

	@RequestMapping("")
	public String index(Model model) {
		return "index";
	}

	@Transactional
	@RequestMapping("mylists")
	public String lists(Model model) {
		Iterable<ListDomain> lists = repoList.findAll();
		model.addAttribute("lists", lists);
		return "mylists";
	}

	@Transactional
	@RequestMapping(value = "savelist", method = RequestMethod.POST)
	public String save(@RequestParam("name") String name, Model model) {

		// Validate Name Error
		if (name == null || name.isEmpty()) {
			throw new RuntimeException("List name cannot be empty or null");
		}

		ListDomain list = new ListDomain(name);

		repoList.save(list);

		return this.lists(model);
	}
	
	

}
