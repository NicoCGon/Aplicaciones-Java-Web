package Collections;

import java.io.*;
import java.net.*;
import java.util.logging.*;
public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket ss;
        System.out.print("Iniciando servidor");
        try {
            ss = new ServerSocket(10578);
            System.out.println("\n Estado Normal");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ((ServerThread) new ServerThread(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
