package SimpleUDP;

import java.net.DatagramSocket;

public class Reciever {
    
    public Reciever() throws Exception{

        DatagramSocket socket = new DatagramSocket(2020);
    }
    
    public static void main(String[] args) {
      try {
        new Reciever();
      } catch (Exception e) {
        e.printStackTrace();
      }  
    }
}
