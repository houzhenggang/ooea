package examples.构造方法注入;

public class ClientService {
	private static ClientService clientService = new ClientService();
	
	private ClientService ( ) {}
	
	public static ClientService createInstance ( ) {
		return clientService;
	}
}
