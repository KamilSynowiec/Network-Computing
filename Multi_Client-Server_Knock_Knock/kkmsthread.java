import java.io.*;
import java.net.*;

public class kkmsthread extends Thread
{

  private Socket socket;
  
  public kkmsthread(Socket socket)
  {
    super("kkmsthread");
    this.socket=socket;
  }
  
  public void run()
  {
    
    try
    {
      System.out.println("Initialising I/O connections and state objects");
      
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream());
                 
      String inputLine, outputLine;
      kkstate kks = new kkstate();
      outputLine=new kks.processInput(null);
      out.println(outputLine);
      
      while((inputLine=in.readLine())!=null)
      {
        outputLine=kks.processInput(inputLine);
        out.println(outputLine);
        
        if(outputLine.equals("Bye"))
          break;
      }    
                                             
       out.close();
       in.close();
       socket.close(); 
                                             
    }catch(IOException e)
    {
      e.printStackTrace();
    }
  
  }
 }
