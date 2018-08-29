
public class GenerateIP {
	public String GenerateRandomIP () {
		int p1, p2, p3, p4;
		
		p1 = (int)(Math.random() * 256);
		p2 = (int)(Math.random() * 256);
		p3 = (int)(Math.random() * 256);
		p4 = (int)(Math.random() * 256);
		
		String ip = (p1+"."+p2+"."+p3+"."+p4);		
		return ip;
	}
}
