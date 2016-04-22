package elarib.webserver.customImpl;

import java.util.*;

import elarib.webserver.controllers.TemplateController;
import elarib.webserver.requests.HttpRequest;
import elarib.webserver.views.View;

public class GreetingController extends TemplateController{

	private Random random;
	
	public GreetingController(View view) {
		super(view);
		random = new Random();
	}

	@Override
	protected Map<String, List<String>> doRequest(HttpRequest httpRequest) {
		
		Map<String, List<String>> helloModel = new HashMap<String, List<String>>();
		
		helloModel.put("greetings", generateGreetings(httpRequest.getBody()));
		return helloModel;
	}
	
	

	private List<String> generateGreetings(String namesCommaSeperated) {
		String[] names = namesCommaSeperated.split(",");
		List<String> greetings = new ArrayList<String>();
		for (String name : names) {
			greetings.add(makeGreeting(name));
		}
		return greetings;
	}

	private String makeGreeting(String name) {
		String[] greetings = 
			{ "Hello", "Greetings", "Salutations", "Hola" };
		String greetingPrefix = greetings[random.nextInt(4)];
		return String.format("%s, %s", greetingPrefix, name);
	}
	
	
	
}
