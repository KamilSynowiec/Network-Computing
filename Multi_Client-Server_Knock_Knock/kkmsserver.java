import java.io.*;
import java.net.*;

public class kkmsserver{

public static void main(String[]args) throws IOException{
  InetAddress compAddr=null;
  
  try{
    compAddr=InetAddress.getLocalHost();
  }catch(UnknownhostException e){
    System.out.println(e);
  }
  
  System.out.println("The address of this computer is..."+ compAddr);
  
  ServerSocket serverSocket=null;
  boolean listening=true;
  
  try{
    serverSocket=new ServerSocket(4444);
  }catch(IOException e){
    System.err.println("Couldn't listen on port: 4444");
    System.exit(1);
  }
  System.out.println("Server started!");
  
  while(listening){
     new kkmsthread(serverSocket.accept()).start();
     System.out.println("New server thread started");
  }
  
  serverSocket.close();
}
}
