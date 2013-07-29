package br.com.soeirosantos.model

class Task {

	def Task(String code, String name, String description) {
		this.code = code
		this.name = name
		this.description = description
	}
	
	String code
	String name
	String description
	String notes
	
	Date beginDate
	Date endDate
		
}
