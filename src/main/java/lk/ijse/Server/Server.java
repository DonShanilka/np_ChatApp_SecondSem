/* Created By Sithira Roneth
 * Date :1/17/24
 * Time :22:09
 * Project Name :Chat_Application
 * */
package lk.ijse.Server;

import lk.ijse.Server.Handler.Handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private static Server server;
    private final ServerSocket serverSocket;
    private Server() throws IOException {
        serverSocket = new ServerSocket(3200);
        System.out.println("Server Started");
    }
    public static Server getServerSocket() throws IOException {
        return server == null ? server = new Server() : server;
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            System.out.println("listening.......");
            try {
                Socket accepted = serverSocket.accept();
                Handler clientHandler = new Handler(accepted);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
