package SimpleTCPMultithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    
    public ServerMain() throws Exception{
        
        ServerSocket server_socket = new ServerSocket(2024);
        System.out.println("Port 2024 opened now");

        while(true){
            Socket socket = server_socket.accept();
            ServerThread server_thread = new ServerThread(socket);
            Thread thread = new Thread(server_thread);
            thread.start();
        }
         
    }

    public static void main(String[] args) {
        try {
            new ServerMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
