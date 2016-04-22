package elarib.webserver;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import elarib.webserver.controllers.Controller;
import elarib.webserver.filters.Filter;
import elarib.webserver.requests.HttpRequest;
import elarib.webserver.requests.HttpResponse;

public class MyWebFramework {
	
	private Map<String, Controller> controllers;
	private List<Filter> filters;
	
	
	public MyWebFramework(Map<String, Controller> controllers, List<Filter> filters) {
		this.controllers = controllers;
		this.filters = filters;
		
	}
	
	public HttpResponse handleRequest(HttpRequest req){
		HttpRequest currentRequest = req;
		for(Filter filter : filters){
			currentRequest = filter.doFilter(currentRequest);
		}
		
		Controller controller = controllers.get(currentRequest.getPath());
		
		if(controller == null)
			return null;
		
		return controller.handleRequest(currentRequest);		
	}

}
