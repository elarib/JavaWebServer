package elarib.webserver.views;

public class RenderingException extends Exception {
	
	public RenderingException(Exception e) {
		super(e);
		System.out.println("Exception was thrown, cause : "+e.getMessage());
	}

}
