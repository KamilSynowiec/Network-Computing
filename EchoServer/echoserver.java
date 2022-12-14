import java.io.*;
import java.net.*;

public class echoserver
{
  public static void main(String[]args) throws IOException
  {
    //Declare an object to store computer's name
    InetAddress computerAddr=null;
    
    //store the local computer's name
    try
    {
      computerAddr=InetAddress.getLocalHost();  //get local host returns local computer's name and IP address(together)
    }
    catch(UnknownHostException e)
    {
      System.out.println(e);
    };
    
    System.out.println("The address of this computer is: "+computerAddr.getHostName());   //get host name returns local computer's name only
  
    ServerSocket serverSocket=null;
    try
    {
      serverSocket=new ServerSocket(4321);
    }
    catch(IOException e)
    {
      System.err.println("Could not listen on port: 4321.");
      System.exit(1);
    }
    
    System.out.println("Echo server up and waiting");
    
    Socket clientSocket=null;
    try
    {
      clientSocket=serverSocket.accept(); //listen for incoming TCP requests
    }
    catch(IOException e)
    {
      System.err.println("Server socket failed");
      System.exit(1);
    }
    
    //connect the input and the output to and from the socket
    PrintWriter echoOutput = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader echoInput=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
    String inputLine, outputLine;
    
    while((inputLine=echoInput.readLine())!=null)
    {
      outputLine=inputLine;
      
      echoOutput.println(outputLine);
    }
  }
}
