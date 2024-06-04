package SimpleUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Reciever {
    
    public Reciever() throws Exception{

        DatagramSocket socket = new DatagramSocket(2020);
        System.out.println("Reciever is running");
        Scanner Keyboard = new Scanner(System.in);

        byte[] buffer = new byte[1500]; //  MTU = 1500 (max transaction unit)
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet); // retrivening sender's messege

        String message = new String(buffer).trim();
        System.out.println("recieved: " + message);
        
        InetAddress sender_address = packet.getAddress();
        int senders_port = packet.getPort();

        System.out.println("Enter your message: ");
        message = Keyboard.nextLine();
        buffer = message.getBytes();
        packet = new DatagramPacket(buffer, buffer.length, sender_address, senders_port);
        socket.send(packet);

        System.out.println("sent: "+ message);
    }
    
    public static void main(String[] args) {
      try {
        new Reciever();
      } catch (Exception e) {
        e.printStackTrace();
      }  
    }
}
