package br.com.soeirosantos;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class Runner {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		WebAppContext webapp = new WebAppContext();
		webapp.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		webapp.setResourceBase("src/main/webapp");
		webapp.setContextPath("/");
		webapp.setParentLoaderPriority(true);

		ContextHandler resourcesContext = new ContextHandler();
		resourcesContext.setContextPath("/resources");

		ResourceHandler resources = new ResourceHandler();
		resources.setDirectoriesListed(false);
		resources.setResourceBase("/home/romulo/");

		resourcesContext.setHandler(resources);
		
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { webapp, resourcesContext });
		
		server.setHandler(contexts);

		server.start();

		server.join();
	}

}
