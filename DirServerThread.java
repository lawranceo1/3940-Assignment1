import java.net.*;
import java.io.*;

public class DirServerThread extends Thread {
   private Socket socket = null;
   public DirServerThread(Socket socket) { 
      super("DirServerThread");
      this.socket = socket;
   }
   public void run() {   
      try {
      	HttpRequest httpRequest = new HttpRequest(this.socket);
		HttpResponse httpResponse = new HttpResponse();

      	httpRequest.parseRequest();

      	httpResponse.setPrintWriter(httpRequest.getWriter());

      	if (httpRequest.getBrowserRequest()) {
      		DirServlet dirServlet = new DirServlet();
	      	dirServlet.doGet(httpRequest, httpResponse);

	      	httpResponse.streamResultsBrowser();
	      } else {
	      	httpResponse.streamResultsClient();
	      }
      	httpRequest.closeSocket();




      } catch (Exception e) {
              System.out.println("Exception in thread: " + Thread.currentThread().getId()+"\nMessage: "+e.getMessage()+"\n"
              + "Error in the DirServerThread");
      }
  }
}

