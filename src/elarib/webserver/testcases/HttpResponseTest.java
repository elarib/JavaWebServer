package elarib.webserver.testcases;
import elarib.webserver.requests.HttpResponse;
import junit.framework.TestCase;

public class HttpResponseTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testHttpResponse(){
		HttpResponse testResponse = HttpResponse.Builder.newBuilder()
				.responseCode(200)
				.body("<p>Hello World<p>")
				.build();
		
		assertEquals(testResponse.getBody(), "<p>Hello World<p>");
		assertEquals(testResponse.getResponseCode(), 200);
		
	}
	
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
