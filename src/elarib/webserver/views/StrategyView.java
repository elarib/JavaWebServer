package elarib.webserver.views;

import java.util.List;
import java.util.Map;


// this, is the proper implementation of the Framework, how it renders the views
public class StrategyView implements View{
	
	private RenderingStrategy viewRenderer;
	
	public StrategyView(RenderingStrategy viewRenderer){
		this.viewRenderer = viewRenderer;
	}

	@Override
	public String render(Map<String, List<String>> model) throws RenderingException {
		try{
			return viewRenderer.renderView(model);
		}catch(Exception e){
			throw  new RenderingException(e);
		}
	}

}
