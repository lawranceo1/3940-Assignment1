import java.io.*;
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
	private boolean browserRequest = true;

	public HttpRequest(Socket socket) {
		this.socket = socket;
	}

	public void parseRequest(){
		try {
			this.out = new PrintWriter(socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputLine;
			String allInputLines = "";

			while ((inputLine = this.in.readLine()) != null && !inputLine.isEmpty()) {
				allInputLines += inputLine + " ";
			}

			String[] inputs = allInputLines.split(" ");

			if (inputs[0].equals("c:\\windows")) {
				this.browserRequest = false;
				return;
			}

			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i].equals("User-Agent:")) {
					i++;
					while (!inputs[i].equals("Accept:")) {
						this.userAgent += inputs[i] + " ";
						i++;
					}
					i = inputs.length;
				}
			}
			String browserURL = inputs[1];
			System.out.println(browserURL);
			this.path = browserURL.split("=")[1];
			System.out.println(this.path);

			System.out.println(this.userAgent);


		} catch (Exception e) {}
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

	public boolean getBrowserRequest() {
		return this.browserRequest;
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

}
