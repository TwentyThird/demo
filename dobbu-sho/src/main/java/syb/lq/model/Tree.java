package syb.lq.model;

import java.io.Serializable;
import java.util.List;

public class Tree implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private String text;
	
	private String url;
	
	private List<Tree> nodes;
	
	private String state;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Tree> getNodes() {
		return nodes;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	
}
