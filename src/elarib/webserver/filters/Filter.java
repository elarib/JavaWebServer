package elarib.webserver.filters;

import elarib.webserver.requests.HttpRequest;

public interface Filter {
	
	public HttpRequest doFilter(HttpRequest request);

}
