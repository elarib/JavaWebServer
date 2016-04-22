package elarib.webserver.views;

import java.util.*;

// It's the one responsible for doing rendering view
public interface RenderingStrategy {
	
	public String renderView(Map<String, List<String>> model);

}
