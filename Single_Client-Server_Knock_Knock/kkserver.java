import java.net.*;
import java.io.*;

public class kkserver{
  public static void main(String[]args)throws IOException{
    InetAddress computerAddr.getLocalHost();
    
    try{
      computerAddr=InetAddress.getLocalHost();
    }catch(UnknownHostException e){
      System.out.println(e);
    }
    
    System.out.println("The address of this computer is... "+computerAddr.getHostName());
    
    ServerSocket serverSocket=null;
    try{
      serverSocket=new ServerSocket(4444);
    }catch(IOException e){
      System.err.println("Couldn't listen on port: 4444");
      System.exit(1);
    }
    
    System.out.println("Server up and waiting");
    
    Socket clientSocket=null;
    try{
      clientSocket=serverSocket.accept();
    }catch(IOException e){
      System.err.println("Accept failed.");
      System.exit(1);
    }
    
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    String inputLine, outputLine;
    
    kkstate kks = new kkstate();
    
    outputLine=kks.processInput(null);
    
    out.println(outputLine);
    
    while((inputLine=in.readLine())!=null){
      outputLine=kks.processInput(inputLine);
      out.println(outputLine);
      if(outputLine.equals("Bye."))
        break;
    }
    
    out.close();
    in.close();
    clientSocket.close();
    serverSocket.close();
    
  }

}
