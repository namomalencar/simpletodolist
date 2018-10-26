package br.com.namom.todolist.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.namom.todolist.domain.ListDomain;
import br.com.namom.todolist.domain.TaskDomain;
import br.com.namom.todolist.persistence.ListRepository;
import br.com.namom.todolist.persistence.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ListRepository listRepository;

	@Transactional
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String lists(@PathVariable("id") long idList, Model model) {
		ListDomain myList = listRepository.getOne(idList);
		model.addAttribute("mylist", myList);
		model.addAttribute("mytasks", myList.getTaks());
		return "list";
	}

	@Transactional
	@RequestMapping(value = "savetask", method = RequestMethod.POST)
	public String save(@RequestParam("idList") long idList, @RequestParam("taskName") String taskName, Model model) {
		ListDomain myList = listRepository.getOne(idList);
		TaskDomain task = new TaskDomain(taskName, myList);
		taskRepository.save(task);
		return this.lists(idList, model);
	}

}
