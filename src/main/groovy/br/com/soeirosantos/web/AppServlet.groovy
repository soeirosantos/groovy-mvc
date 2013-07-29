package br.com.soeirosantos.web

import javax.inject.Inject
import javax.servlet.RequestDispatcher
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AppServlet extends HttpServlet {

	@Inject
	Map<String, Closure> actionMap
	
	@Override
	def void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String next;

		try {
			def action = req.getParameter("action")
            def doAction = actionMap.get(action, {return "404.html"})
			next = doAction(req)
		}
		catch (Exception e) {
			throw new ServletException(e);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(next)
		dispatcher.forward(req, res)
	}

}
