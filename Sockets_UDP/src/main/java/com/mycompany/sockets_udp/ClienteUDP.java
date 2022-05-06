/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sockets_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angeles
 */
public class ClienteUDP {

    public static void main(String[] args) throws IOException {

        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];

        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "¡Hola, desde el cliente!";
            buffer = mensaje.getBytes();
            
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            System.out.println("Envio Datagrama");
            socketUDP.send(pregunta);
            
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            
            System.out.println("Recibo peticion");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);
            socketUDP.close();

        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
