/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;
import java.util.*;

public class _MulticastServer {

    protected MulticastSocket socket = null;
    private long FIVE_SECONDS = 5000;
    private InetAddress group;
    private int port = 4445;

    public _MulticastServer() throws IOException {
        InetSocketAddress ina = new InetSocketAddress("192.168.1.4", port);
        socket = new MulticastSocket(ina);
        System.out.println("Default TTL = " + socket.getTimeToLive());
        group = InetAddress.getByName("230.0.0.1");

        socket.setSendBufferSize(65536);
        System.out.println("Max size = " + socket.getSendBufferSize());
    }

    public void run() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int count = (int) (Math.random() * 10000);

        while (true) {
            try {
                byte[] buf;
                String str = "hello world " + count;
                count++;
                System.out.println("Publishing : " + str);

                baos.reset();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.reset();
                oos.writeObject(str);
                oos.flush();
                buf = baos.toByteArray();

// send it
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);
                socket.send(packet);

// sleep for a while
                try {
                    Thread.sleep((long) (Math.random() * FIVE_SECONDS));
                } catch (InterruptedException e) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            _MulticastServer ms = new _MulticastServer();
            ms.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
