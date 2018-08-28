import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Auth extends UnicastRemoteObject implements IAuth{
	
	
	protected Auth() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private ArrayList<MyUser> usuarios = new ArrayList();
	
	
	@Override
	public String cadastrar(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		
		//cria objeto MyUser
		MyUser u = new MyUser(username, password);
	
		//percorrer lista de usuarios para checar se usuario ja existe
		for(MyUser item : usuarios){
			if(item.getUsername().equals(u.getUsername())){
				return "Este Username ja existe! por favor escolha outro";
			}
		}
		
		//caso nao esteja, inserir na lista de usuarios e retornar mensagem de sucesso
		usuarios.add(u);
		return "Usuario " + u.getUsername()+ " cadastrado com sucesso";
		
	}

	@Override
	public String login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		
		//cria objeto MyUser
		MyUser u = new MyUser(username, password);
	
		//percorrer lista de usuarios
		for(MyUser item : usuarios){
			
			//checa se username existe
			if(item.getUsername().equals(u.getUsername())){
				//checa se password eh igual
				if(item.getPassword().equals(u.getPassword())){
					return "Usuario " + u.getUsername() + " logado com sucesso";
				}
				else{
					return "Senha errada para " + u.getUsername() + ". Tente novamente.";
				}
			}
		
		}
	
		return "Usuario nao esta cadastrado. Por favor, cadastre-se primeiro.";
	}

	@Override
	public String gerarLog() throws RemoteException {
		// TODO Auto-generated method stub
		String retorno = "";
		for(MyUser item : usuarios){
			retorno = retorno + " /" + item.getUsername();
		}
	
		return retorno;
	}
	
}
