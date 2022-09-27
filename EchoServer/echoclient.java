import java.io.*;
import ajva.net.*;

public class echoclient
{
  public static void main(String[]args) throws IOException
  {
    //set up the socket, in and out variables
    Socket echoSocket=null;
    PrintWriter echoClientOutput=null;
    BufferedWriter echoClientInput=null;
    
    try
    {
      echoSocket=new Socket("localhost", 4321);
      
      echoClientOutput=new PrintWriter(echoSocket.getOutputStream(),true);
      echoClientInput=new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
     
    }
    catch(UnknownHostException e)
    {
      System.err.println("Couldn't get I/O for the connection to: 4321");
      System.exit(1);
    }
  }
}
