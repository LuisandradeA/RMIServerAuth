import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {
	public static void main(String[] args)throws RemoteException, MalformedURLException{
		//Cria registro RMI 
		LocateRegistry.createRegistry(1099);
		
		Auth a = new Auth();
		
		//Endereço de comunicacao do servidor
		Naming.rebind("rmi://localhost/MyAuth", a);
		
		System.out.println("SERVIDOR PRONTO...");
	
	}
}