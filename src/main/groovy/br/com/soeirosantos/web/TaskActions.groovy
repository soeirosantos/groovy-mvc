package br.com.soeirosantos.web

import javax.inject.Inject
import javax.servlet.http.HttpServletRequest

import br.com.soeirosantos.model.AllTasks
import br.com.soeirosantos.model.Task

class TaskActions {

	@Inject
	AllTasks allTasks
	
	def index = { HttpServletRequest req -> 
		
		return "/pages/index.html"
	}

	def list = { HttpServletRequest req -> 
		req.setAttribute("tasks", allTasks.all())
		return "/pages/list.html"
	}

	def show = { HttpServletRequest req -> 
		String code = req.getParameter("code")
		req.setAttribute("task", allTasks.get(code))
		return "/pages/show.html"
	}

	def create = { HttpServletRequest req ->  
		return "/pages/create.html"
	}
	
	def insert = { HttpServletRequest req -> 
		String code = req.getParameter("code")
		String name = req.getParameter("name")
		String description = req.getParameter("description")
		Task task = new Task(code, name, description)
		allTasks.add(task)
		return show(req)
	}

	def edit = { HttpServletRequest req -> 
		String code = req.getParameter("code")
		req.setAttribute("task", allTasks.get(code))
		return "/pages/edit.html"
	}

	def update = { HttpServletRequest req -> 
		String code = req.getParameter("code")
		String newName = req.getParameter("name")
		String newDescription = req.getParameter("description")
		Task task = allTasks.get(code)
		task.name = newName
		task.description = newDescription 
		return show(req)
	}

	def remove = { HttpServletRequest req -> 
		allTasks.remove(req.getParameter("code"))
		return list(req)
	}
	
}
