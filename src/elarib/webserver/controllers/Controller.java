package elarib.webserver.controllers;

import elarib.webserver.requests.HttpRequest;
import elarib.webserver.requests.HttpResponse;

public interface Controller {
	public HttpResponse handleRequest(HttpRequest httpRequest);

}
