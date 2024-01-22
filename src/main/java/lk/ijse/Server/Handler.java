package lk.ijse.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Handler extends Thread{
    private ArrayList<Handler> client;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Handler(Socket socket, ArrayList<Handler>client) {
        try {
            this.socket = socket;
            this.client = client;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }
                for (Handler handler : client) {
                    writer.println(msg);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
