/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;
import java.util.*;

public class _MulticastClient {

    public static void main(String[] args) throws IOException {
        int port = 4445;

//        InetSocketAddress ina = new InetSocketAddress("localhost", port);
        MulticastSocket socket = new MulticastSocket(port);
        System.out.println("Default TTL = " + socket.getTimeToLive());
        InetAddress address = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(address);

        socket.setReceiveBufferSize(65536);
        System.out.println("Max size = " + socket.getReceiveBufferSize());

        DatagramPacket packet;
        boolean done = false;
        ByteArrayInputStream bais;
        ObjectInputStream ois;
        String received;
        while (!done) {
            try {
                byte[] buf = new byte[65536];
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

// String received = new String(packet.getData(), 0, packet.getLength());
                bais = new ByteArrayInputStream(buf);
                ois = new ObjectInputStream(bais);
                received = (String) ois.readObject();
                System.out.println("Received = " + received);
            } catch (Exception ie) {
                ie.printStackTrace();
                done = true;
            }
        }

        socket.leaveGroup(address);
        socket.close();
    }
}
