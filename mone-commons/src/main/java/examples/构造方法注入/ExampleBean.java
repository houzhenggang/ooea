package examples.构造方法注入;

import java.beans.ConstructorProperties;
@SuppressWarnings( "unused" )
public class ExampleBean {
	private int	   years;
	private String ultimateAnswer;
	
	@ConstructorProperties( { "years", "ultimateAnswer" } )
	public ExampleBean ( int years , String ultimateAnswer ) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}
}