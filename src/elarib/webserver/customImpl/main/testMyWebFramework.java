package elarib.webserver.customImpl.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import elarib.webserver.MyWebFramework;
import elarib.webserver.controllers.Controller;
import elarib.webserver.customImpl.GreetingController;
import elarib.webserver.customImpl.GreetingRenderingStrategy;
import elarib.webserver.customImpl.LoggingFilter;
import elarib.webserver.filters.Filter;
import elarib.webserver.requests.HttpRequest;
import elarib.webserver.requests.HttpResponse;
import elarib.webserver.views.StrategyView;

public class testMyWebFramework {
	
	public static void main(String[] args){
		
		MyWebFramework myFramework = new MyWebFramework(makeRoutes(), makeFilters());
		
		HttpRequest testRequest = HttpRequest.Builder.newBuilder()
				.path("greeting/")
				.body("Abdelhamide,EL ARIB,Kamal,Jamal")
				.addHeader("X-Example", "exampleHeader")
				.build();
		
		HttpResponse testResponse = myFramework.handleRequest(testRequest);
		
		System.out.println("responseCode: " + testResponse.getResponseCode());
		System.out.println("responseBody: ");
		System.out.println(testResponse.getBody());
	}
	
	private static Map<String, Controller> makeRoutes(){
		GreetingRenderingStrategy viewRenderer = new GreetingRenderingStrategy();
		StrategyView greetingView = new StrategyView(viewRenderer);
		GreetingController greetingController = new GreetingController(greetingView);
		
		Map<String, Controller> controllers = new HashMap<String, Controller>();
		controllers.put("greeting/", greetingController);
		return Collections.unmodifiableMap(controllers);
	}
	
	private static List<Filter> makeFilters(){
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(new LoggingFilter());
		return filters;
	}
	
}