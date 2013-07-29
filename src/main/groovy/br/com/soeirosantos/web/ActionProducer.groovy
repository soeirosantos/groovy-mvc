package br.com.soeirosantos.web

import groovy.lang.Closure;

import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

class ActionProducer {
	
	@Inject
	TaskActions taskActions
	
	@Produces
	def Map<String, Closure> createActionMap() {
		return ["index":taskActions.index
				,"show": taskActions.show
				,"list":taskActions.list
				,"create":taskActions.create
				,"insert":taskActions.insert
				,"edit":taskActions.edit
				,"update":taskActions.update
				,"remove":taskActions.remove] as HashMap<String, Closure>
	}
	
}
