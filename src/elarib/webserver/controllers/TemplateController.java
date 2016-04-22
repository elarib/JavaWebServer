package elarib.webserver.controllers;

import java.util.List;
import java.util.Map;

import elarib.webserver.requests.HttpRequest;
import elarib.webserver.requests.HttpResponse;
import elarib.webserver.views.RenderingException;
import elarib.webserver.views.View;

public abstract class TemplateController implements Controller{

	private View view;
	
	public TemplateController(View view) {
		this.view = view;
	}
	
	@Override
	public HttpResponse handleRequest(HttpRequest httpRequest) {
		int responseCode = 200;
		String responseBody = "";
		
		try{
			Map<String, List<String>> model = doRequest(httpRequest);
			responseBody = view.render(model);
		}catch(ControllerException e){
			responseCode = e.getStatusCode();
		}catch (RenderingException e) {
			responseCode = 500;
			responseBody = "Exception while rendering";
		}catch (Exception e) {
			responseCode = 500;
		}
		
		return HttpResponse.Builder.newBuilder()
				.body(responseBody)
				.responseCode(responseCode)
				.build();
	}
	
	protected abstract Map<String, List<String>> doRequest(HttpRequest httpRequest);

}
