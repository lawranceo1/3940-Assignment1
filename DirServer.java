import java.net.*;
import java.io.*;
public class DirServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null; boolean listening = true;
        try {
            serverSocket = new ServerSocket(8081);
        } catch (Exception e) {
            System.err.println("Error Creating Socket\n");
            System.exit(-1);
        }
        while (listening)
	        new DirServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}
