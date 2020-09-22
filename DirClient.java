import java.io.*;
import java.net.*;
public class DirClient {
    private String path;

    public DirClient(String path) {
        this.path = path;
    }

    public String getListing() {
        String result = null;
        try {
            // Initialization
            Socket socket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            socket = new Socket("localhost", 8081);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String fromServer = null;
            // args[0] needs to changed
//            out.println(args[0]);
            out.println(this.path);
            while ((fromServer = in.readLine()) != null) {
                result += fromServer + "\n";
            }
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Error\n");
        }
        return result;
    }

}
