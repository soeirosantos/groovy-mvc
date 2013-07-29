package br.com.soeirosantos.model


class AllTasks {

	def tasks = [] as LinkedHashMap<String, Task>

	def add(Task task) {
		tasks[task.code] = task
	}

	def remove(String code) {
		tasks.remove(code)
	}

	def get(String code) {
		return tasks[code]
	}

	def all() {
		return tasks.values() as List<Task>
	}
}
