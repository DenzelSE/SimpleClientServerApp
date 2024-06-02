package SimpleTCPMultithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
    
    private Socket socket;
    private ServerMain serverMain;

    public ServerThread(Socket socket, ServerMain serverMain){
        this.socket = socket;
        this.serverMain = serverMain;
    }

    @Override
    public void run(){
        try {

            int clientNumber = serverMain.getClientNumber();

            System.out.println("Client " + clientNumber + " has Connected");
            
            // Input output buffers:
            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            out_socket.println("Welcome! What's your name?");
            String message = in_socket.readLine();
            System.out.println("Client: " + message);

            socket.close();
            System.out.println("Client "+ clientNumber + " has disConnected");
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
