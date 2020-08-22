/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vpc
 */
public class TestMultiCast {

    public String multicastAddress = "231.192.1.2";
    public static final int defaultMulticastPort = 7777;

    public static void main(String[] args) {
        TestMultiCast testMultiCast = new TestMultiCast();
        if (args[0].equals("-s")) {
            testMultiCast.server();
        } else {
            testMultiCast.client();
        }
    }

    private static class IteratorEnum<T> implements Iterable<T>, Iterator<T> {

        private Enumeration<T> e;

        public IteratorEnum(Enumeration<T> e) {
            this.e = e;
        }

        public Iterator<T> iterator() {
            return this;
        }

        public boolean hasNext() {
            return e.hasMoreElements();
        }

        public T next() {
            return e.nextElement();
        }

        public void remove() {
        }
    }

    private void server() {
        try {
            for (NetworkInterface networkInterface : new IteratorEnum<NetworkInterface>(NetworkInterface.getNetworkInterfaces())) {
                System.out.println(networkInterface);
            }

        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        while (true) {
            MulticastSocket ms = null;
            try {

                ms = new MulticastSocket(defaultMulticastPort);
                ms.setNetworkInterface(NetworkInterface.getByName("eth0"));
                InetAddress group = InetAddress.getByName(multicastAddress);
                ms.joinGroup(group);
                System.out.println("joined " + group);
                byte[] buffer = new byte[1024];
                //noinspection InfiniteLoopStatement
                while (true) {
                    DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                    System.out.println("wainting on " + group + ":" + defaultMulticastPort);
                    ms.receive(dp);
                    String s = new String(dp.getData(), 0, dp.getLength());
                    System.out.println("recieved : " + s + " from " + dp.getAddress() + ":" + dp.getPort());
                }
            } catch (BindException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            } finally {
                if (ms != null) {
                    ms.close();
                }
            }
        }
    }

    private void client() {
        int x = 0;
        while (true) {
            try {
                String v = "hello " + x;
                x++;
                byte[] data = v.getBytes();
                MulticastSocket ms = new MulticastSocket();
                ms.setNetworkInterface(NetworkInterface.getByName("eth0"));
                ms.setTimeToLive(1);
                InetAddress group = InetAddress.getByName(multicastAddress);
                DatagramPacket dp = new DatagramPacket(data, data.length, group, defaultMulticastPort);
                ms.send(dp);
                ms.close();
                System.out.println("sent " + v + " to " + group + ":" + defaultMulticastPort);
                Thread.sleep(1000);
            } catch (Exception se) {
                System.err.println(se);
            }
        }
    }
}
