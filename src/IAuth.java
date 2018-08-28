import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuth extends Remote{
	
	public String cadastrar(String username, String password) throws RemoteException;
	public String login(String username, String password) throws RemoteException;
	public String gerarLog()throws RemoteException;
}
