import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server()throws Exception{
        ServerSocket serverSoc = new ServerSocket(2020);
        System.out.println("Port is open"); 

        Socket socket = serverSoc.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected.");

        //I/O buffers:

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        out_socket.println("Welcome!");// send to client
        String message = in_socket.readLine();
        System.out.println("Client says : "+ message); //dispaly clients message in the console

        socket.close();
        System.out.println("Socket is closed.");

    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
