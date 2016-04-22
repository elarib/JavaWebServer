
public class HttpResponse {
	
	private final String body;
	private final int responseCode;
	
	public String getBody(){
		return body;
	}
	
	public int getResponseCode(){
		return responseCode;
	}
	
	private HttpResponse(Builder builder){
		body = builder.body;
		responseCode = builder.responseCode;
	}
	
	
	// I encapsulate all mutability inside the builder object
	// this Object is the one who give us an immutable HttpResponse via build() method
	public static class Builder{
		private String body;
		private int responseCode;
		
		public Builder body(String body){
			this.body = body;
			return this;
		}
		public Builder responseCode(int responseCode){
			this.responseCode = responseCode;
			return this;
		}
		
		public HttpResponse build(){
			return new HttpResponse(this);
		}
		
		public static Builder newBuilder(){
			return new Builder();
		}
		
	}

}
