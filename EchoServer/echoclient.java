import java.io.*;
import ajva.net.*;

public class echoclient
{
  public static void main(String[]args) throws IOException
  {
    //set up the socket, in and out variables
    Socket echoSocket=null;
    PrintWriter echoClientOutput=null;
    BufferedReader echoClientInput=null;
    
    try
    {
      echoSocket=new Socket("localhost", 4321);  //make the connection to the server socket
      
      //create the output and input
      echoClientOutput=new PrintWriter(echoSocket.getOutputStream(),true);
      echoClientInput=new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
     
    }catch(UnknownHostException e)
    {
      System.err.println("Can't find host");
      System.exit(1);
    }
    catch(IOException e)
    {
      System.err.println("Couldn't get I/O for the connection to: 4321");
      System.exit(1);
    }
    
    //connect the user input
    BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
    String fromUser;
    String fromServer;
    
    while(true)
    {
      fromUser=stdln.readLine();   //read from the user using method .readLine() of BufferedReader class
      if(fromUser!=null)
      {
        System.out.println("Client: "+fromUser);
        echoClientOutput.println(fromUser); //write to the server
      }
      
      fromServer=echoClientInput.readLine(); //wait and read from the server
      System.out.println("Server: "+fromServer);
    }
    
  }
}
