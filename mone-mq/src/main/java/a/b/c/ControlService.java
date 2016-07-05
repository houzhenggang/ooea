package a.b.c;

/**
 * 
 * <br>类名： ControlService 
 *
 * <br>公司名称： 【】
 * <br>描述：【】
 * <br>创建时间： 2016年7月5日 下午4:35:57 
 * @author dogesoft
 */
public interface ControlService<T, E> {
	
	/**
	 * 
	 * <br>方法名： exec
	 * 
	 * <br>描述：【】 
	 * <br>创建时间： 2016年7月5日 下午4:36:05 
	 * @param param E
	 * @return T
	 */
	T exec ( E param );
}
