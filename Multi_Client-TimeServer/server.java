import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) {
		
		ServerSocket socket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		
		InetAddress compAddr=null;
		boolean listening=true;
		
		try {
			compAddr=InetAddress.getLocalHost();
		}catch(IOException e) {
			System.out.println(e);
		}
		
		System.out.println("The address of this computer is: "+ compAddr);
		
		ServerSocket serverSocket=null;
		
		try {
			serverSocket=new ServerSocket(4444);
		}catch(IOException e){
			System.out.println("Couldn't listen on port: 4444");
			System.exit(1);
		}
		
		System.out.println("Server started");
		
		while(listening) {
			new sthread(serverSocket.accept()).start();
			System.out.println("New server thread started");
		}
		serverSocket.close();

	}
}
