import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;

/**
 * @author Brian Duong
 * @version 2020
 */
public class HttpRequest {
	private Socket socket = null;
	private String path;
	private String userAgent = "";
	private PrintWriter out;
	private BufferedReader in;

	public HttpRequest(Socket socket) {
		this.socket = socket;
	}

	public void parseRequest(){
		try {
//			PrintWriter out = null;
//			BufferedReader in = null;
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputLine;
			String allInputLines = "";

//			while ((inputLine = this.in.readLine()) != null) {
//				allInputLines += inputLine + " ";
//			}



//			String[] inputs = allInputLines.split(" ");
//
//			System.out.println(inputs[0]);
//
//			for (int i = 0; i < inputs.length; i++) {
//				if (inputs[i].equals("User-Agent:")) {
//					i++;
//					while (!inputs[i].equals("Accept:")) {
//						this.userAgent += inputs[i] + " ";
//						i++;
//					}
//					i = inputs.length;
//				}
//			}
//			String browserURL = inputs[1];
//			System.out.println(browserURL);
//			this.path = browserURL.split("path=")[1];
//			System.out.println(this.path);
			// localhost:8081/?path=windows
			// localhost:8081/hits/?path=windows


//			System.out.println(this.userAgent);

//			in.close();
//			this.socket.close();
		} catch (Exception e) {
			System.out.println("Exception in thread: " + Thread.currentThread().getId()+"\nMessage: "+e.getMessage()+"\n"
			+ "this is from the parseRequest");
		}
	}

	public PrintWriter getWriter() throws IOException {
		return this.out;
	}

	public String getParameter() {
		return this.path;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void closeSocket() throws IOException {
		try {
			this.in.close();
			this.out.close();
			this.socket.close();
		} catch (Exception e) {
			System.out.println("Exception in thread: " + Thread.currentThread().getId()+"\nMessage: "+e.getMessage()+"\n"
			 + "This is from the close socket");
		}
	}

//	public void test() {
//		this.out.println("HTTP/1.1 200 ok\r\n");
//		this.out.println("Content-Type: text/html\r\n\r\n");
//		this.out.println("<li><button type=\"button\"> Hellllllllo   www</button></li>");
//
//	}

}
