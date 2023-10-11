/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Ваня
 */
public class App {
    private static final String HOST="www.kst.tugab.bg";
    private static final int START_PORT=1;
    private static final int END_PORT=1024;
    public static void main(String[] args) throws UnknownHostException, IOException {
        try{
            InetAddress ip=InetAddress.getByName(HOST);
            for(int port=START_PORT;port<=END_PORT;port++){
                InetSocketAddress socketAddress=new InetSocketAddress(ip, port);
                Socket socket=new Socket();
                int TIMEOUT=1000;
                try{
                    socket.connect(socketAddress,TIMEOUT);
                    System.out.println("Uslugata na host "+HOST+" na port "+port+" e aktivna.");
                }catch(IOException ex){
                    System.out.println("Usluga na host "+HOST+" na port "+port+" ne e aktivna");
                }finally{
                    socket.close();
                }
            }
        }catch(Exception ex){
            System.out.println("Greshka: "+ex.getMessage());
        }
    }
}
