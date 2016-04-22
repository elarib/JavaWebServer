package elarib.webserver.views;

import java.util.List;
import java.util.Map;

public interface View {
	
	public String render(Map<String, List<String>> model) throws RenderingException;

}
