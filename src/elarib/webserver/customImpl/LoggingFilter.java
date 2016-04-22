package elarib.webserver.customImpl;

import elarib.webserver.filters.Filter;
import elarib.webserver.requests.HttpRequest;

public class LoggingFilter implements Filter {

	@Override
	public HttpRequest doFilter(HttpRequest request) {
		System.out.println("In Logging Filter - request for path: "
		    + request.getPath());
		return request;
	}

}