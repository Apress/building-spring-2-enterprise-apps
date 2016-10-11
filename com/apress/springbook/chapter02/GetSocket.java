package com.apress.springbook.chapter02;

public class GetSocket {

    public static void main(String[] args) throws java.io.IOException {
	javax.net.SocketFactory factory = javax.net.SocketFactory.getDefault();

        java.net.Socket socket = factory.createSocket("localhost", 80);

	System.out.println(socket.isConnected());

	socket.close();

	System.out.println("\n\r" + socket.isConnected());
    }

}
