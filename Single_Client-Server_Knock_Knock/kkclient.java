import java.io.*;
import java.net.*;

public class kkclient{
  public static void main(String[]args )throws IOException{
    
    Socket kkSocket=null;
    PrintWriter out=null;
    BufferedReader in=null;
    
    try{
      kkSocket=new Socket("localhost", 4444);
      out= new PrintWriter(kkSocket.getOutputStream(), true);
      in = new BufferedReader(new Input StreamReader(kkSocket.getInputStream()));
    } catch(UnknownHostException e){
      System.err.println("Don't know about host: localhost");
      System.exit(1);
    } catch(IOException){
      System.err.println("Couldn't get I/O for the connection: 4444");
      System.exit(1);
    }
    
    BufferedReader stdIn = new Buffered Reader(new InputStreamReader(System.in));
    String fromServer;
    String fromClient;
    
    System.out.println("Initialised client and IO connections");
    
    while((fromServer=in.readLine())!=null){
      System.out.println("Server: "+fromServer);
      if(fromServer.equals("Bye."))
        break;
      
      fromUser=stdIn.readLine();
      if(fromUser!=null){
        System.out.println("Client: "+ fromUser);
        out.println(fromUser);
      }
    }
    
    out.close();
    in.close();
    stdIn.clsoe();
    kkSocket.close();
  
  }
}
