package a.b.c;

public interface ControlService<T, E> {
	
	T exec ( E request );
}
