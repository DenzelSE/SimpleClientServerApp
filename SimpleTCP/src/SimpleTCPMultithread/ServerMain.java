package SimpleTCPMultithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    
    private int clientNumber = 1;
    
    public ServerMain() throws Exception{
        
        ServerSocket server_socket = new ServerSocket(2024);
        System.out.println("Port 2024 opened now");

        while(true){
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket, this);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
    }
    

    public int getClientNumber() {
        return clientNumber++;
    }

    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
