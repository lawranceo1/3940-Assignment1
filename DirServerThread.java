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

////      	httpRequest.test();
		DirServlet dirServlet = new DirServlet();
		dirServlet.doGet(httpRequest, httpResponse);

	    httpResponse.setPrintWriter(httpRequest.getWriter());
		httpResponse.streamResults();

		httpRequest.closeSocket();





//         PrintWriter out = null;
//         BufferedReader in = null;
//         out = new PrintWriter(socket.getOutputStream(), true);
//         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         String inputLine, outputLine;
         /*
         When getting input from a client all of the things typed
         after "DirClient" are set to DirServerThread as a string.

         Using in.readLine() will give you the string of what the client has sent.
         Once DirServerThread is given the string it will input the string into
         File dir. dir will then use .list() which returns an array of files
         and directories in the directory defined by the abstract path name
         (in this case we are sending the server c:\windows).
          */
//         inputLine = in.readLine();
//	      System.out.println("This is what inputLine is: " + inputLine);

	      /**
	      This while loop will show you the string that is passed to File dir.
	      The code only gets the first line

	       **** SOMETHING IS WRONG HERE
	       */
//		 while ((inputLine = in.readLine()) != null) {
// 			 System.out.println(inputLine);
//		 }





//	      out.println("HTTP/1.0 200 ok");
////		 out.println("Connection: close\r\n");
//	      out.println("Content-Type: text/html\r\n\r\n");
//
//	      String topPart = "<!DOCTYPE html><html><body><ul>";
//	      String bottomPart = "</ul></body></html>";
//	      String tempInput = "Hello world!!!!!";
//	      String test = "<li><button type=\"button\">"+ tempInput +"</button></li>";
//	      out.println(topPart+ test +bottomPart);
////	      out.println( test);

	      /**
	       This is the code that allows you to access all of the files and
	       directories of the input given from the client

	       */

//         File dir = new File("c:\\windows");
//         String[] chld = dir.list();
//         if(chld == null){
//            out.println("Invalid Directory\n");
//         }else{
//      		for(int i = 0; i < chld.length; i++){
//        			String fileName = chld[i];
//        			out.println("<li><button type=\"button\">" +fileName+ "</button></li>");
//               }
//         }

	      /**
	       This is the start of the code where it should output a
	       html wrapped string for a browser to process.
	       */

//	      String input[] = inputLine.split(" ");
//
//	      if (!input[0].equals("GET")) {
//	      	out.println("hello there person");
//
//
//	      }
//	      out.println("outsideof if statement");

//	      try {

//	      HttpRequest httpRequest = new HttpRequest(this.socket);

	      /*
	      HttpRequest = your own class
	      .parse // Read request, what is the path what is the user agent
	      .getParameter
	      .getUserAgent
	      HttpResponse = new HttpResponse
	      HttpRequest.parseRequest()
	      DirServlet dirServlet = new DirServlet(); // Similar to the hitServlet file
	      dirServelet.doGet(httpRequest, httpResponse);
	      httpResponse.streamResults
	      out put stream on the socket
	      close the socket on streamResults
	      String tokenization for request data
	       */

//
//	      } catch (Exception e) {
//
//	      }



//	      out.close(); in.close(); socket.close();
      } catch (Exception e) {
              System.out.println("Exception in thread: " + Thread.currentThread().getId()+"\nMessage: "+e.getMessage()+"\n"
              + "Error in the DirServerThread");
      }
  }
}

