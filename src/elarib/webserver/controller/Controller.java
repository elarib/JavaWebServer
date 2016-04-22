package elarib.webserver.controller;

import elarib.webserver.HttpRequest;
import elarib.webserver.HttpResponse;

public interface Controller {
	public HttpResponse handleRequest(HttpRequest httpRequest);

}
