import java.io.*;
import java.net.*;
import java.net.http.HttpRequest;

public class HttpOverTcp2 {
    public static void main(String[] args) throws IOException {
        try (
            Socket kkSocket = new Socket("localhost", 8081);
            
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
            System.out.println(kkSocket.getReceiveBufferSize());
            
            String fromServer;
            String fromUser;
            // No matter what I send to the server I will always get a response.

		//out.println("GET /tomcat.png HTTP/1.0\n\r\n\r");
                //  out.println("GET /midp/hits?path=windows HTTP/1.0\r\n\r\n");
				//out.println("GET thisisatest HTTP/1.0\r\n\r\n");
				out.println("This is a second test");
            while ((fromServer = in.readLine()) != null) {
                System.out.println(fromServer);
            }
        } catch (Exception e) {
            System.err.println("Some Error ");
            System.exit(1);
        } 
    }
}
