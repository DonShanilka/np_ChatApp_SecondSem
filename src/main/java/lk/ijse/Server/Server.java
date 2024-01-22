package lk.ijse.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Handler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        Socket socket;

        while (true){
            System.out.println("Server Started");
            socket = serverSocket.accept();
            Handler clientThread = new Handler(socket,clients);
            System.out.println("Client connected");
            clientThread.start();
        }

    }
}
