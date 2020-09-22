import java.io.PrintWriter;

/**
 * @author Brian Duong
 * @version 2020
 */
public class HttpResponse {
	private String contentType = "Content-Type: text/html\r\n\r\n";
	private String body = "";
	private PrintWriter out;



	public void setContentType(String type) {
		this.contentType = "Content-Type: " + type + "\r\n\r\n";
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setPrintWriter(PrintWriter out) {
		this.out = out;
	}

	public void streamResults() {
		try {
			String method = "HTTP/1.1 200 ok";
			this.out.println(method);
			System.out.println("method");

			this.out.println(this.contentType);
			System.out.println("content");

			this.out.println(this.body);
			System.out.println("body");


//			System.out.println("out");

		} catch (Exception e) {
			System.out.println("Exception in thread: " + Thread.currentThread().getId()+"\nMessage: "+e.getMessage()+"\n"
					+ "Error in HttpResponse");

		}
	}
}
