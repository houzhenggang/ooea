package examples.构造方法注入.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("record")
public class Record implements Serializable{
	/** 
	 * <br>创建时间： 2016年6月14日 下午1:38:03 
	 * @Fields serialVersionUID : TODO 【】
	 */ 
	private static final long serialVersionUID = -3891628264918135421L;
	@XStreamAlias("contents")
	private List<Content> contents = new ArrayList<Content>();
	
	public List<Content> getContents ( ) {
		return contents;
	}
	
	public void setContents ( List<Content> contents ) {
		this.contents = contents;
	}
	
}
