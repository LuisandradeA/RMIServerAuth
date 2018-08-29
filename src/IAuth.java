import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuth extends Remote{
	
	public String cadastrar(String username, String password, String ip) throws RemoteException, IOException;
	public String login(String username, String password, String ip) throws RemoteException, IOException;
	public String showUsers()throws RemoteException;
}
