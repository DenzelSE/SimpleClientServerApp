package SimpleTCPMultithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    public Client() throws Exception {
        
        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successful connection to the server");

        BufferedReader in_soc = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_soc = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = in_soc.readLine();
        System.out.println("Server says: "+ message);
        out_soc.println("Thanks");

        socket.close();
        System.out.println("Socket closed");
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
