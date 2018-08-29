import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {
	public static void main(String[] args)throws NotBoundException, IOException{
		IAuth stub = (IAuth) Naming.lookup("rmi://localhost/MyAuth");
		
		String ip = new GenerateIP().GenerateRandomIP();
		
		
		System.out.println("--> Cadastrando usuario(Luis,12345)");
		String resultadoPrimeiroCadastro = stub.cadastrar("Luis", "12345", ip);
		System.out.println("RETORNO: " + resultadoPrimeiroCadastro);
		
		System.out.println("--> Cadastrando usuario(Jose,123456)");
		String resultadoSegundoCadastro = stub.cadastrar("Jose", "123456", ip);
		System.out.println("RETORNO: " + resultadoSegundoCadastro);
		
		System.out.println("--> Cadastrando usuario(Luis,12345) Novamente");
		String resultadoTerceiroCadastro = stub.cadastrar("Luis", "12345", ip);
		System.out.println("RETORNO: " + resultadoTerceiroCadastro);
		
		System.out.println("--> Usuarios cadastrados:");
		String getUsuarios = stub.showUsers();
		System.out.println("RETORNO: " + getUsuarios);
		
		System.out.println("--> Logando usuario(Luis,12345) ");
		String login1 = stub.login("Luis", "12345", ip);
		System.out.println("RETORNO: " + login1);
		
		
	}
}
