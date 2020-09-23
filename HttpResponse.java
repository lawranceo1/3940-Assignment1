import java.io.File;
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

	public void streamResultsBrowser() {
		try {
			String method = "HTTP/1.1 200 ok";
			this.out.println(method);
			this.out.println(this.contentType);
			this.out.println(this.body);
		} catch (Exception e) {
			System.out.println("Exception in thread: " + Thread.currentThread().getId()+"\nMessage: "+e.getMessage()+"\n"
					+ "Error in HttpResponse");

		}
	}

	public void streamResultsClient() {
		File dir = new File("c:\\windows");
		String[] chld = dir.list();
		if(chld == null){
			this.out.println("Invalid Directory\n");
		}else{
			for(int i = 0; i < chld.length; i++){
				String fileName = chld[i];
				this.out.println(fileName+"\n");
			}
		}
		return;
	}

}
