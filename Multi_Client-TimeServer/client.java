import java.net.*;
import java.io.*;

public class client {

	public static void main(String[] args) throws IOException {
		Socket socket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		
		try {
			socket=new Socket("localhost", 4444);
			out=new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
		}catch(UnknownHostException e) {
			System.err.println("Don't known about host: localhost");
			System.exit(1);
		}catch(IOException e) {
			System.err.println("Couldn't get I/O for the connection to: 4444");
			System.exit(1);
		}
		
		System.out.println("Initialised client and IO connections");
		
		String fromServer;
		while((fromServer=in.readLine())!=null) {
			out.println("What time is it?");
			System.out.println("from server: "+fromServer);
		}
	}
}
