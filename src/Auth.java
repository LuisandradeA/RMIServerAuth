import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Auth extends UnicastRemoteObject implements IAuth{
	
	private Path log_file;
	
	protected Auth() throws RemoteException {
		super();
		log_file = Paths.get("log.txt");
		// TODO Auto-generated constructor stub
	}

	private ArrayList<MyUser> usuarios = new ArrayList();
	
	
	@Override
	public String cadastrar(String username, String password, String ip) throws IOException {
		// TODO Auto-generated method stub
		
		//Chama função para registrar no Log file
		addLog(username, ip, "Cadastro");
		
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
	public String login(String username, String password, String ip) throws IOException {
		// TODO Auto-generated method stub
		
		//Chama função para registrar no Log file
		addLog(username, ip, "Login");
		
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
	public String showUsers() throws RemoteException {
		// TODO Auto-generated method stub
		String retorno = "";
		for(MyUser item : usuarios){
			retorno = retorno + " /" + item.getUsername();
		}
	
		return retorno;
	}
	
	
	private void addLog (String username, String ip_adress, String acess_type) throws IOException {
		List<String> line = Arrays.asList(ip_adress + " _ " + username + " _ " + acess_type);
		Files.write(this.log_file, line,StandardOpenOption.APPEND);
		
		
	}
	
}
