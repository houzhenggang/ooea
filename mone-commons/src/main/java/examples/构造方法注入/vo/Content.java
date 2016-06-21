package examples.构造方法注入.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias( "content" )
public class Content implements Serializable {
	
	/**
	 * <br>
	 * 创建时间： 2016年6月14日 下午1:37:24
	 * @Fields serialVersionUID : TODO 【】
	 */
	private static final long serialVersionUID = -2519316901479684354L;
	@XStreamAlias( "id" )
	private String			  id;									   		// 发言人id
	@XStreamAlias( "name" )
	private String			  name;									   	// 发言人名字
	@XStreamAlias( "time" )
	private String			  time;									   	// 发言时间，格式YYYYMMDDTHHMMSS，如20160520T161201，日期和时间之间用“T”隔开。
	@XStreamAlias( "text" )
	private String			  text;									   	// 发言内容，base64编码。
	
	public String getId ( ) {
		return id;
	}
	
	public void setId ( String id ) {
		this.id = id;
	}
	
	public String getName ( ) {
		return name;
	}
	
	public void setName ( String name ) {
		this.name = name;
	}
	
	public String getTime ( ) {
		return time;
	}
	
	public void setTime ( String time ) {
		this.time = time;
	}
	
	public String getText ( ) {
		return text;
	}
	
	public void setText ( String text ) {
		this.text = text;
	}
	
	public Content ( ) {
		super();
	}
	
	public Content ( String id , String name , Date time , String text ) {
		super();
		this.id = id;
		this.name = name;
		this.time = timeToFormat(time);
		this.text = text;
	}
	
	private String timeToFormat ( Date time ) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String trimStr = format.format(time).replaceAll("-", "T");
		return trimStr;
	}
	
}
